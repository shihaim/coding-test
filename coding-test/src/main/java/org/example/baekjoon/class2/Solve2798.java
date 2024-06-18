package org.example.baekjoon.class2;

import java.util.Arrays;
import java.util.Scanner;

public class Solve2798 {
    public static int blackjack = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        Arrays.sort(cards);

        plus(cards, N, M, 0, 0);

        System.out.println(blackjack);
    }

    public static void plus(int[] cards, int N, int M, int count, int value) {
        if (count == 3) {
            if (M >= value && value >= blackjack) {
                blackjack = value;
            }
            return;
        }

        for (int i = N-1; i >= 0; i--) {
            plus(cards, i, M, count+1, value+cards[i]);
        }
    }
}
