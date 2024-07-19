package org.example.baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solve18110 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int ceil = (int) Math.round(n * 0.15);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i >= ceil || i < n - ceil) {

                }
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int totalDifficulty = 0;
            for (int i = ceil; i < n - ceil; i++) {
                totalDifficulty += arr[i];
            }

            System.out.println(Math.round((float) totalDifficulty / (n - ceil * 2)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
