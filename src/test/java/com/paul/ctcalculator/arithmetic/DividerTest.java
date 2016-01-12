package com.paul.ctcalculator.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul Lau on 2016-01-11.
 */
public class DividerTest {

    @Test
    public void testDivider()
    {
        int testValueA = 6;
        int testValueB = 2;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Divider(left, right);
        assertEquals((testValueA / testValueB), e.getValue());
    }

    @Test
    public void testDivider1()
    {
        int testValueA = 0;
        int testValueB = 99;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Divider(left, right);
        assertEquals((testValueA / testValueB), e.getValue());
    }

    @Test(expected = ArithmeticException.class )
    public void testDividerException()
    {
        int testValueA = 12;
        int testValueB = 0;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Divider(left, right);
        assertEquals((testValueA / testValueB), e.getValue());
    }

}