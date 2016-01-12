package com.paul.ctcalculator.arithmetic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Paul Lau on 2016-01-11.
 */
public class AdderTest {

    @Test
    public void testAdd()
    {
        int testValueA = 1;
        int testValueB = 4;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Adder(left, right);
        assertEquals((testValueA + testValueB), e.getValue());
    }

    @Test
    public void testAddComplex()
    {
        int testValueA = -11;
        int testValueB = +40;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Adder(left, right);
        assertEquals((testValueA + testValueB), e.getValue());
    }

    @Test(expected = IllegalArgumentException.class )
    public void testAddComplex1()
    {
        int testValueA = 0;
        int testValueB = Integer.MAX_VALUE;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Adder(left, right);
        assertEquals((testValueA + testValueB), e.getValue());
    }

    @Test(expected = IllegalArgumentException.class )
    public void testAddComplex2()
    {
        int testValueA = 0;
        int testValueB = Integer.MIN_VALUE;
        iExpression left = new Constant(testValueA);
        iExpression right = new Constant(testValueB);
        iExpression e = new Adder(left, right);
        assertEquals((testValueA + testValueB), e.getValue());
    }
}