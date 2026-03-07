package acmicpc9011

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/* 순서, 해 구성하기
https://www.acmicpc.net/problem/9011
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val N = bf.readLine().toInt()
        val st = StringTokenizer(bf.readLine())
        val arr = IntArray(N) {
            st.nextToken().toInt()
        }
        val nums = ArrayList<Int>()
        for (i in 1 .. N) {
            nums.add(i)
        }
        val result = IntArray(N)
        var index = 0
        for (i in arr.reversed()) {
            if (i >= nums.size) {
//                println("IMPOSSIBLE")
                result[0] = -1
                break
            }
            result[index++] = nums[i]
            nums.removeAt(i)
        }

        if (result[0] == -1) {
            sb.append("IMPOSSIBLE\n")
        } else {
            for (i in result.size -1 downTo 1) {
                sb.append("${result[i]} ")
            }
            sb.append("${result[0]}\n")
        }

//        println(result.joinToString(" "))
    }
    print(sb)
}
