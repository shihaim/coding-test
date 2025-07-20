package org.example.programmers.level1

/**
 * 프로그래머스
 * 2022 KAKAO BLIND RECRUITMENT
 * 신고 결과 받기
 */
fun main() {
    val id_list: Array<String> = arrayOf("muzi", "frodo", "apeach", "neo")
    val report: Array<String> = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
    val k = 2

    println(solution(id_list, report, k))
}

/**
 * 각 유저별로 처리 결과 메일을 받은 횟수
 */
fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {

    // 반대로 신고를 한 유저를 찾아서 만들기, 동일 유저에 대한 신고는 1회만 처리됨. (Set을 이용하여 중복제거)
    // 이후 count가 k 이상인 유저만 필터링한 후 Value에 대해 결과 메일 유저 Map에 ++ 해주기

    /**
     * 필요한 컬렉션
     *  1. 결과 처리 메일 Map<String, Int>
     *  2. 신고 누적 Map<String, MutableSet<String>>
     */
    val complainResultMap = initComplainResultMap(id_list)

    report.forEach { r ->
        val user = r.split(" ")[0]
        val reportedUser = r.split(" ")[1]

        complainResultMap.getOrPut(reportedUser) { mutableSetOf() }.add(user)
    }

    val reportCountingMap = initReportCountingMap(id_list)

    complainResultMap.entries
        .filter { it.value.size >= k }
        .forEach { (key, value) ->
            value.forEach { v ->
                reportCountingMap[v] = reportCountingMap.getOrDefault(v, 0) + 1
            }
        }

    var answer: IntArray = reportCountingMap.values.toIntArray()
    return answer
}

fun initReportCountingMap(id_list :Array<String>): LinkedHashMap<String, Int> {
    return id_list.associateWith { 0 }.toMap(LinkedHashMap())
}

fun initComplainResultMap(id_list :Array<String>): MutableMap<String, MutableSet<String>> {
    return id_list.associateWith { mutableSetOf<String>() }.toMutableMap()
}
