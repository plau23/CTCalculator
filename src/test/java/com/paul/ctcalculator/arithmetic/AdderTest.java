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
        Expression left = new Constant(testValueA);
        Expression right = new Constant(testValueB);
        Expression e = new Adder(left, right);
        assertEquals((testValueA + testValueB), e.getValue());
    }

    @Test
    public void testAddComplex()
    {
        int testValueA = -11;
        int testValueB = +40;
        Expression left = new Constant(testValueA);
        Expression right = new Constant(testValueB);
        Expression e = new Adder(left, right);
        assertEquals((testValueA + testValueB), e.getValue());
    }
}