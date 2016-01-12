package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the multiple expression
 */
public class Multipler extends Expression {

    public Multipler(iExpression left, iExpression right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return Left.getValue() * Right.getValue();
    }
}
