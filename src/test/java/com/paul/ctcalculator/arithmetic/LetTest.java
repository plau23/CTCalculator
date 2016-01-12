package com.paul.ctcalculator.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul Lau on 2016-01-11.
 */
public class LetTest {

    @Test
    public void testLet()
    {
        iExpression e = new Let(
                new Identifier(new Variable("a"), new Constant(5)),
                new Adder(new Variable("a"), new Variable("a"))
        );
        assertEquals(10, e.getValue());
    }

    @Test
    public void testLetComplex()
    {
        iExpression e = new Let(
                new Identifier(new Variable("a"), new Adder(new Constant(10), new Constant(5))),
                new Adder(new Variable("a"), new Variable("a"))
        );
        assertEquals(30, e.getValue());
    }

    @Test
    public void testLetComplex01()
    {
        iExpression e = new Let(
                new Identifier(new Variable("a"), new Constant(5)),
                new Let (
                        new Identifier(new Variable("b"), new Multipler(new Variable("a"), new Constant(10))),
                        new Adder(new Variable("b"), new Variable("a"))
                )
        );
        assertEquals(55, e.getValue());
    }

    @Test
    public void testLetComplex02()
    {
        iExpression e = new Let(
                new Identifier(
                        new Variable("a"),
                        new Let(
                                new Identifier(new Variable("b"), new Constant(10)),
                                new Adder(new Variable("b"), new Variable("b"))
                        )
                ),
                new Let(
                        new Identifier(new Variable("b"), new Constant(20)),
                        new Adder(new Variable("a"), new Variable("b"))
                )
        );

        assertEquals(40, e.getValue());
    }
}