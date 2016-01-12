package com.paul.ctcalculator.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul Lau on 2016-01-11.
 */
public class MultiplerTest {

    @Test
    public void testMultipler()
    {
        int testValueA = 6;
        int testValueB = 2;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Multipler(left, right);
        assertEquals((testValueA * testValueB), e.getValue());
    }

    @Test
    public void testMultipler01()
    {
        int testValueA = +99;
        int testValueB = -12;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Multipler(left, right);
        assertEquals((testValueA * testValueB), e.getValue());
    }

    @Test(expected = IllegalArgumentException.class )
    public void testMultiplerException()
    {
        int testValueA = Integer.MAX_VALUE;
        int testValueB = 2;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Multipler(left, right);
        assertEquals((testValueA * testValueB), e.getValue());
    }
}