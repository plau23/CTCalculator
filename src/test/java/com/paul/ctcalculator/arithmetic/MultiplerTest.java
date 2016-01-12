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
        Expression left = new Constant(testValueA);
        Expression right = new Constant(testValueB);
        Expression e = new Multipler(left, right);
        assertEquals((testValueA * testValueB), e.getValue());
    }

}