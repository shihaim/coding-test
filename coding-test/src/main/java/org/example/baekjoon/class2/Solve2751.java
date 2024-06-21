package org.example.baekjoon.class2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Counting Sort (계수 정렬)을 이용
 * 특정 범위의 정수에서 유용 ( 퀵 정렬, 병합 정렬의 시간복잡도 O(nlogn)보다 빠름. )
 * 기본적으로 오름차순으로 정렬함
 * 시간 복잡도: n + k ( n: 입력 배열의 크기, k: 입력 값의 범위 )
 * 단, k 크기의 배열을 만들어야하므로 많은 메모리 공간이 필요할 수 있다. ( e.g. 1,2,3,4,100000 )
 */
public class Solve2751 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in);) {
            StringBuilder sb = new StringBuilder();
            int N = sc.nextInt();

            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;
            int[] values = new int[N];
            for (int i = 0; i < N; i++) {
                values[i] = sc.nextInt();

                // 1. 최솟값과 최댓값 찾기
                minValue = Math.min(minValue, values[i]);
                maxValue = Math.max(maxValue, values[i]);
            }

            // 2. 카운트용 배열 초기화
            int range = maxValue - minValue + 1;
            int[] countArr = new int[range];
            Arrays.fill(countArr, 0);

            // 3. 입력 배열의 요소를 카운팅하기
            for (int value : values) {
                countArr[value - minValue]++;
            }

            // 4. 카운트 배열의 누적 합 계산
            for (int i = 1; i < countArr.length; i++) {
                countArr[i] += countArr[i - 1];
            }

            // 5. 출력 배열을 생성하고 정렬
            int[] output = new int[values.length];
            for (int i = values.length - 1; i >= 0; i--) {
                output[countArr[values[i] - minValue] - 1] = values[i];
                countArr[values[i] - minValue]--;
            }

            for (int i = 0; i < output.length; i++) {
                sb.append((output[i]) + (i == output.length - 1 ? "" : "\n"));
            }
            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
