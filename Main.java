package expression;

import expression.classes.TripleExpression;
import expression.parser.ExpressionParser;
import expression.parser.ParserException;

public class Main {
    public static void main(String[] args) throws ParserException {
        TripleExpression expression = new ExpressionParser().parse("log2(1, 2)");
        System.out.println(expression.evaluate(2, 2, 8));
    }
}
