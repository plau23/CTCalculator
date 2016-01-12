package com.paul.ctcalculator.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paul Lau on 2016-01-11.
 *
 */
public class Variable implements iExpression {

    private String variable;
    private int value;

    public static Map<String, Integer> Container = new HashMap<String, Integer>();

    public Variable(String variable)
    {
        this.variable = variable;

        if (Container.containsKey(variable))
        {
            value = Container.get(variable);
        } else {
            Container.put(variable, 0);
            value = 0;
        }
    }

    @Override
    public int getValue() {
        return value;
    }

    public String getParameter()
    {
        return variable;
    }
}
