package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Please select exercise:");
            System.out.println( "1. Value conversion");
            System.out.println( "2. Find longest repetition of the same letter");
            System.out.println( "3. Factorial");
            System.out.println( "4. Random numbers");
            System.out.println( "5. Odd numbers (with Java 8+)");
            System.out.print("Enter your choice: ");
            int exerciseNum = scanner.nextInt();

            switch(exerciseNum){
                case 1:
                    ValueConversionExercise.runValueConversion();
                    break;
                case 2:
                    CharRepetitionExercise.findLongestRepetition();
                    break;
                case 3:
                    FactorialExercise.calculateFactorial();
                    break;
                case 4:
                    RandomNumbersExrcise.printRandomNumbers();
                    break;
                case 5:
                    OddNumbersExercise.runOddNumbersExercise();
                    break;
                default:
                    throw new RuntimeException("You choose wrong option !!!");
            }
        } catch (RuntimeException e) {
            System.out.println("Exception caught: because of wrong chosen option: " + e.getMessage());
        }
    }
}