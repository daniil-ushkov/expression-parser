package expression.parser;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public abstract class BaseParser {
    private final ExpressionSource source;
    protected char ch;

    protected BaseParser(final ExpressionSource source) {
        this.source = source;
    }

    protected void nextChar() throws ParserException {
        ch = source.hasNext() ? source.next() : '\0';
    }

    protected void prevChar() throws ParserException {
        ch = source.hasPrev() ? source.prev() : '\0';
    }


    protected boolean test(char expected) throws ParserException {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected boolean test(final String expected) throws ParserException {
        int shift = 0;
        for (char c : expected.toCharArray()) {
            if (test(c)) {
                shift++;
            } else {
                for (int i = 0; i < shift; i++) {
                    prevChar();
                }
                return false;
            }
        }
        return true;
    }

    protected boolean softTest(final char expected) {
        return ch == expected;
    }

    protected boolean softTest(final String expected) throws ParserException {
        int shift = 0;
        boolean answer = true;
        for (char c : expected.toCharArray()) {
            if (test(c)) {
                shift++;
            } else {
                answer = false;
                break;
            }
        }
        for (int i = 0; i < shift; i++) {
            prevChar();
        }
        return answer;
    }


    protected void expect(final char c) throws ParserException {
        if (ch != c) {
            throw error("Expected '" + c + "', found '" + ch + "'");
        }
        nextChar();
    }

    protected void expect(final String value) throws ParserException {
        for (char c : value.toCharArray()) {
            expect(c);
        }
    }

    protected ParserException error(final String message) {
        return source.error(message);
    }


    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }
}
