package expression.classes;

public class ShiftLeft extends BinaryOperation {
    public ShiftLeft(TripleExpression el1, TripleExpression el2) {
        super(el1, el2, "<<");
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
        return 4;
    }

    @Override
    public boolean equals(Object expression) {
        if (expression == null) {
            return false;
        }
        return toString().equals(expression.toString());
    }

    @Override
    protected int calculate(int first, int second) {
        return first << second;
    }

    @Override
    protected void throwExceptions(int first, int second) throws ExpressionException {

    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
