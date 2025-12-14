package acmicpc29197

import java.io.*
import java.util.*
import kotlin.math.abs

/* 아침 태권도, 유클리드 호제법
https://www.acmicpc.net/problem/29197
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val slops = HashSet<Pair<Int,Int>>()
    var flatMinus = 0
    var flatPlus = 0
    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        if (flatPlus != 1 && b == 0 && a > 0) {
            flatPlus = 1
        } else if (flatMinus != 1 && b == 0 && a < 0) {
            flatMinus = 1
        } else if (b != 0) {
            val gcd = abs(ucledianGcd(a,b))
            slops.add(Pair(a/gcd, b/gcd))
//            println("$a $b $gcd")
        }

    }
    val count = slops.size + flatPlus + flatMinus
//    println(slops)
    println(count)
}

private fun ucledianGcd(a: Int, b: Int): Int {
    var a = a
    var b = b
    while (b != 0) {
        val r = a % b
        a = b
        b = r
    }
    return a
}

/*
9
1 2
2 4
-2 2
-4 4
-1 0
-3 0
2 -1
0 1
0 -2
 */