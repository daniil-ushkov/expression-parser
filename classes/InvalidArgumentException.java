package expression.classes;

public class InvalidArgumentException extends ExpressionException {
    public InvalidArgumentException(String type, TripleExpression expression) {
        super(type, expression.toMiniString());
    }
}
