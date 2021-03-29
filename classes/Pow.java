package expression.classes;

public class Pow extends BinaryOperation {

    public Pow(TripleExpression ex1, TripleExpression ex2) {
        super(ex1, ex2, "**");
    }

    @Override
    protected int calculate(int first, int second) {
        return Utilities.pow(first, second);
    }

    @Override
    protected void throwExceptions(int first, int second) throws ExpressionException {
        if (second < 0) {
            throw new InvalidArgumentException("non-positive degree", this);
        }
        if (first == 0 && second == 0) {
            throw new InvalidArgumentException("pow(0, 0) is invalid expression", this);
        }
        try {
            Utilities.pow(first, second);
        } catch (OverflowException e) {
            throw new OverflowException(this);
        }
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
