package expression.classes;

public class Log extends BinaryOperation {

    public Log(TripleExpression ex1, TripleExpression ex2) {
        super(ex1, ex2, "//");
    }

    @Override
    protected int calculate(int first, int second) {
        return Utilities.log(second, first);
    }

    @Override
    protected void throwExceptions(int first, int second) throws ExpressionException {
        if (first <= 0) {
            throw new InvalidArgumentException("non-positive argument", this);
        }
        if (second < 0 || second == 1) {
            throw new InvalidArgumentException("Invalid base", this);
        }
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
