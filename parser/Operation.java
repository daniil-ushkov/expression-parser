package expression.parser;

import expression.classes.TripleExpression;

public interface Operation {
    TripleExpression get(TripleExpression ex1, TripleExpression ex2);
}
