package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddNumbersExercise {
    public static List<Integer> runOddNumbersExercise() {
        List<Integer> listOfIntegers = getListOfIntegers();
        listOfIntegers.stream()
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);
        return listOfIntegers;
    }

    private static List<Integer> getListOfIntegers(){
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much numbers do you want to insert into the list?: ");
        if(!scanner.hasNextInt()){
            throw new RuntimeException("You could ask only on integer amount of numbers in the list");
        }
        int listSize = scanner.nextInt();
        if (listSize <= 0) {
            throw new RuntimeException("Sorry, we should get a positive number !!!");
        }
        for (int i = 0; i < listSize; i++){
            System.out.println("Enter the number: ");
            list.add(scanner.nextInt());
        }
        return list;
    }
}
