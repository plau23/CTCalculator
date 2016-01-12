package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the subtract expression
 */
public class Subtracter extends BinaryExpression {

    public Subtracter(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return Left.getValue() - Right.getValue();
    }
}
