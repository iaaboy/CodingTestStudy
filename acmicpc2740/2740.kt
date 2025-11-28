package acmicpc2740

import java.io.*
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(bf.readLine())
    val N1 = st.nextToken().toInt()
    val M1 = st.nextToken().toInt()
    val arr1 = Array(N1) {
        val arr = IntArray(M1)
        st = StringTokenizer(bf.readLine())
        for (i in 0 until M1) {
            arr[i] = st.nextToken().toInt()
        }
        arr
    }
    st = StringTokenizer(bf.readLine())
    val N2 = st.nextToken().toInt()
    val M2 = st.nextToken().toInt()
    val arr2 = Array(N2) {
        val arr = IntArray(M2)
        st = StringTokenizer(bf.readLine())
        for (i in 0 until M2) {
            arr[i] = st.nextToken().toInt()
        }
        arr
    }

    val result = Array(N1) {
        IntArray(M2)
    }
    for (i in 0 until N1) {
        for (j in 0 until  M2) {
            for (k in 0 until M1) {
                result[i][j] += (arr1[i][k] * arr2[k][j])
            }
        }
    }
    val sb = StringBuilder()
    for (ints in result) {
        for (i in ints) {
            sb.append(i).append(" ")
        }
        sb.append("\n")
    }
    println(sb)
}