package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve1978 {
    public static void main(String[] args) {
        // 제곱근 까지만 검사하면 됨.
        int result = 0;
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                result += isPrime(a);
            }

        } catch (Exception e) {

        }
        System.out.println(result);
    }

    public static int isPrime(int value) {
        // 0, 1이면 넘어가기
        if (value == 0 || value == 1) return 0;
        // 2는 소수
        if (value == 2) return 1;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return 0;
        }
        return 1;
    }
}
