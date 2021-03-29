package expression.classes;

public class Pow2 extends UnaryOperation {
    public Pow2(TripleExpression expression) {
        super(expression, "pow2 ");
    }

    @Override
    protected int calculate(int value) {
        return 1 << value;
    }

    @Override
    protected void throwExceptions(int value) throws ExpressionException {
        if (value >= 32) {
            throw new OverflowException(this);
        }
        if (value < 0) {
            throw new OverflowException(this);
        }
    }
}
