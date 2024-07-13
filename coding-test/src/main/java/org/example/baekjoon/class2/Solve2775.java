package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve2775 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();

            for (int i = 0; i < T; i++) {
                int k = sc.nextInt();
                int n = sc.nextInt();

                System.out.println(dp(k + 1, n - 1));
            }
        }
    }

    public static int dp(int n, int m) {
        if (n == 0 || m == 0) return 1;

        return dp(n, m - 1) + dp(n - 1, m);
    }
}
