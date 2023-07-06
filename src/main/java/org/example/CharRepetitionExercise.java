package org.example;

import java.util.Scanner;

public class CharRepetitionExercise {
    public static int findLongestRepetition(){
        int location = 0;
        int longestCounter = 0;
        int startIter = 0;
        int endIter = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter test string:");
        String string = scanner.next();

        if (string.isEmpty()){
            System.out.println("Couldn't check the empty string!!");
        } else if (string.length() > 1){
            while (startIter < (string.length() - 1)){
                int curCounter = 1;
                for (endIter = startIter + 1; endIter < string.length(); endIter++){
                    if (string.charAt(startIter) != string.charAt(endIter)) {
                        break;
                    }
                curCounter++;
                if (curCounter > longestCounter){
                    location = startIter;
                    longestCounter = curCounter;
                }
                }
                startIter = endIter;
            }
        }
        System.out.println("The longest repetition letter starts at " + (location + 1) + " letter");
        return location;
    }
}
