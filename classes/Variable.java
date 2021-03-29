package expression.classes;

public class Variable implements TripleExpression {
    private String symbol;

    public Variable(String symbol) {
        this.symbol = symbol;
    }

//    @Override
//    public int evaluate(int value) {
//        return value;
//    }
//
//    @Override
//    public double evaluate(double value) {
//        return value;
//    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (symbol.equals("x")) {
            return x;
        }
        if (symbol.equals("y")) {
            return y;
        }
        return z;
    }

    @Override
    public String toString() {
        return symbol;
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
