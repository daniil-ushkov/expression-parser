package expression.classes;

public class OverflowException extends ExpressionException {
    public OverflowException(TripleExpression expression) {
        super("overflow", expression.toMiniString());
    }
}
