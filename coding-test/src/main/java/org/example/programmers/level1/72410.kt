package org.example.programmers.level1

/**
 * 프로그래머스
 * 2021 KAKAO BLIND RECRUITMENT
 * 신규 아이디 추천
 */
fun main() {
    val new_id: String = "![][][]!"
    println(solution(new_id))
}

fun solution(new_id: String): String {
    val step1 = step1(new_id)
    val step2 = step2(step1)
    val step3 = step3(step2)
    val step4 = step4(step3)
    val step5 = step5(step4)
    val step6 = step6(step5)
    val step7 = step7(step6)

    var answer: String = step7
    return answer
}

/**
 * 1단계: new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 */
fun step1(new_id: String): String {
    return new_id.lowercase()
}

/**
 * 2단계: new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 */
fun step2(new_id: String): String {
    // "[", "]"의 경우 pattern 인식을 하기 위해 \\가 필요함.
    return new_id.replace(Regex("[~!@#\$%^&*()=+\\[{\\]}:?,<>/]"), "")
}

/**
 * 3단계: new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 */
fun step3(new_id: String): String {
    return new_id.replace(Regex("\\.{2,}"), ".")
}

/**
 * 4단계: new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 */
fun step4(new_id: String): String {
    return new_id.trim('.')
}

/**
 * 5단계: new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 */
fun step5(new_id: String): String {
    return if (new_id.length == 0) "a" else new_id

}

/**
 * 6단계: new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 *       만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 */
fun step6(new_id: String): String {
    return if (new_id.length > 15) new_id.substring(0, 15).trim('.') else new_id
}

/**
 * 7단계: new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */
fun step7(new_id: String): String {
    if (new_id.length > 3) return new_id
    val len: Int = new_id.length
    val lastChar: Char = new_id[len - 1]
    var result: String = new_id
    while (true) {
        if (result.length == 3) break

        result += lastChar
    }
    return result
}