package org.example;

import java.util.Scanner;

public class FactorialExercise {
    public static long calculateFactorial() throws RuntimeException {
        int num = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter any positive integer:");
            if(!scanner.hasNextInt()){
                throw new RuntimeException("Factorial could be calculated only on integers");
            }
            num = scanner.nextInt();
            if (num < 0) {
                throw new RuntimeException("Factorial could be calculated only on positive integers");
            }
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
            throw e;
        }

        long factorial = 1;
        try {
            if (num > 1) {
                for (int i = 2; i <= num; i++) {
                    if ((factorial * i) < 0) { //If the multiplication greater than long
                        throw new RuntimeException("Factorial exceeds the maximum value of long");
                    }
                    factorial *= i;
                }
            }
            System.out.println("Factorial of " + num + " equals " + factorial);
            return factorial;
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
