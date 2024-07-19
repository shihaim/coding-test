package org.example.baekjoon.class2;

import java.math.BigDecimal;
import java.util.Scanner;

public class Solve15829 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int L_length = sc.nextInt();
            String L = sc.next();
            BigDecimal result = new BigDecimal(0);
            for (int i = 0; i < L_length; i++) {
                result = result.add(BigDecimal.valueOf(L.charAt(i) - 96).multiply(BigDecimal.valueOf(31).pow(i)));
            }

            System.out.println(result.remainder(BigDecimal.valueOf(1234567891)));
        }
    }
}
