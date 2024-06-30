package org.example.baekjoon.class2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solve10816 {
    public static void main(String[] args) {
        Map<Integer, Integer> cardMap = new HashMap<Integer, Integer>();

        try (Scanner sc = new Scanner(System.in)){
            StringBuilder sb = new StringBuilder();

            int N = sc.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
                cardMap.put(a[i], cardMap.getOrDefault(a[i], 0) + 1);
            }

            int M = sc.nextInt();
            int[] b = new int[M];
            for (int i = 0; i < M; i++) {
                b[i] = sc.nextInt();
                sb.append(cardMap.getOrDefault(b[i], 0)).append((i == M -1) ? "" : " ");
            }

            System.out.print(sb);
        }
    }
}