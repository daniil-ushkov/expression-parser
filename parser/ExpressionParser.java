package expression.parser;

import expression.classes.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExpressionParser implements Parser {

    @Override
    public TripleExpression parse(final String expression) throws ParserException {
        return parse(new StringSource(expression));
    }

    private TripleExpression parse(ExpressionSource source) throws ParserException {
        return new SimpleParser(source).parseExpression('\0');
    }

    private static class SimpleParser extends BaseParser {
        private static Map<String, Integer> PRIORITIES = new LinkedHashMap<>();
        static {
            PRIORITIES.put("**", 4);
            PRIORITIES.put("//", 4);
            PRIORITIES.put("<<", 1);
            PRIORITIES.put(">>", 1);
            PRIORITIES.put("+", 2);
            PRIORITIES.put("-", 2);
            PRIORITIES.put("*", 3);
            PRIORITIES.put("/", 3);
        }

        private static Map<String, Operation> EXPRESSIONS = Map.of(
                "**", Pow::new,
                "//", Log::new,
                "<<", ShiftLeft::new,
                ">>", ShiftRight::new,
                "+", Add::new,
                "-", Subtract::new,
                "*", Multiply::new,
                "/", Divide::new
        );


        SimpleParser(ExpressionSource source) throws ParserException {
            super(source);
            nextChar();
        }

        private TripleExpression parseExpression(char stop) throws ParserException {
            skipWhitespace();
            TripleExpression operand = parseOperand(stop);
            TripleExpression parsed = parseBinaryOperation(operand, 1, stop);
            if (test(stop)) {
                return parsed;
            } else {
                if (stop == ')') {
                    throw error("Unclosed bracket");
                } else if (softTest(')')) {
                    throw error("Unopened bracket");
                } else {
                    throw error("Binary expression expected");
                }
            }
        }

        private TripleExpression parseOperand(final char stop) throws ParserException {
            skipWhitespace();
            if (test('(')) {
                TripleExpression result = parseBrackets();
                return result;
            } else if (between('0', '9')) {
                return parseNumber(false);
            } else if (test('-')) {
                if (between('0', '9')) {
                    return parseNumber(true);
                } else {
                    skipWhitespace();
                    return new Negate(parseOperand(stop));
                }
            } else if (Character.isJavaIdentifierStart(ch)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isJavaIdentifierPart(ch) && ch != stop && ch != '\0') {
                    sb.append(ch);
                    nextChar();
                }
                String word = sb.toString();
                switch (word) {
                    case "abs":
                        return new Abs(parseOperand(stop));
                    case "square":
                        return new Square(parseOperand(stop));
                    case "log2":
                        return new Log2(parseOperand(stop));
                    case "pow2":
                        return new Pow2(parseOperand(stop));
                    case "x":
                    case "y":
                    case "z":
                        return new Variable(word);
                }
                throw error("Illegal name of variable");
            } else {
                throw error("Operand expected");
            }
        }

        private String getSymbol() throws ParserException {
            for (Map.Entry<String, Integer> entry : PRIORITIES.entrySet()) {
                if (softTest(entry.getKey())) {
                    return entry.getKey();
                }
            }
            return null;
        }

        private TripleExpression parseBinaryOperation(TripleExpression begin, int priority, char stop) throws ParserException {
            skipWhitespace();
            String symbol = getSymbol();
            if (symbol == null || priority > PRIORITIES.get(symbol)) {
                return begin;
            }
            test(symbol);
            return parseBinaryOperation(
                    EXPRESSIONS.get(symbol).get(
                            begin,
                            parseBinaryOperation(
                                    parseOperand(stop),
                                    PRIORITIES.get(symbol) + 1,
                                    stop
                            )
                    ),
                    priority,
                    stop
            );
        }

        private TripleExpression parseBrackets() throws ParserException {
            return parseExpression(')');
        }

        private TripleExpression parseNumber(boolean negative) throws ParserException {
            StringBuilder number = new StringBuilder();
            while (between('0', '9')) {
                number.append(ch);
                nextChar();
            }
            TripleExpression expression;
            try {
                if (negative) {
                    expression = new Const(Integer.parseInt("-" + number.toString()));
                } else {
                    expression = new Const(Integer.parseInt(number.toString()));
                }
            } catch (NumberFormatException e) {
                throw error("Illegal number");
            }
            return expression;
        }

        private void skipWhitespace() throws ParserException {
            while (test(' ') || test('\r') || test('\n') || test('\t'));
        }
    }
}
