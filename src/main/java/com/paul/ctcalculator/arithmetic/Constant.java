package com.paul.ctcalculator.arithmetic;

import com.paul.ctcalculator.logger.Log;

/**
 * This class defines the constant
 *
 */
public class Constant implements Expression {

    private int value;

    private Constant(){};

    public Constant(int value)
    {
        if (Integer.MIN_VALUE >= value || value >=  Integer.MAX_VALUE)
        {
            Log.getInstance().Error("Integer Overflow");
            throw new ArithmeticException();
        }

        this.value = value;

    }

    @Override
    public int getValue() {
        return value;
    }
}
