package org.example.Adapters;

import org.example.Enums.Distance;

public class DistanceAdapter {
    public double convert(double value, Enum<?> inputUnit, Enum<?> outputUnit){
        if (value < 0) {
            throw new IllegalArgumentException("The amount for conversion must be positive !!!");
        }

        try {
            double result = value * Distance.valueOf(inputUnit.toString()).getValue() / Distance.valueOf(outputUnit.toString()).getValue();
            System.out.println(value + " " + inputUnit.toString() + " is " + result + " " + outputUnit.toString());
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
