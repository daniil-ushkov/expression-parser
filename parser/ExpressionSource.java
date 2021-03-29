package expression.parser;

public interface ExpressionSource {
    boolean hasNext();
    boolean hasPrev();
    char next();
    char prev() throws ParserException;
    ParserException error(final String message);
}
