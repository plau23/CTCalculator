package com.paul.ctcalculator.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul Lau on 2016-01-11.
 */
public class SubtracterTest {

    @Test
    public void testSubtract()
    {
        int testValueA = 6;
        int testValueB = 2;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Subtracter(left, right);
        assertEquals((testValueA - testValueB), e.getValue(), 0.0);
    }

    @Test
    public void testSubtract1()
    {
        int testValueA = +92;
        int testValueB = -100;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Subtracter(left, right);
        assertEquals((testValueA - testValueB), e.getValue(), 0.0);
    }

    @Test
    public void testSubtract2()
    {
        int testValueA = -0;
        int testValueB = +7623;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Subtracter(left, right);
        assertEquals((testValueA - testValueB), e.getValue(), 0.0);
    }
}