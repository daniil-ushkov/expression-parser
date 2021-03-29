package expression.classes;

public class Divide extends BinaryOperation {
    public Divide(TripleExpression el1, TripleExpression el2) {
        super(el1, el2, "/");
    }

    @Override
    protected int calculate(int first, int second) {
        return first / second;
    }

    @Override
    protected void throwExceptions(int first, int second) throws ExpressionException {
        if (second == 0) {
            throw new DivisionByZeroException(this);
        }
        if (first == Integer.MIN_VALUE && second == -1) {
            throw new OverflowException(this);
        }
    }

//    @Override
//    public int evaluate(int value) {
//        return ex1.evaluate(value) / ex2.evaluate(value);
//    }
//
//    @Override
//    public double evaluate(double value) {
//        return ex1.evaluate(value) / ex2.evaluate(value);
//    }



    @Override
    public int getPriority() {
        return 1;
    }
}