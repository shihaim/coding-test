package org.example.baekjoon.class2;

import java.util.Arrays;
import java.util.Scanner;

public class Solve4153 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();

            int[] a = new int[3];
            while (true) {
                a[0] = sc.nextInt();
                a[1] = sc.nextInt();
                a[2] = sc.nextInt();

                boolean end = a[0] == 0 && a[1] == 0 && a[2] == 0;

                if (end) {
                    sb.deleteCharAt(sb.lastIndexOf("\n"));
                    break;
                }

                Arrays.sort(a);

                if (Math.pow(a[2], 2) == Math.pow(a[0], 2) + Math.pow(a[1], 2)) {
                    sb.append("right").append("\n");
                } else {
                    sb.append("wrong").append("\n");
                }
            }

            System.out.println(sb);
        }
    }
}
