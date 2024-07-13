package org.example.baekjoon.class2;

import java.util.Arrays;
import java.util.Scanner;

class Solve4949 {
    public static int STACK_INDEX = -1;
    public static char[] brackets = new char[150];

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();

            String word = "";
            while (true) {
                if (".".equals(word)) break;
                /**
                 * 온점(.)이 나올 때까지 계속 +=
                 */
                if (!word.contains(".")) {
                    word += sc.nextLine();
                } else {
                    boolean exceptionCheck = false;

                    for (int i = 0; i < word.length(); i++) {
                        try {
                            char w = word.charAt(i);

                            if (w == '(' || w == '[') {
                                push(w);
                            } else if (w == ')' || w == ']') {
                                pop(w);
                            }
                        } catch (RuntimeException e) {
                            exceptionCheck = true;
                            sb.append("no\n");
                            break;
                        }
                    }

                    if (!exceptionCheck && isEmpty()) {
                        sb.append("yes\n");
                    } else if (!exceptionCheck) {
                        sb.append("no\n");
                    }

                    STACK_INDEX = -1;
                    Arrays.fill(brackets, ' ');
                    word = "";
                }
            }

            System.out.println(sb);
        }
    }

    public static void push(char bracket) throws ArrayIndexOutOfBoundsException {
        brackets[++STACK_INDEX] = bracket;
    }

    public static void pop(char bracket) throws ArrayIndexOutOfBoundsException {
        char popBracket = brackets[STACK_INDEX--];
        boolean match = bracket == changeBracket(popBracket);
        if (!match) throw new RuntimeException();
    }

    public static boolean isEmpty() {
        return STACK_INDEX == -1;
    }

    public static char changeBracket(char bracket) {
        char changedBracket = ' ';
        switch (bracket) {
            case '(':
                changedBracket = ')';
                break;
            case '[':
                changedBracket = ']';
                break;
        }

        return changedBracket;
    }
}