### [Baekjoon - 7568,  덩치]
###### \#Brute Force, \#Implementation
문제를 이해하지 못해서 틀린 문제 아래 표를 보자.

| 몸무게 | 키   |
|-----|-----|
| 67  | 181 |
| 66  | 181 |
| 67  | 182 |
다음과 같은 표가 나오면 덩치 순위가 `1 2 1`이 나와야한다. 하지만 나의 경우 `1 3 1`이 나왔다.   
그 이유는 내 앞에 덩치가 큰 사람의 수(k) + 1을 해야하지만, 나의 경우 내림차순으로 정렬을 하고 덩치가 크면 k + 1하고, 아니면 k++을 진행했다.   
문제 해석 능력이 중요하다는 것을 느낀 문제였다. 문제 좀 잘 읽자... 😥

##### 틀린 코드
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            List<Person> people = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                people.add(new Person(i, x, y));
            }

            Collections.sort(people);

            int[] ranks = new int[people.size()];

            Person startPerson = people.get(0);

            int diffOrder = startPerson.getOrder();
            ranks[diffOrder] = 1;
            int diffWeight = startPerson.getWeight();
            int diffHeight = startPerson.getHeight();
            int count = 1;

            for (int i = 1; i < people.size(); i++) {
                Person person = people.get(i);
                int weight = person.getWeight();
                int height = person.getHeight();
                int order = person.getOrder();

                if (diffWeight > weight && diffHeight > height) {
                    ranks[order] = ranks[diffOrder] + count;

                    diffWeight = weight;
                    diffHeight = height;
                    diffOrder = order;
                    count = 1;
                } else {
                    count++;
                    ranks[order] = ranks[diffOrder];
                }
            }

            for (int i = 0; i < ranks.length; i++) {
                System.out.print(i == (ranks.length - 1) ? ranks[i] : ranks[i] + " ");
            }
        }
    }


    static class Person implements Comparable<Person> {
        private int order;
        private int weight;
        private int height;

        public Person(int order, int weight, int height) {
            this.order = order;
            this.weight = weight;
            this.height = height;
        }

        public int getOrder() {
            return order;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public int compareTo(Person p) {
            // 우선 weight를 내림차순으로 비교
            int weightComparison = Integer.compare(p.weight, this.weight);
            if (weightComparison != 0) {
                return weightComparison;
            }

            // weight가 같을 경우 height를 내림차순으로 비교
            return Integer.compare(p.height, this.height);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "order=" + order +
                    ", weight=" + weight +
                    ", height=" + height +
                    '}';
        }
    }
}
```
