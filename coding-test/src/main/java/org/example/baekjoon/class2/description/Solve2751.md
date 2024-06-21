### [Baekjoon - 2751,  수 정렬하기 2]
###### \#Counting Sort, \#Implementation
* Counting Sort (계수 정렬)을 이용
* 특정 범위의 정수에서 유용 ( 퀵 정렬, 병합 정렬의 시간복잡도 O(nlogn)보다 빠름. )
* 기본적으로 오름차순으로 정렬함
* 시간 복잡도: n + k ( n: 입력 배열의 크기, k: 입력 값의 범위 )
* 단, k 크기의 배열을 만들어야하므로 많은 메모리 공간이 필요할 수 있다. ( e.g. 1,2,3,4,100000 )


![Solve2751](https://github.com/shihaim/coding-test/blob/main/images/counting_sort.gif)