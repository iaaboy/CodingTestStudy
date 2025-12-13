package acmicpc28282

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val x = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    st = StringTokenizer(bf.readLine())
    val colorLeft = LongArray(k)
    val colorRight = LongArray(k)
    repeat(x){
        colorLeft[st.nextToken().toInt() - 1]++
    }
    repeat(x){
        colorRight[st.nextToken().toInt() - 1]++
    }
    var total = 0L
    for (i in 0 until k) {
        total += (colorLeft[i] * (x - colorRight[i]))
    }
    println(total)
}