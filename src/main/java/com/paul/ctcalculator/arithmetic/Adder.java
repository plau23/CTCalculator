package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the add expression
 */
public class Adder extends Expression {

    public Adder(iExpression left, iExpression right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return Left.getValue() + Right.getValue();
    }
}
