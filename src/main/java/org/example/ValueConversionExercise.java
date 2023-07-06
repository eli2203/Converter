package org.example;

import org.example.Enums.AdapterTypes;
import org.example.Enums.Currency;
import org.example.Enums.Distance;
import org.example.Enums.Temperature;

import java.util.Scanner;

public class ValueConversionExercise {
    public static void runValueConversion(){
        ConvertorExercise convertor = new ConvertorExercise();
        Scanner scanner = new Scanner(System.in);
        AdapterTypes converterType;

        printConverterType();
        int converterTypeValue = scanner.nextInt();
        converterType = AdapterTypes.values()[converterTypeValue - 1];
        System.out.println("converter Type: " + converterType);

        Enum<?>[] unitTypeOptions = getUnitTypeOptionsByConverterType(converterType);

        printUnitType(unitTypeOptions, "input");
        int inputUnitTypeValue = scanner.nextInt();
        Enum<?> inputUnitType = unitTypeOptions[inputUnitTypeValue - 1];
        System.out.println("input unit Type: " + inputUnitType);

        System.out.println("How much " + inputUnitType + " should be converted?");
        double inputValue = scanner.nextDouble();

        printUnitType(unitTypeOptions, "output");
        int outputUnitTypeValue = scanner.nextInt();
        Enum<?> outputUnitType = unitTypeOptions[outputUnitTypeValue - 1];
        System.out.println("output unit Type: " + outputUnitType);

        System.out.println("We are converting: " + converterType + ": " + inputValue + " " + inputUnitType + " to " + outputUnitType);
        Enum<?>[] convertOptions = {inputUnitType, outputUnitType};
        try {
            double result = convertor.convert(converterType, inputValue, convertOptions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        scanner.close();
    }

    private static void printUnitType(Enum<?>[] options, String operation) {
        System.out.println("Please choose " + operation +" unit type:");

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter your choice: ");
    }

    public static void printConverterType() {
        System.out.println("Please select which conversion should be done:");
        AdapterTypes[] options = AdapterTypes.values();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter your choice: ");
    }

    private static Enum<?>[] getUnitTypeOptionsByConverterType(AdapterTypes converterType){
        Enum<?>[] options = new Enum[0];

        switch (converterType) {
            case TEMPERATURE:
                options = Temperature.values();
                break;
            case DISTANCE:
                options = Distance.values();
                break;
            case CURRENCY:
                options = Currency.values();
                break;
        }
        return options;
    }
}

