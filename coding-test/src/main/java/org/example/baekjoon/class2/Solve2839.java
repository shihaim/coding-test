package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve2839 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            System.out.println(sugerDelivery(N));
        } catch (Exception e) {

        }
    }

    public static int sugerDelivery(int N) {
        if (N == 4 || N == 7) {
            return -1;
        }

        if (N % 5 == 0) {
            return N / 5;
        } else if (N % 5 == 1 || N % 5 == 3) {
            return (N / 5) + 1;
        } else if (N % 5 == 2 || N % 5 == 4) {
            return (N / 5) + 2;
        }

        return -1;
    }
}
