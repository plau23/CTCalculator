package com.paul.ctcalculator.evaluator;

import com.paul.ctcalculator.arithmetic.*;
import com.paul.ctcalculator.logger.Log;

/**
 *
 * Evaluator.java
 *
 * Evaluator is designed to decode the commands and parameters from the expression
 * and execute its functions accordingly.
 *
 */
public class Evaluator {
    private enum Operation {add, sub, mult, div, let };

    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';
    private static final char COMMA = ',';

    private static final Log log = Log.getInstance();

    public enum HasThreeExpressions { Yes, No };


    private Evaluator(){};

    // Decode the given string and convert into an expression accordingly
    // Example:
    // IN: "add(expr1, expr2)"
    // OUT: new Adder(expr1, expr2)
    public static iExpression Evaluate(final String content)
    {
        try {

            if (content.matches("[a-zA-z]+")) {
                return new Variable(content);}

            if (content.matches("[+-]?(?<!\\.)\\b[0-9]+\\b(?!\\.[0-9])")) {
                return new Constant(Integer.parseInt(content));
            }

            // Find left and right expressions from the content
            String[] parms = RetrieveParameters(content);

            if (content.startsWith(Operation.add.name())) {
                return new Adder(Evaluate(parms[0]), Evaluate(parms[1]));
            }

            if (content.startsWith(Operation.sub.name())) {
                return new Subtracter(Evaluate(parms[0]), Evaluate(parms[1]));
            }

            if (content.startsWith(Operation.mult.name())) {
                return new Multipler(Evaluate(parms[0]), Evaluate(parms[1]));
            }

            if (content.startsWith(Operation.div.name())) {
                return new Divider(Evaluate(parms[0]), Evaluate(parms[1]));
            }

            if (content.startsWith(Operation.let.name())) {
                // Find 1 identifier and 2 expressions from the content
                parms = Retrieve3Parameters(content);
                return new Let(new Identifier(new Variable(parms[0]), Evaluate(parms[1])), Evaluate(parms[2]));
            }

            log.Error("undefined operations - please use previously defined functions add,sub,mult,div,let");

        } catch (Exception e)
        {
            log.Error(e.toString());
        }
        return null;
    }

    // Returns 1 identifier and 2 expressions from the content
    //
    // Example:
    // IN: "let(a,10,add(a,a))"
    // OUT: ["a","10","add(a,a)"]
    public static String[] Retrieve3Parameters(final String content)
    {
        String[] expr = new String[3];

        final int openBracket = content.indexOf(OPEN_BRACKET);
        final int closeBracket = content.lastIndexOf(CLOSE_BRACKET);
        final int firstComma = content.indexOf(COMMA);
        final int commaBetweenTwoExpressions = FindCommaPositionBetweenExpressions(content, HasThreeExpressions.Yes);

        // Find the identifier
        expr[0] = content.substring(openBracket + 1, firstComma);
        log.Debug("IDENTIFIER:" + expr[0]);

        // Find 2 expressions
        expr[1] = content.substring(firstComma + 1, commaBetweenTwoExpressions);
        expr[2] = content.substring(commaBetweenTwoExpressions + 1, closeBracket);
        log.Debug("EXPR1:" + expr[1] + ", EXPR2:" + expr[2]);

        return expr;
    }


    // Returns left and right expressions from the content
    //
    // Example:
    // IN: "add(2,sub(10,5))"
    // OUT: ["2", "sub(10,5)"]
    public static String[] RetrieveParameters(final String content)
    {
        String[] expr = new String[2];

        final int openBracket = content.indexOf(OPEN_BRACKET);
        final int closeBracket = content.lastIndexOf(CLOSE_BRACKET);
        final int commaBetweenTwoExpressions = FindCommaPositionBetweenExpressions(content, HasThreeExpressions.No);
        log.Debug("CONTENT:" + content + ", [(]:" + openBracket + ", [,]:" + commaBetweenTwoExpressions + ", [)]:" + closeBracket);

        // Find 2 expressions
        expr[0] = content.substring(openBracket + 1, commaBetweenTwoExpressions);
        expr[1] = content.substring(commaBetweenTwoExpressions + 1, closeBracket);
        log.Debug("EXPR1:" + expr[0] + ", EXPR2:" + expr[1]);

        return expr;
    }


    // Find the comma position between the input expressions on the first occurrence of predefined function
    //
    // Example:
    // IN: add(2,3)
    // OUT: 5
    //
    // IN: let(a,5,add(a,a))
    // OUT: 7
    public static int FindCommaPositionBetweenExpressions(final String content, HasThreeExpressions threeExpressions)
    {
        if ((content == null) ||(content.length() == 0))
            return 0;


        int numOfOpenBracket = 0;

        // Find the first expression position from the content
        // ex. add(expr1, expr2) - the first expression will be started from the first occurrence of open bracket + 1
        // ex. let(identifier,expr1,expr2) - the first expression will be started from the first occurrence of
        // comma + 1
        final int firstExpressionPosition = (threeExpressions.equals(HasThreeExpressions.Yes)) ? content.indexOf(COMMA) + 1:
                content.indexOf(OPEN_BRACKET) + 1;

        // Find the comma position between two expressions
        // The comma position should be after the last closing bracket of the first expression
        // ex. add(5,12)  // returns location 5
        // ex. add(mult(sub(123,3),4), 12) // returns location 22
        for (int i= firstExpressionPosition; i < content.lastIndexOf(CLOSE_BRACKET); i++)
        {
            if (numOfOpenBracket == 0 && content.charAt(i) == COMMA ) {
                log.Debug("CONTENT:" + content + " WITH 3 EXPRS:" + threeExpressions.name() + ", [,] locates at "+ i);
                return i;
            }

            if (content.charAt(i) == OPEN_BRACKET)
                numOfOpenBracket++;

            if (content.charAt(i) == CLOSE_BRACKET)
                numOfOpenBracket--;
        }

        return 0;
    }
}
