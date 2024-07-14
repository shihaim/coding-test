### 🔗 [Baekjoon - 1018,  체스판 다시 칠하기](https://github.com/shihaim/coding-test/blob/fe47249ec7e11532f79c7f698be7b6c1cf556ca4/coding-test/src/main/java/org/example/baekjoon/class2/Solve1018.java)
###### \#Brute Force

완전 탐색 관련 문제라고 생각이 되어 브루트포스 관련 알고리즘을 검색해보았는데, ChatGPT의 경우 다음과 같이 알려준다.
1. 순열 (Permutation)
2. 조합 (Combination)
3. 부분집합 (Subset)
4. 백트래킹 (Backtracking)

근데 생각보다 정말 간단하다. 그냥 전체 진행되어야할 경우의 수를 반복하면서 색칠하는 방식이다.   
체스판 보드의 색칠을 진행하려는 시작점을 기준으로 번갈아가면서 색상이 동일한지 확인하면 된다.   
또한 시작점이 검은색과 흰색 둘 다 색칠이 가능하므로, 경우의 수가 두 번이나 더 진행된다.   

체스판의 크기가 8X8이므로 X 좌표는 (N - 7)번 Y 좌표는 (M - 7)번 진행되고,  
시작점의 색깔이 두 개이므로 총 진행되는 경우의 수는 2 * (N - 7) * (M - 7)이다.

체스판에서 최대 색칠이 가능한 수는 64개이므로 Math.min 함수를 이용하여 최소 색칠 개수를 구하면 된다.
