package expression.classes;

public abstract class UnaryOperation implements TripleExpression {
    private TripleExpression expression;
    private String symbol;

    public UnaryOperation(TripleExpression expression, String symbol) {
        this.expression = expression;
        this.symbol = symbol;
    }

    protected abstract int calculate(int value);

    protected abstract void throwExceptions(int value) throws ExpressionException;

    @Override
    public int evaluate(int x, int y, int z) {
        int value = expression.evaluate(x, y, z);
        throwExceptions(value);
        return calculate(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(symbol);
        sb.append("(");
        sb.append(expression.toString());
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String toMiniString() {
        if (expression instanceof BinaryOperation) {
            StringBuilder sb = new StringBuilder(symbol);
            sb.append("(");
            sb.append(expression.toMiniString());
            sb.append(")");
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder(symbol);
            sb.append(expression.toMiniString());
            return sb.toString();
        }
    }

    @Override
    public int getPriority() {
        return 1;
    }

}
