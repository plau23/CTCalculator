package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the divide expression
 */
public class Divider extends BinaryExpression {

    public Divider(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return Left.getValue() / Right.getValue();
    }
}
