package org.example.baekjoon.class3.`class+`

import java.util.*

var timeArr: IntArray = IntArray(100_001);

fun main(args: Array<String>) {
    Scanner(System.`in`).use { sc ->
        val N = sc.nextInt()
        val K = sc.nextInt()

        println(bfs(N, K))
    }
}

fun bfs(N: Int, K: Int): Int {
    val queue: Queue<Int> = LinkedList()

    queue.add(N);
    timeArr[N] = 0

    while (queue.isNotEmpty()) {
        val n = queue.poll()?:0

        if (n == K) return timeArr[n]

        if (n - 1 >= 0 && timeArr[n - 1] == 0) {
            timeArr[n - 1] = timeArr[n] + 1;
            queue.add(n - 1);
        }

        if (n + 1 <= 100_000 && timeArr[n + 1] == 0) {
            timeArr[n + 1] = timeArr[n] + 1;
            queue.add(n + 1);
        }

        if (n * 2 <= 100_000 && timeArr[n * 2] == 0) {
            timeArr[n * 2] = timeArr[n] + 1;
            queue.add(n * 2);
        }
    }

    return -1;
}