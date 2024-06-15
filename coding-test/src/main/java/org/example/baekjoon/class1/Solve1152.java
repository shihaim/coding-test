package org.example.baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve1152 {
    public static void main(String[] args) {
        /**
         * https://www.acmicpc.net/problem/1152
         * [틀린 이유]
         *  - 빈 값도 나올 수 있음.
         */
        int words = 0;
        boolean _blank = false;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == ' ' && input.length() == 1) _blank = true;
                if (c == ' ' && (i == 0 || i == input.length() - 1)) continue;
                if (c == ' ') words++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(_blank ? words : words + 1);
    }
}
