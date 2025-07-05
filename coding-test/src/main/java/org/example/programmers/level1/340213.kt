package org.example.programmers.level1

/**
 * 프로그래머스
 * [PCCP 기출문제] 1번 / 동영상 재생기
 */
fun main() {
//    val video_len: String = "34:33" // 동영상 길이
//    val pos: String = "13:00" // 재생 위치
//    val op_start: String = "00:55" // 오프닝 시작 시각
//    val op_end: String = "02:55" // 오프닝 끝나는 시작
//    val commands: Array<String> = arrayOf("next", "prev") // 기능

//    val video_len: String = "10:55"
//    val pos: String = "00:05"
//    val op_start: String = "00:15"
//    val op_end: String = "06:55"
//    val commands: Array<String> = arrayOf("prev", "next", "next")

    val video_len: String = "30:01"
    val pos: String = "29:55"
    val op_start: String = "01:00"
    val op_end: String = "01:30"
    val commands: Array<String> = arrayOf("next")

    /**
     * 10초 전: prev
     * 10초 후: next
     * 오프닝 건너뛰기: 오프닝 구간(op_start <= 현재 재생 위치 <= op_end)인 경우 자동으로 op_end로 이동
     */


    var index: Int = 0
    var curPos: String = pos

    /**
     * String 이므로 next의 경우 50~ 59 사이일 때 1분을 더하는 것을 추가
     * prev의 경우 0~9 사이일 때 1분을 빼는 것이 추가
     */
    for (command in commands) {
        // 오프닝 건너뛰기를 먼저 검사
        if (curPos in op_start..op_end) {
            curPos = op_end
        }

        val time: IntArray = curPos.split(":")
            .map { it.toInt() }
            .toIntArray()

        when (command) {
            "prev" -> {
                if (time[1] - 10 < 0) {
                    if (time[0] -1 < 0) {
                        time[1] = 0
                    } else {
                        time[0]--
                        time[1] = 60 + (time[1] - 10)
                    }
                } else {
                    time[1] -= 10
                }
            }
            "next" -> {
                if (time[1] + 10 > 59) {
                    if (time[0] +1 > 59) {
                        time[1] = 59
                    } else {
                        time[0]++
                        time[1] = (time[1] + 10) - 60
                    }
                } else {
                    time[1] += 10
                }
            }
        }

        val minutes = if (time[0] < 10) "0" + time[0].toString() else time[0].toString()
        val seconds = if (time[1] < 10) "0" + time[1].toString() else time[1].toString()
        curPos = "$minutes:$seconds"

        if (curPos < "00:00") {
            curPos = "00:00"
        }

        if (curPos > video_len) {
            curPos = video_len
        }

        // 이후 오프닝 건너뛰기 한번 더 검사
        if (curPos in op_start..op_end) {
            curPos = op_end
        }

        println("curPos = ${curPos}")
    }
}
