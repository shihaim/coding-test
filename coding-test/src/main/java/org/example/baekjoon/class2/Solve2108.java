package org.example.baekjoon.class2;

import java.util.Arrays;
import java.util.Scanner;

public class Solve2108 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            int average = 0;
            int minValue = 8000;
            int maxValue = 0;

            for (int i = 0; i < N; i++) {
                int value = sc.nextInt();
                average += value;
                arr[i] = value + 4000;
                minValue = Math.min(arr[i], minValue);
                maxValue = Math.max(arr[i], maxValue);
            }

            int range = maxValue - minValue + 1;
            int[] countArr = new int[range];
            Arrays.fill(countArr, 0);

            int maxCount = 0;
            for (int value : arr) {
                countArr[value - minValue]++;
                maxCount = Math.max(maxCount, countArr[value - minValue]);
            }

            // ===최빈값 구하기 start===
            int[] frequencyArr = Arrays.copyOf(countArr, countArr.length);

            for (int i = 0; i < frequencyArr.length; i++) {
                if (frequencyArr[i] == maxCount) {
                    frequencyArr[i] = i - (4000 - minValue);
                } else {
                    frequencyArr[i] = -4001;
                }
            }

            Arrays.sort(frequencyArr);

            int maxFrequencyValue = 0;
            int freqCount = 0;
            for (int i = 0; i < frequencyArr.length; i++) {
                if (frequencyArr[i] == -4001) continue;
                maxFrequencyValue = frequencyArr[i];
                if (freqCount++ == 1) break;
            }
            // ===최빈값 구하기 end===

            for (int i = 1; i < countArr.length; i++) {
                countArr[i] += countArr[i - 1];
            }

            int[] resultArr = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                resultArr[countArr[arr[i] - minValue] - 1] = arr[i] - 4000;
                countArr[arr[i] - minValue]--;
            }

            System.out.println(Math.round((float) average / N));
            System.out.println(resultArr[N/2]);
            System.out.println(maxFrequencyValue);
            System.out.println(maxValue - minValue);
        }
    }
}
