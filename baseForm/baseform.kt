package baseForm

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val M = (N*10) / 11
    println(M)
}