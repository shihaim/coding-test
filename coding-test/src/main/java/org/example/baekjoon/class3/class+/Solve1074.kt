package org.example.baekjoon.class3.`class+`

import java.util.Scanner

var value: Int = 0

fun main(args: Array<String>) {
    Scanner(System.`in`).use { sc ->
        val N = sc.nextInt()
        val r = sc.nextInt()
        val c = sc.nextInt()

        val size = Math.pow(2.0, N.toDouble()).toInt()
        recursive(size, r, c)
        print(value)
    }
}

fun recursive(size: Int, x: Int, y: Int) {
    if (size == 1) return

    if (x < size/2 && y < size/2) {
        recursive(size/2, x, y);
    } else if (x < size/2 && y >= size/2) {
        value += size * size/4
        recursive(size/2, x, y - size/2);
    } else if (x >= size/2 && y < size/2) {
        value += (size * size/4) * 2
        recursive(size/2, x - size/2, y);
    } else {
        value += (size * size/4) * 3
        recursive(size/2, x - size/2, y - size/2);
    }
}