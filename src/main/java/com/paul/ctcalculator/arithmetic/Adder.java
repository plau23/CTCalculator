package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the add expression
 */
public class Adder extends BinaryExpression {

    public Adder(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return Left.getValue() + Right.getValue();
    }
}
