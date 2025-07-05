package org.example.programmers.level1

import kotlin.math.abs

/**
 * 프로그래머스
 * 2022 KAKAO TECH INTERNSHIP
 * 성격 유형 검사하기
 */
fun main() {

    /**
     * survey
     * 1번 지표 R, T
     * 2번 지표 C, F
     * 3번 지표 J, M
     * 4번 지표 A, N
     *
     * 원소의 첫 번째 유형은 비동의 관련 지표
     * 원소의 두 번째 유형은 동의 관련 지표
     */
//    val survey: Array<String> = arrayOf("AN", "CF", "MJ", "RT", "NA")
    val survey: Array<String> = arrayOf("TR", "RT", "TR")

    /**
     * choices
     * 1: 매우 비동의 (3점)
     * 2: 비동의     (2점)
     * 3: 약간 비동의 (1점)
     * 4: 모르겠음    (0점)
     * 5: 약간 동의   (1점)
     * 6: 동의       (2점)
     * 7: 매우 동의   (3점)
     */
//    val choices: Array<Int> = arrayOf(5, 3, 2, 7, 5)
    val choices: Array<Int> = arrayOf(7, 1, 3)

    val personality: MutableMap<String, Int> = mutableMapOf(
        "R" to 0,
        "T" to 0,
        "C" to 0,
        "F" to 0,
        "J" to 0,
        "M" to 0,
        "A" to 0,
        "N" to 0,
    )

    /**
     * 숫자가 4보다 크면 오른쪽 지표가 점수를 얻음
     * 숫자가 4보다 작으면 왼쪽 지표가 점수를 얻음
     */
    for (i in survey.indices) {
        val kind1 = survey[i].toCharArray()[0]
        val kind2 = survey[i].toCharArray()[1]

        val choice = choices[i]
        if (choice > 4) {
            personality[kind2.toString()] = personality.getOrDefault(kind2.toString(), 0) + abs(choice - 4)
        } else if (choice < 4) {
            personality[kind1.toString()] = personality.getOrDefault(kind1.toString(), 0) + abs(choice - 4)
        } else {
            // 아무런 점수를 얻지 못함.
        }
    }

    val sb = StringBuilder()
    val personalityList: List<String> = listOf("R", "T", "C", "F", "J", "M", "A", "N")
    for (i in 0..7 step 2) {
        val kind1 = personalityList[i]
        val kind2 = personalityList[i + 1]

        val kind1Score: Int = personality[kind1] ?: 0
        val kind2Score: Int = personality[kind2] ?: 0

        if (kind1Score > kind2Score) {
            sb.append(kind1)
        } else if (kind2Score > kind1Score) {
            sb.append(kind2)
        } else {
            // 사전 순
            sb.append(minOf(kind1, kind2))
        }
    }

    println("sb = ${sb}")
}