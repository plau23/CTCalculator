package com.paul.ctcalculator.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul Lau on 2016-01-11.
 */
public class IdentifierTest {

    @Test
    public void testIdentifier()
    {
        iExpression e = new Identifier(new Variable("a"), new Constant(10));
        assertEquals(0, e.getValue());

        e = new Variable("a");
        assertEquals(10, e.getValue());
    }

    @Test
    public void testIdentifierWithLongVariable()
    {
        iExpression e = new Identifier(new Variable("abc"), new Constant(+10));
        assertEquals(0, e.getValue());

        e = new Variable("abc");
        assertEquals(10, e.getValue());
    }

    @Test
    public void testIdentifierWithNegativeNumber()
    {
        iExpression e = new Identifier(new Variable("HellOW"), new Constant(-98));
        assertEquals(0, e.getValue());

        e = new Variable("HellOW");
        assertEquals(-98, e.getValue());
    }
}