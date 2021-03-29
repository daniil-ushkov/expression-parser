package expression.classes;

public class Square implements TripleExpression {
    private TripleExpression expression;

    public Square(TripleExpression expression) {
        this.expression = expression;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return expression.evaluate(x, y, z) * expression.evaluate(x, y, z);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("square (");
        sb.append(expression.toMiniString());
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String toMiniString() {
        if (expression instanceof BinaryOperation) {
            StringBuilder sb = new StringBuilder("square (");
            sb.append(expression.toMiniString());
            sb.append(")");
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder("square ");
            sb.append(expression.toMiniString());
            return sb.toString();
        }
    }

    @Override
    public int getPriority() {
        return 5;
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
