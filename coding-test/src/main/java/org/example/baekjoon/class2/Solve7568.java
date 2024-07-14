package org.example.baekjoon.class2;

import java.util.*;

public class Solve7568 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            int[][] person = new int[N][2];
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                person[i][0] = x;
                person[i][1] = y;
            }

            for (int i = 0; i < N; i++) {
                int rank = 1;
                for (int j = 0; j < N; j++) {
                    // 자기 자신과 모든 사람의 몸무게를 비교하기
                    if (i == j) continue;

                    if (person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
                        rank++;
                    }
                }

                System.out.print(i == (N - 1) ? rank : rank + " ");
            }
        }
    }
}
