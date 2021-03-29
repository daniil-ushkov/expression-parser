package expression.classes;

public class Log2 extends UnaryOperation {
    public Log2(TripleExpression expression) {
        super(expression, "log2 ");
    }

    @Override
    protected int calculate(int value) {
        return Utilities.log(2, value);
    }

    @Override
    protected void throwExceptions(int value) throws ExpressionException {
        if (value <= 0) {
            throw new InvalidArgumentException("non-positive argument", this);
        }
    }
}
