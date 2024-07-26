package org.example.baekjoon.class3.`class+`

import java.util.*

fun main(args: Array<String>) {
    Scanner(System.`in`).use { sc ->
        val N = sc.nextInt()
        val M = sc.nextInt()
        sc.nextLine()

        val arr: Array<String> = Array(N+M) { i -> "" }

        for (i in 0 until N + M) {
            arr[i] = sc.nextLine()
        }

        val map = HashMap<String, Int>()

        for (i in 0 until N) {
            val name = arr[i]
            map[name] = 0
        }

        for (i in N until N+M) {
            val name = arr[i]
            val isExists = map.getOrElse(name, { -1 })
            if (isExists == 1 || isExists == -1) {
                continue
            } else {
                map[name] = 1
            }
        }

        val result = map
            .filter { it.value != 0 }
            .map { it -> it.key }
            .toList()

        Collections.sort(result)

        val sb = StringBuffer()

        sb.append(result.size).append("\n")
        result.forEach { it -> sb.append(it).append("\n") }
        sb.deleteCharAt(sb.lastIndexOf("\n"));

        println(sb)
    }
}

