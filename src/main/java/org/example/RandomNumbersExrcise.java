package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RandomNumbersExrcise {
    public static void printRandomNumbers() {
        int count = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How much random numbers between 1 to 1000 do you want to receive?: ");
            if(!scanner.hasNextInt()){
                throw new RuntimeException("You could ask only on integer amount of random numbers");
            }
            count = scanner.nextInt();
            if (count < 0) {
                throw new RuntimeException("Sorry, we should get a positive number !!!");
            }
        } catch (RuntimeException e) {
            System.out.println("Exception caught: $" + e.getMessage());
            throw e;
        }

        try {
            for (int i = 0; i < count; i++){
                Set<Integer> set = new HashSet<>();
                Random random = new Random();
                int randomNumber = random.nextInt(1000) + 1;
                if (set.add(randomNumber)){
                    System.out.print(randomNumber + "\t");
                } else{
                    i--; //in order to generate additional not duplicated number
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
            throw e;
        }
    }
}
