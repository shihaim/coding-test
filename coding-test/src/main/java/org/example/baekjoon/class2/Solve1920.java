package org.example.baekjoon.class2;

import java.util.Arrays;
import java.util.Scanner;

public class Solve1920 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            Arrays.sort(A);

            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                int value = sc.nextInt();
                sb.append(binarySearch(A, value) + (i == M - 1 ? "" : "\n"));
            }

            System.out.println(sb);
        } catch (Exception e) {

        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return 1;

            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }
}
