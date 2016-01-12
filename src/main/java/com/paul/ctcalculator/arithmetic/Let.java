package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the binary expression
 */
public class Let extends Expression {

    public Let(iExpression left, iExpression right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return Left.getValue() + Right.getValue();
    }
}
