package com.paul.ctcalculator.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul Lau on 2016-01-11.
 */
public class ConstantTest {

    @Test
    public void testConstant()
    {
        iExpression e = new Constant(50);
        assertEquals(50, e.getValue());
    }

    @Test
    public void testConstantPositiveNumber()
    {
        iExpression e = new Constant(+50);
        assertEquals(50, e.getValue());
    }

    @Test
    public void testConstantNegativeNumber()
    {
        iExpression e = new Constant(-134);
        assertEquals(-134, e.getValue());
    }

    @Test(expected = IllegalArgumentException.class )
    public void testConstantExceptionCase1()
    {
        iExpression e = new Constant(Integer.MAX_VALUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstantExceptionCase2()
    {
        iExpression e = new Constant(Integer.MIN_VALUE);
    }

}