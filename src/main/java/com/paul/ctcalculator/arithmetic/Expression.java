package com.paul.ctcalculator.arithmetic;

/**
 * This abstract defines the binary expression
 */
public abstract class Expression implements iExpression {

    protected iExpression Left;
    protected iExpression Right;

    public Expression(iExpression left, iExpression right)
    {
        Left = left;
        Right = right;
    }

}
