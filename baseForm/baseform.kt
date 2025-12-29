package baseForm

import java.io.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val numSet = HashSet<Int>()
    for (i in 1 .. 9) {
        for (j in 1 .. 9) {
            numSet.add(i*j)
        }
    }
    when(numSet.contains(N)) {
        true -> println(1)
        false -> println(0)
    }
}

