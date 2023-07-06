package org.example.Adapters;

import org.example.Enums.Temperature;

public class TemperatureAdapter {
    public double convert(double value, Enum<?> inputUnit, Enum<?> outputUnit){
        double result;
        try {
                if (inputUnit.toString().equals(Temperature.CELSIUS.toString()) && outputUnit.toString().equals(Temperature.FAHRENHEIT.toString())){
                    result = (value * 9/5 + 32);
                    System.out.println(value + " degrees in Celsius equals to " + result + " degrees in Fahrenheit");
                } else if (inputUnit.toString().equals(Temperature.FAHRENHEIT.toString()) && outputUnit.toString().equals(Temperature.CELSIUS.toString())){
                    result = ((value -32)* 5/9);
                    System.out.println(value + " degrees in Fahrenheit equals to " + result + " degrees in Celsius");
                } else {
                    System.out.println("Wrong temperature conversion request");
                    return -9999; //TODO: to handle in main menu
                }
                return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
