package com.paul.ctcalculator.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul Lau on 2016-01-11.
 */
public class VariableTest {

    @Test
    public void testVariable()
    {
        iExpression e = new Variable("abcString");
        assertEquals(0, e.getValue());
    }

}