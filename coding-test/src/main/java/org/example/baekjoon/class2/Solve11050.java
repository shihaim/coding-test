package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve11050 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println(binomialCoefficient(n, k));
        }
    }

    public static int binomialCoefficient(int n, int k) {
        if (k < 0 || k > n) return 0;

        int nk = n - k;

        if (nk == 0) nk = 1;

        int nFactorial = 1;
        while (n > 0) {
            nFactorial *= n--;
        }

        int kFactorial = 1;
        while (k > 0) {
            kFactorial *= k--;
        }

        int nkFactorial = 1;
        while (nk > 0) {
            nkFactorial *= nk--;
        }

        return nFactorial / (kFactorial * nkFactorial);
    }
}
