package acmicpc33902

import java.util.StringTokenizer

/* 게임의 신, 게임이론
https://www.acmicpc.net/problem/33902
 */

fun main() {
    val st = StringTokenizer(readLine())
    val X = st.nextToken().toInt()
    val Y = st.nextToken().toInt()

    fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b

        while (y != 0) {
            val temp = x % y
            x = y
            y = temp
        }
        return x
    }

    fun isCoprime(a: Int, b: Int): Boolean {
        return gcd(a, b) == 1
    }

    val map = BooleanArray(Y + 1)

    for (me in Y downTo X) {
        for (you in me downTo X) {
            if (me == you) continue
            if (!map[me] && !map[you]) {
                if (isCoprime(me, you)) {
                    map[you] = true
                }
            }
        }
    }
//    for (i in X..Y) {
//        println("$i : ${map[i]}")
//    }
    val result = if (map[X]) {
        "khj20006"
    } else {
        "putdata"
    }
    println(result)
}
