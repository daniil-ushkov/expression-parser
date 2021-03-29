package expression.classes;

public class DivisionByZeroException extends ExpressionException {
    public DivisionByZeroException(TripleExpression expression) {
        super("division by zero", expression.toMiniString());
    }
}
