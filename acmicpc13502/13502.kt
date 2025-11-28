package acmicpc13502

import java.io.*

lateinit var arr : Array<CharArray>
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    arr = Array(5) {
        CharArray(5)
    }
    for (i in 0 .. 4) {
        arr[i] = bf.readLine().replace(" ", "").toCharArray()
    }

    //퍼즐에서 워드를 만든다.
    for (y in 0 .. 0) {
        for (x in 0 .. 0) {
            val visit = Array(5) { BooleanArray(5) }
            val word = CharArray(25)
            word[0] = arr[y][x]
            makeWord(visit, word, y, x, 1)
        }
    }


    //워드를 찾는다.
}

fun makeWord(visit : Array<BooleanArray>, word : CharArray, y : Int, x : Int , count : Int) {
    addWord(word, count)
    for (i in 0 .. 7) {
        val ny = y + dy[i]
        val nx = x + dx[i]
        if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue
        if (!visit[ny][nx]) {
            visit[ny][nx] = true
            word[count] = arr[ny][nx]
            makeWord(visit, word, ny, nx , count + 1)
            visit[ny][nx] = false
        }
    }
}

fun addWord(word : CharArray , count : Int) {
    val sb = StringBuilder()
    for (i in 0 until count) {
        sb.append(word[i])
    }
    println(sb)
}

data class Coord(val word : StringBuilder, val y : Int, val x: Int)

val dx = arrayOf(1,1,0,-1,-1,-1,0,1)
val dy = arrayOf(0,1,1,1,0,-1,-1,-1)