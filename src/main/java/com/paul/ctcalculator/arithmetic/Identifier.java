package com.paul.ctcalculator.arithmetic;

/**
 * This class defines the identify expression
 */
public class Identifier extends Expression {

    public Identifier(Variable left, iExpression right) {
        super(left, right);

        // Assigns the value to the parameter
        Variable.Container.put(left.getParameter(), right.getValue());
    }

    @Override
    public int getValue() {
        return 0;
    }
}
