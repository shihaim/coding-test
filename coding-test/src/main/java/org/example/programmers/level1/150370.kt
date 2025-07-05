package org.example.programmers.level1

import java.time.LocalDate

/**
 * 프로그래머스
 * 2023 KAKAO BLIND RECRUITMENT
 * 개인정보 수집 유효기간
 */
fun main() {
    val today = "2022.05.19"
    val terms: Array<String> = arrayOf("A 6", "B 12", "C 3")
    val privacies: Array<String> = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")

    val todays = today.split(".")
    val vToday = LocalDate.of(todays[0].toInt(), todays[1].toInt(), todays[2].toInt())

    val termsMap = HashMap<String, Long>()
    terms.forEach { term ->
        val t = term.split(" ")
        termsMap[t[0]] = t[1].toLong()
    }

    val result: MutableList<Int> = mutableListOf()
    privacies.forEachIndexed { index, privacy ->
        val p = privacy.split(" ")
        val date = p[0].split(".")
        val d = LocalDate.of(date[0].toInt(), date[1].toInt(), date[2].toInt())
        // !!는 null이 아님을 보장할 수 있을 때 사용
        val termsDay = d.plusMonths(termsMap[p[1]]!!).minusDays(1)
        val adjustedDate = if (termsDay.dayOfMonth > 28) {
            termsDay.withDayOfMonth(28)
        } else {
            termsDay
        }

        if (adjustedDate.isBefore(vToday)) {
            result.add(index + 1)
        }
    }
}