package org.example.baekjoon.class2;

import java.util.*;

public class Solve10814 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            StringBuilder sb = new StringBuilder();
            int N = sc.nextInt();

            List<Person> people = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                people.add(new Person(sc.nextInt(), sc.next(), i));
            }

            Collections.sort(people);

            int size = people.size();
            for (int i = 0; i < size; i++) {
                sb.append((i == size - 1) ? people.get(i).toString() : (people.get(i).toString() + "\n"));
            }

            System.out.println(sb);
        }
    }

    static class Person implements Comparable<Person> {
        int age;
        String name;
        int order;

        public Person(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

        @Override
        public int compareTo(Person o) {
            // 오름차순
            int ageCompare = Integer.compare(this.age, o.age);
            if (ageCompare != 0) {
                return ageCompare;
            }

            // 오름차순
            int orderCompare = Integer.compare(this.order, o.order);
            if (orderCompare != 0) {
                return orderCompare;
            }

            return 0;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}

