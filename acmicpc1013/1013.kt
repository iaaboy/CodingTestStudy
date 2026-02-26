package acmicpc1013

import java.io.*

/* Contact, 문자열 정규 표현식
https://www.acmicpc.net/problem/1013
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()

    /*
    정규식 풀이

    val regex = Regex("^(100+1+|01)+$")

    repeat(T) {
        val s = br.readLine()
        if (regex.matches(s)) {
            sb.append("YES\n")
        } else {
            sb.append("NO\n")
        }
    }

     */

    fun check100s1s(index: Int, wave: CharArray): Pair<Int, Boolean> {
        var cur = index
        if (cur + 3 >= wave.size) {
            return Pair(-1, false)
        }

        if (!(wave[cur] == '1' && wave[cur + 1] == '0' && wave[cur + 2] == '0')) {
            return Pair(-1, false)
        }
        cur += 3

        //0...
        while (wave[cur] == '0') {
            cur++
            if (cur >= wave.size) {
                return Pair(-1, false)
            }
        }

        var lastCount = 0
        while (cur < wave.size && wave[cur] == '1') {
            lastCount++
            cur++
        }

        return Pair(cur, lastCount > 1)
    }

    fun check01s(index: Int, wave: CharArray): Int {
        if ((index + 1 >= wave.size) || (wave[index + 1] == '0')) {
            return -1
        }
        return index + 2
    }

    val sb = StringBuilder()
    repeat(T) {
        val wave = bf.readLine().toCharArray()

        var i = 0
        var prevState = -1
        while (true) {
            var next: Int
            if (wave[i] == '1') {
                val nx = check100s1s(i, wave)
                if (nx.first == -1) {
                    sb.append("NO\n")
                    break
                }
                next = nx.first
                prevState = if (nx.second) {
                    1
                } else {
                    0
                }
            } else { //wave[i] == '0'
                if (i + 1 < wave.size) {
                    next = check01s(i, wave)
                } else {
                    sb.append("NO\n")
                    break
                }
                if (next == -1) {
                    if (prevState == 1) {
                        val nx2 = check100s1s(i - 1, wave)
                        if (nx2.first == -1) {
                            sb.append("NO\n")
                            break
                        }
                        next = nx2.first
                        prevState = if (nx2.second) {
                            1
                        } else {
                            0
                        }
                    }
                    if (next == -1) {
                        sb.append("NO\n")
                        break
                    }
                } else {
                    prevState = 0
                }
            }
//            println(next)
            if (next == wave.size) {
                sb.append("YES\n")
                break
            } else {
                i = next
            }
        }
    }
    println(sb)
}
