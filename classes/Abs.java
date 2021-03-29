package expression.classes;

public class Abs extends UnaryOperation {

    public Abs(TripleExpression expression) {
        super(expression, "abs ");
    }

    @Override
    protected int calculate(int value) {
        return Math.abs(value);
    }

    @Override
    protected void throwExceptions(int value) {
        if (value == Integer.MIN_VALUE) {
            throw new OverflowException(this);
        }
    }
}
