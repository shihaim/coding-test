package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve1259 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            StringBuilder sb = new StringBuilder();

            int word;
            while (true) {
                if ((word = sc.nextInt()) == 0) {
                    sb.deleteCharAt(sb.lastIndexOf("\n"));
                    break;
                }

                int start = 0;
                boolean isStart = false;
                int count = 10000;
                int[] arr = new int[5];
                for (int i = 0; i < 5; i++) {
                    if (!isStart && (word / count >= 1)) {
                        isStart = true;
                        start = i;
                    }
                    arr[i] = word / count;
                    word -= arr[i] * count;
                    count /= 10;
                }

                // 비교
                boolean isPalindrome = true;
                for (int i = 4; i >= start; i--) {
                    if (arr[start] != arr[i]) {
                        isPalindrome = false;
                    }

                    if (i == start) break;
                    start++;
                }

                if (isPalindrome) {
                    sb.append("yes").append("\n");
                } else {
                    sb.append("no").append("\n");
                }
            }

            System.out.println(sb);
        }
    }
}