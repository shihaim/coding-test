package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve10773 {
    private static int[] STACK = new int[100_000];
    private static int INDEX = -1;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int K = sc.nextInt();
            for (int i = 0; i < K; i++) {
                try {
                    int value = sc.nextInt();
                    if (value == 0) {
                        pop();
                    } else {
                        push(value);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }

            long total = 0;
            for (int i = 0; i < INDEX + 1; i++) {
                total += STACK[i];
            }

            System.out.println(total);
        }
    }

    public static void push(int value) throws ArrayIndexOutOfBoundsException {
        STACK[++INDEX] = value;
    }

    public static void pop() throws ArrayIndexOutOfBoundsException {
        STACK[INDEX--] = 0;
    }
}
