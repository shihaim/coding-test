package org.example.baekjoon.class2;

import java.util.Arrays;
import java.util.Scanner;

public class Solve10816_2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                int key = sc.nextInt();
                sb.append(upperBound(key, arr) - lowerBound(key, arr)).append(" ");
            }
            System.out.println(sb);
        }
    }

    public static int lowerBound(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static int upperBound(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key >= arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }
}
