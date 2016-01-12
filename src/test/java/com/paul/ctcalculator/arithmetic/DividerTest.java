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
        Expression left = new Constant(testValueA);
        Expression right = new Constant(testValueB);
        Expression e = new Divider(left, right);
        assertEquals((testValueA / testValueB), e.getValue());
    }

}