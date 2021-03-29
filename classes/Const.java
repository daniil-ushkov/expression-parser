package expression.classes;

public class Const implements TripleExpression {
    private final Number value;

    public Const(int value) {
        this.value = value;
    }

    public Const(double value) {
        this.value = value;
    }

//    @Override
//    public int evaluate(int value) {
//        return this.value.intValue();
//    }
//
//    @Override
//    public double evaluate(double value) {
//        return this.value.doubleValue();
//    }

    @Override
    public int evaluate(int x, int y, int z) {
        return this.value.intValue();
    }

    @Override
    public String toString() {
        if (value instanceof Integer) {
            return Integer.toString(value.intValue());
        } else {
            return Double.toString(value.doubleValue());
        }
    }

    public String toMiniString() {
        return toString();
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public boolean equals(Object expression) {
        if (expression == null) {
            return false;
        }
        return toString().equals(expression.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
