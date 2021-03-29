package expression.classes;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface TripleExpression extends CommonExpression, ToMiniString {
    int evaluate(int x, int y, int z);
}
