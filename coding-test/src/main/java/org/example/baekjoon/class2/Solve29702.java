package org.example.baekjoon.class2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Solve29702 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] arr = new String[3];
            int index = 0;
            for (int i = 0; i < 3; i++) {
                String value = sc.nextLine();
                arr[i] = value;
                if (isNumeric(value)) {
                    index = i;
                }
            }

            int start = Integer.parseInt(arr[index]);
            for (int i = 0; i < 3 - index; i++) {
                start++;
            }

            System.out.println(fizzBuzz(start));
        }
    }

    public static boolean isNumeric(String str) {
        return Pattern.matches("\\d+", str);
    }

    public static String fizzBuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }
}
