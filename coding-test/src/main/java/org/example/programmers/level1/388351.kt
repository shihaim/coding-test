package org.example.programmers.level1

import java.util.*

/**
 * 프로그래머스
 * 유연근무제
 */
fun main() {
    var desiredTime = 750
    val checkNextTime: Int = desiredTime - (desiredTime / 100) * 100
    println("출근 희망 시각을 10분 더한 경우 : ${checkNextTime}")
    if (checkNextTime >= 50 && checkNextTime <= 59) {
        desiredTime += 50
    } else {
        desiredTime += 10
    }
    println("실제 희망 시각 : ${desiredTime}")
}

fun main2() {
    while (true) {
        val sc = Scanner(System.`in`)

        val n = sc.nextInt()

        /**
         * [직원들이 설정한 출근시각]
         * schedules의 길이 = n <= 1,000
         *  schedules[i] i+1번째 직원이 설정한 출근 희망 시각을 의미
         *  700 <= schedules[i] <= 1100
         */
        val schedules = IntArray(n)
        for (i in 0 until n) {
            schedules[i] = sc.nextInt()
        }

        for (j in 0 until schedules.size) {
            println("${schedules[j]} ")
        }

        /**
         * [직원들이 실제 출근한 시각]
         * timelogs의 길이 = 7
         *  timelogs[i][j]는 i+1번째 직원이 이벤트 j+1일차에 출근한 시각을 의미
         *  600 <= timelogs[i][j] <= 2359
         */
        val timelogs = Array(n) { IntArray(7) }
        for (i in 0 until timelogs.size) {
            for (j in timelogs[i].indices) {
                timelogs[i][j] = sc.nextInt()
            }
        }

        for (i in 0 until timelogs.size) {
            for (j in timelogs[i].indices) {
                print("${timelogs[i][j]} ")
            }
            println()
        }

        /**
         * 1 <= startday <= 7
         * 1은 월요일, 2는 화요일, 3은 수요일, 4는 목요일, 5는 금요일, 6은 토요일, 7은 일요일
         */
        val startday = sc.nextInt()

        /**
         * 중요한 것은 출근은 600부터 1100(실제론 1110)까지 인정되는 것 같음
         */
        var count = IntArray(schedules.size)
        for (i in 0 until schedules.size) {
            /**
             * 600 ~ desiredTime + 10
             * 주의사항: 출근을 원하는 시각이 x50~x59의 경우 (x+1)00~(x+1)09로 지정해야함
             * 50 <= desiredTime - (desiredTime / 100) * 100 <= 59 -> desiredTime + 50
             */
            var desiredTime: Int = schedules[i]
            val checkNextTime: Int = desiredTime - (desiredTime / 100) * 100
            println("출근 희망 시각을 10분 더한 경우 : ${checkNextTime}")
            if (checkNextTime >= 50 && checkNextTime <= 59) {
               desiredTime += 50
            } else {
                desiredTime += 10
            }

            var vStartday: Int = startday
            var vCount = 0
            for (j in 0 until 7) {
                // vStartday == 6 || 7 continue
                if (vStartday == 6) {
                    vStartday++
                    continue
                } else if (vStartday == 7) {
                    vStartday = 1
                    continue
                } else {
                    vStartday++
                }

                val realTime: Int = timelogs[i][j]
                if (realTime >= 600 && realTime <= desiredTime) {
                    vCount++
                }
            }
            count[i] = vCount;
        }

        for (i in 0 until n) {
            println("${i+1}번째 직원 : ${count[i]}")
        }
    }
}