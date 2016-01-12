package com.paul.ctcalculator.evaluator;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul Lau on 2016-01-11.
 */
public class EvaluatorTest {


    @Test
    public void testEvaluateConstant1()
    {
        assertEquals(5, Evaluator.Evaluate("5").getValue());
    }

    @Test
    public void testEvaluateConstant2()
    {
        assertEquals(12, Evaluator.Evaluate("12").getValue());
    }

    @Test
    public void testEvaluateAdd()
    {
        assertEquals(7, Evaluator.Evaluate("add(5,2)").getValue());
    }

    @Test
    public void testEvaluateAddComplex()
    {
        assertEquals(27, Evaluator.Evaluate("add(10,17)").getValue());
    }

    @Test
    public void testEvaluateAddComplex01()
    {
        assertEquals(-5, Evaluator.Evaluate("add(+12,-17)").getValue());
    }

    @Test
    public void testEvaluateAddComplex02()
    {
        assertEquals(-384, Evaluator.Evaluate("add(-212,-172)").getValue());
    }

    @Test
    public void testEvaluateSubtract()
    {
        assertEquals(4, Evaluator.Evaluate("sub(13,9)").getValue());
    }

    @Test
    public void testEvaluateSubtractComplex()
    {
        assertEquals(13, Evaluator.Evaluate("sub(20,7)").getValue());
    }

    @Test
    public void testEvaluateMult()
    {
        assertEquals(900, Evaluator.Evaluate("mult(100,9)").getValue());
    }

    @Test
    public void testEvaluateMultComplex()
    {
        assertEquals(207, Evaluator.Evaluate("mult(-9,-23)").getValue());
    }

    @Test
    public void testEvaluateMultComplex01()
    {
        assertEquals(63, Evaluator.Evaluate("mult(9,7)").getValue());
    }

    @Test
    public void testEvaluateDiv()
    {
        assertEquals(12, Evaluator.Evaluate("div(132,11)").getValue());
    }

    @Test
    public void testEvaluateDivComplex()
    {
        assertEquals(8, Evaluator.Evaluate("div(56,7)").getValue());
    }

    @Test
    public void testEvaluateLet()
    {
        assertEquals(17, Evaluator.Evaluate("let(a,5,add(a,12))").getValue(), 0.0);
    }

    @Test
    public void testEvaluateLetComplex()
    {
        assertEquals(55, Evaluator.Evaluate("let(a,5,let(b,mult(a,10),add(b,a)))").getValue(), 0.0);
    }

    @Test
    public void testEvaluateLetComplex1()
    {
        assertEquals(40, Evaluator.Evaluate("let(a,let(b,10,add(b,b)),let(b,20,add(a,b)))").getValue(), 0.0);
    }

    @Test
    public void testEvaluateLetComplex2()
    {
        assertEquals(20, Evaluator.Evaluate("let(abc,10,add(abc,abc))").getValue(), 0.0);
    }

    @Test
    public void testEvaluateLetComplex3()
    {
        assertEquals(-5.0, Evaluator.Evaluate("let(az,+10,add(az,-15))").getValue(), 0.0);
    }

    @Test
    public void testEvaluateAddSub()
    {
        assertEquals(18, Evaluator.Evaluate("add(9,sub(12,3))").getValue());
    }


    @Test
    public void testEvaluateAddSubComplex()
    {
        assertEquals(23, Evaluator.Evaluate("add(mult(7,2),sub(12,3))").getValue());
    }


    @Test
    public void testFindCommaPositionBetweenInputParametersWith2Parms()
    {
        String test = "add(5,2)"; //5
        String test1 = "add(mult(3,5),9)";  //13
        String test2 = "add(2,mult(9,10))"; //5
        String test3 = "add(mult(4,10),mult(9,10))"; //14
        String test4 = "add(mult(4,sub(9,1)),mult(9,10))"; //20
        String test5 = "add(12344,3)";  //9
        String test6 = "add(+344,-91)";  //8

        assertEquals(5, Evaluator.FindCommaPositionBetweenExpressions(test, false));
        assertEquals(13, Evaluator.FindCommaPositionBetweenExpressions(test1, false));
        assertEquals(5, Evaluator.FindCommaPositionBetweenExpressions(test2, false));
        assertEquals(14, Evaluator.FindCommaPositionBetweenExpressions(test3, false));
        assertEquals(20, Evaluator.FindCommaPositionBetweenExpressions(test4, false));
        assertEquals(9, Evaluator.FindCommaPositionBetweenExpressions(test5, false));
        assertEquals(8, Evaluator.FindCommaPositionBetweenExpressions(test6, false));
    }

    @Test
    public void testFindCommaPositionBetweenInputParametersWith3Parms()
    {

        String test = "let(a,5,add(a,a))";  //7
        String test1 = "let(a,add(5,6),add(a,a))";  //14
        String test2 = "let(a,add(5,sub(10,5)),add(a,a))";  //14
        String test3 = "let(a,add(5,let(x,a,add(x,x))),add(a,a))";  //30
        String test4 = "let(abc,5,add(abc,abc))";
        String test5 = "let(test,+12,add(test,test))";

        assertEquals(7, Evaluator.FindCommaPositionBetweenExpressions(test, true));
        assertEquals(14, Evaluator.FindCommaPositionBetweenExpressions(test1, true));
        assertEquals(22, Evaluator.FindCommaPositionBetweenExpressions(test2, true));
        assertEquals(30, Evaluator.FindCommaPositionBetweenExpressions(test3, true));
        assertEquals(9, Evaluator.FindCommaPositionBetweenExpressions(test4, true));
        assertEquals(12, Evaluator.FindCommaPositionBetweenExpressions(test5, true));
    }

    @Test
    public void testRetrieve3Parameters()
    {
        String test = "let(a,15,add(a,a))";

        String[] exprs = Evaluator.Retrieve3Parameters(test);
        assertEquals("a", exprs[0]);
        assertEquals("15", exprs[1]);
        assertEquals("add(a,a)", exprs[2]);
    }

    @Test
    public void testRetrieve3Parameters01()
    {
        String test = "let(abc,15,add(abc,abc))";

        String[] exprs = Evaluator.Retrieve3Parameters(test);
        assertEquals("abc", exprs[0]);
        assertEquals("15", exprs[1]);
        assertEquals("add(abc,abc)", exprs[2]);
    }

    @Test
    public void testRetrieve3Parameters02()
    {
        String test = "let(abc,add(10,10),add(abc,abc))";

        String[] exprs = Evaluator.Retrieve3Parameters(test);
        assertEquals("abc", exprs[0]);
        assertEquals("add(10,10)", exprs[1]);
        assertEquals("add(abc,abc)", exprs[2]);
    }

    @Test
    public void testRetrieve3Parameters03()
    {
        String test = "let(test,add(+10,-10),add(test,+123))";

        String[] exprs = Evaluator.Retrieve3Parameters(test);
        assertEquals("test", exprs[0]);
        assertEquals("add(+10,-10)", exprs[1]);
        assertEquals("add(test,+123)", exprs[2]);
    }
}