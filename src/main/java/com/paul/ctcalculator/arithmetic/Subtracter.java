package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the subtract expression
 */
public class Subtracter extends Expression {

    public Subtracter(iExpression left, iExpression right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return Left.getValue() - Right.getValue();
    }
}
