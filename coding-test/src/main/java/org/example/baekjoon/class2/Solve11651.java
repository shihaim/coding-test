package org.example.baekjoon.class2;

import java.util.*;

public class Solve11651 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            List<Point> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new Point(sc.nextInt(), sc.nextInt()));
            }

            Collections.sort(list);

            for (int i = 0; i < N; i++) {
                System.out.println(list.get(i).toString());
            }
        }
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.y == p.y) {
            return Integer.compare(this.x, p.x);
        }

        return Integer.compare(this.y, p.y);
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

