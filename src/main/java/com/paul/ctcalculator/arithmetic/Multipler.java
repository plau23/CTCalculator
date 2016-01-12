package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the multiple expression
 */
public class Multipler extends BinaryExpression {

    public Multipler(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return Left.getValue() * Right.getValue();
    }
}
