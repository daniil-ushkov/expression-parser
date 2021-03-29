package expression.classes;

public class ExpressionException extends RuntimeException {
    public ExpressionException(String type, String expression) {
        super(type + " : " + expression);
    }
}
