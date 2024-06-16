package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        while (true) {
            int recur = recur(cnt++) + 1;
            if (recur >= N) break;
        }

        System.out.println(cnt);

        sc.close();
    }

    public static int recur(int n) {
        /**
         * S0 = 0
         */
        if (n == 0) return 0;

        /**
         * Sn = Sn-1 + 6n
         */
        return recur(n - 1) + (6 * n);
    }
}
