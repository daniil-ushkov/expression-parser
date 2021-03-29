package expression.parser;

import expression.classes.CommonExpression;
import expression.classes.ExpressionException;
import expression.classes.TripleExpression;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Parser {
    TripleExpression parse(String expression) throws ExpressionException, ParserException;
}