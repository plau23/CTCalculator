package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the binary expression
 */
public class Let extends BinaryExpression {

    public Let(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return Left.getValue() + Right.getValue();
    }
}
