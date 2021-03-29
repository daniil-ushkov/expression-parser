package expression.parser;

import expression.classes.ExpressionException;

public class ParserException extends Exception {
    public ParserException(int pos, String message) {
        super(Integer.toString(pos) + " : " + message);
    }

}
