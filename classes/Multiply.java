package expression.classes;

public class Multiply extends BinaryOperation implements Assosiative {
    public Multiply(TripleExpression el1, TripleExpression el2) {
        super(el1, el2, "*");
    }

    @Override
    protected int calculate(int first, int second) {
        return first * second;
    }

    @Override
    protected void throwExceptions(int first, int second) throws ExpressionException {
        try {
            Utilities.multiplyOverflowChecker(first, second);
        } catch (OverflowException e) {
            throw new OverflowException(this);
        }
    }

    @Override
    public int getPriority() {
        return 1;
    }
}