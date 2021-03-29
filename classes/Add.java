package expression.classes;

public class Add extends BinaryOperation implements Assosiative {
    public Add(TripleExpression el1, TripleExpression el2) {
        super(el1, el2, "+");
    }

    @Override
    protected int calculate(int first, int second) {
        return first + second;
    }

    @Override
    protected void throwExceptions(int first, int second) throws ExpressionException {
        if ((first >= 0 && second >= 0 && (first > Integer.MAX_VALUE - second))
                        || (first <= 0 && second <= 0 && (first < Integer.MIN_VALUE - second))) {
            throw new OverflowException(this);
        }
    }

//    @Override
//    public int evaluate(int value) {
//        return ex1.evaluate(value) + ex2.evaluate(value);
//    }
//
//    @Override
//    public double evaluate(double value) {
//        return ex1.evaluate(value) + ex2.evaluate(value);
//    }

    @Override
    public int getPriority() {
        return 3;
    }
}
