package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve1676 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            System.out.println((N / 5) + (N / 25) + (N / 125));
        }
    }
}
