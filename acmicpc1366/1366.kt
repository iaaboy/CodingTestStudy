package acmicpc1366

import java.io.*
import java.util.*

/* 기타 코드, 브룻포스
https://www.acmicpc.net/problem/1366
 */

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val notes = arrayOf(
        "A","A#","B","C","C#","D",
        "D#","E","F","F#","G","G#"
    )

    val noteMap = HashMap<String, Int>()
    for (i in notes.indices) {
        noteMap[notes[i]] = i
    }

    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val strings = IntArray(N) {
        noteMap[st.nextToken()]!!
    }

    st = StringTokenizer(br.readLine())
    val chord = IntArray(M) {
        noteMap[st.nextToken()]!!
    }

    var minDifficulty = Int.MAX_VALUE

    val used = BooleanArray(12)
    val frets = IntArray(N)
    val notesSelected = IntArray(N)

    fun dfs(idx: Int) {

        if (idx == N) {
//
//            println(" -- ")
//            println(notesSelected.joinToString(" "))
//            println(frets.joinToString(" "))

            var minFret = Int.MAX_VALUE
            var maxFret = 0

            for (i in 0 until N) {

                val note = notesSelected[i]
                val fret = frets[i]

                used[note] = true

                if (fret != 0) {
                    minFret = minOf(minFret, fret)
                    maxFret = maxOf(maxFret, fret)
                }
            }

            var valid = true
            for (c in chord) {
                if (!used[c]) {
                    valid = false
                    break
                }
            }

            if (valid) {
                if (minFret == Int.MAX_VALUE) {
                    minDifficulty = 0
                } else {
                    minDifficulty = minOf(minDifficulty, maxFret - minFret + 1)
                }
            }

            for (i in 0 until N) {
                used[notesSelected[i]] = false
            }

            return
        }

        for (c in chord) {

            notesSelected[idx] = c

            val base = if (c >= strings[idx]) {
                c - strings[idx]
            } else {
                c - strings[idx] + 12
            }

            frets[idx] = base
            dfs(idx + 1)

            frets[idx] = base + 12
            dfs(idx + 1)
        }
    }

    dfs(0)

    println(minDifficulty)
}
