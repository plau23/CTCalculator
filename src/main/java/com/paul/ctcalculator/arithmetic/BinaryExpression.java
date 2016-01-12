package com.paul.ctcalculator.arithmetic;

/**
 * This abstract defines the binary expression
 */
public abstract class BinaryExpression implements Expression{

    protected Expression Left;
    protected Expression Right;

    public BinaryExpression(Expression left, Expression right)
    {
        Left = left;
        Right = right;
    }

}
