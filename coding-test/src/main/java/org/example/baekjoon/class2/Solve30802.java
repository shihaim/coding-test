package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve30802 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            int N = sc.nextInt();
            int[] tShirts = new int[6];
            for (int i = 0; i < 6; i++) {
                tShirts[i] = sc.nextInt();
            }
            double T = sc.nextDouble();
            int P = sc.nextInt();

            int wrapT = 0;
            int wrapP = (N / P);

            for (int i = 0; i < 6; i++) {
                wrapT += Math.ceil(tShirts[i] / T);
            }

            System.out.println(wrapT);
            System.out.println(wrapP + " " + (N - P * wrapP));
        }
    }
}
