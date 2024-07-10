package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve1654 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int K = sc.nextInt();
            int N = sc.nextInt();

            int[] arr = new int[K];

            long lo = 0;
            long hi = 0;
            long mid = 0;

            for (int i = 0; i < K; i++) {
                arr[i] = sc.nextInt();
                if (hi < arr[i]) {
                    hi = arr[i];
                }
            }

            /**
             * Exception in thread "main" java.lang.ArithmeticException: / by zero
             * mid가 0이 되는 경우를 방지하기 위함.
             */
            hi++;

            // [upper bound]
            while (lo < hi) {
                int lanCount = 0;
                 mid = (lo + hi) / 2;

                for (int i = 0; i < K; i++) {
                    lanCount += (int) (arr[i] / mid);
                }

                if (lanCount < N) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            System.out.println(lo - 1);
        }
    }
}
