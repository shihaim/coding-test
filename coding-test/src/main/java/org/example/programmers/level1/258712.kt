package org.example.programmers.level1

/**
 * 프로그래머스
 * 2024 KAKAO WINTER INTERNSHIP
 * 가장 많이 받은 선물
 */
fun main() {
    val friends: Array<String> = arrayOf("muzi", "ryan", "frodo", "neo")
    val gifts: Array<String> = arrayOf("muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi")

    // 친구들의 배열의 위치를 저장하는 Map
    val friendMap = HashMap<String, Int>()
    friends.forEachIndexed { index, name -> friendMap[name] = index }

    // 누구에게 선물을 줬는지에 대한 지표
    var giftGivingIndex: Array<IntArray> = Array(friends.size) { IntArray(friends.size) }

    // 선물지수
    var giftTotalIndex: Array<IntArray> = Array(friends.size) { IntArray(3) }

    /**
     * muzi가 0번이고 frodo가 2번
     * muzi가 frodo에게 준다면? A의 행과 B의 열의 배열을 1증가 -> (0, 2)에서 +1
     * 반대로 frodo가 muzi에게 준다면? A의 행과 B의 열의 배열을 1증가 (2, 0)에서 +1
     */
    gifts.forEach { gift ->
        val (A, B) = gift.split(" ")
        val A_index: Int = friendMap.getValue(A)
        val B_index: Int = friendMap.getValue(B)

        // 주고 받은 선물 수 증가
        giftGivingIndex[A_index][B_index]++

        // 선물 지수 증/감 처리
        giftTotalIndex[A_index][0]++
        giftTotalIndex[B_index][1]++
    }

    for (i in friends.indices) {
        giftTotalIndex[i][2] = giftTotalIndex[i][0] - giftTotalIndex[i][1]
    }

    // 0, 1, 2, 3
    // 0, 1, 2, 3

    /**
     * 정사각형 배열에서의 대칭은 다음과 같음
     * (i`, j`) = (N - 1 - i, N - 1 - j)
     * 1. 0 ~ N-1 까지 for을 돌려서 자기자신과 친구를 비교하여 선물을 더 줬는지 확인 (i == j) continue
     * 2. 비교시 대칭되는 배열을 확인하여  1차적으로 더 많이 준 사람에게 주도록 하고,
     * 3. 만약 둘 다 0이라면 선물 지수를 비교하여 더 큰 사람이 받는다.
     */
    var result = 0
    for (i in friends.indices) {
        var AResult = 0
        for (j in friends.indices) {
            if (i == j) continue

            val AtoB = giftGivingIndex[i][j]
            val BtoA = giftGivingIndex[j][i]

            if (AtoB == BtoA) {
                val ATotalIndex = giftTotalIndex[i][2]
                val BTotalIndex = giftTotalIndex[j][2]

                if (ATotalIndex > BTotalIndex) {
                    AResult++
                }
            } else if (AtoB > BtoA) {
                AResult++
            }
        }

        result = Math.max(result, AResult)
    }

    println("result = $result")
}