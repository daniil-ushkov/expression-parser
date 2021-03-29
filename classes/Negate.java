package expression.classes;

public class Negate extends UnaryOperation {

    public Negate(TripleExpression expression) {
        super(expression, "-");
    }

    @Override
    protected int calculate(int value) {
        return -value;
    }

    @Override
    protected void throwExceptions(int value) {
        if (value == Integer.MIN_VALUE) {
            throw new OverflowException(this);
        }
    }
}
