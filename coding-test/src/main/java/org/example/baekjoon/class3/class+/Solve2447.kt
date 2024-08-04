package org.example.baekjoon.class3.`class+`

// https://st-lab.tistory.com/95

import java.util.Scanner

lateinit var arr: Array<CharArray>

fun main(args: Array<String>) {
    Scanner(System.`in`).use { sc ->
        val sb = StringBuilder()
        val N = sc.nextInt()

        arr = Array(N) { CharArray(N) }

        star(0, 0, N, false)

        for (i in 0 until N) {
            for (j in 0 until N) {
                sb.append(arr[i][j])
            }
            if (i != N -1) sb.append("\n")
        }

        print(sb)
    }
}

fun star(x: Int, y: Int, N: Int, blank: Boolean) {
    if (blank) {
        for (i in x until x + N) {
            for (j in y until y + N) {
                arr[i][j] = ' '
            }
        }
        return
    }

    if (N == 1) {
        arr[x][y] = '*'
        return
    }

    val size = N / 3
    var count = 0
    for (i in x until x + N step size) {
        for (j in y until y + N step size) {
            count++
            if (count == 5) {
                star(i, j, size, true)
            } else {
                star(i, j, size, false)
            }
        }
    }
}
