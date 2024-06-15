package org.example.baekjoon.class1;

import java.util.Scanner;

public class Solve11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        sc.nextLine();
        String value = sc.nextLine();

        int result = 0;
        for (int i = 0; i < count; i++) {
            char c = value.charAt(i);
            switch (c) {
                case '0':
                    result += 0;
                    break;
                case '1':
                    result += 1;
                    break;
                case '2':
                    result += 2;
                    break;
                case '3':
                    result += 3;
                    break;
                case '4':
                    result += 4;
                    break;
                case '5':
                    result += 5;
                    break;
                case '6':
                    result += 6;
                    break;
                case '7':
                    result += 7;
                    break;
                case '8':
                    result += 8;
                    break;
                case '9':
                    result += 9;
                    break;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
