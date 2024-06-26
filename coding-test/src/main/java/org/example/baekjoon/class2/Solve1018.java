package org.example.baekjoon.class2;

import java.util.Scanner;

public class Solve1018 {
    public static boolean[][] board;
    public static int result = 64;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            int N = sc.nextInt();
            int M = sc.nextInt();

            board = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String line = sc.next();
                for (int j = 0; j < M; j++) {
                    if (line.charAt(j) == 'W') {
                        board[i][j] = true;
                    } else {
                        board[i][j] = false;
                    }
                }
            }

            // (N - 7) * (M - 7)
            int x = N - 7;
            int y = M - 7;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    find(i, j);
                }
            }

            System.out.println(result);
        }
    }

    public static void find(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;

        boolean value = board[x][y];
        int count = 0;

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (value != board[i][j]) {
                    count++;
                }
                value = !value;
            }
            value = !value;
        }

        /**
         * 해당 경우는 board[x][y]를 한 번만 한 경우다.
         * 다른 의미로는 64 - count를 한 경우가 !board[x][y]도 진행한 경우라고 볼 수 있다.
         */
        count = Math.min(count, 64 - count);
        result = Math.min(result, count);
    }
}
