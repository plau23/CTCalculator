package com.paul.ctcalculator;

import com.paul.ctcalculator.evaluator.Evaluator;
import com.paul.ctcalculator.logger.Log;

/**
 *
 * This class is designed to be a simple command-line calculator.
 * It handles add, sub, mult and div arithmetic functions and each one take 2 arbitrary expressions.
 * The "let" operator for assigning values to variables
 *
 *
 * You can execute by using the following arguments
 *
 * Argument 0 to pass the whole expression in string
 * ex. "add(5,10)"
 * ex. "add(1,mult(2,3))"
 * ex. "let(a,5,let(b,mult(a,10),add(b,a)))"
 *
 * Argument 1 to define the debug level in int
 * Log_Level can be used to setup from the command line to display 3 levels of debug information
 * Debug 0 - covers Info & Error & Debug
 * Info  1 - covers Info & Error
 * Error 2 - covers Error only
 * Note. Info is the default debug level.
 *
 * ex. java -jar Calculator.jar "add(5,10)" 1
 * ex. java -jar Calculator.jar "sub(10,2)" 0
 *
 */
public class Calculator {


    public static void main(String[] args)
    {

        getAndSetDebugLevelFromInput(args);

        String expression = getExpressionFromInput(args);
        Log.getInstance().Info("RESULT:"+ Evaluator.Evaluate(expression).getValue());

        return;
    }


    public static void getAndSetDebugLevelFromInput(String[] input) {
        if (input != null && input.length >= 2 )
        {
            int debugLevel = Integer.parseInt(input[1]);
            Log.getInstance().SetDebugLevel(debugLevel);
            Log.getInstance().Debug("Set Debug Level:"+ debugLevel );
        }
    }


    // Remove any white spaces from the input content and evaluate the expression
    public static String getExpressionFromInput(String[] input)
    {

        String result = null;

        if (input != null && input.length >= 1 )
        {
            // retrieve the expression from argument 0
            result = input[0].replaceAll("\\s+", "");
            Log.getInstance().Debug("INPUT:" + result);

        } else {
            Log.getInstance().Error("Input parameter not found.  Ex. java -jar calculator.Main \"add(5,2)\"");;
        }

        return result;
    }
}