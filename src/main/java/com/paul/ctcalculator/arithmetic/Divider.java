package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the divide expression
 */
public class Divider extends Expression {

    public Divider(iExpression left, iExpression right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return Left.getValue() / Right.getValue();
    }
}
