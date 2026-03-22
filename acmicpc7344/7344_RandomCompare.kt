package acmicpc7344

import java.io.*
import java.util.StringTokenizer
import kotlin.random.Random

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val T = bf.readLine().toInt()
    val sb = StringBuilder()
    var minCountOrigin: Int
    fun handleStick(s: Array<StickR>) {
        s.sortWith(compareBy<StickR> { it.l }
            .thenBy { it.w })
        var countL = 0
        var prevW = Int.MAX_VALUE
        var prevL = Int.MIN_VALUE
        for (stick in s) {
            //            print("<${stick.l} ${stick.w}> ")
            if (stick.w >= prevW && stick.l >= prevL) {
            } else {
                countL++
            }
            prevW = stick.w
            prevL = stick.l
        }
        //        println()

        s.sortWith(compareBy<StickR> { it.w }
            .thenBy { it.l })
        var countW = 0
        prevW = Int.MAX_VALUE
        prevL = Int.MIN_VALUE
        for (stick in s) {
            //            print("<${stick.l} ${stick.w}> ")
            if (stick.w >= prevW && stick.l >= prevL) {
            } else {
                countW++
            }
            prevW = stick.w
            prevL = stick.l
        }
        //        println()
        println("$countW $countL")
        minCountOrigin = minOf(countW, countL)
        sb.append("${minCountOrigin}\n")
    }

    val r = Random(10)

    repeat(T) {
        val N = bf.readLine().toInt()
        val st = StringTokenizer(bf.readLine())
        val s = Array(N) {
            StickR(st.nextToken().toInt(), st.nextToken().toInt())
        }
//        val num = arrayOf(8, 1, 9, 1, 2, 2, 0 ,7, 3, 7, 9, 8, 2, 9)
//        var index = 0
//        val s = Array(7) {
////            Stick(r.nextInt(10), r.nextInt(10))
//            Stick(num[index++], num[index++])
//        }


        //For test

        lateinit var arr: IntArray
        lateinit var visit: BooleanArray
        var minCount = Int.MAX_VALUE
        fun combination(depth: Int, k: Int) {
            if (depth == k) {
                var count = 0
                var prevW = Int.MAX_VALUE
                var prevL = Int.MIN_VALUE
                val sb = StringBuilder()
                for (i in 0..<k) {
                    sb.append("(${s[arr[i]].w} ${s[arr[i]].l}) ")
                    if (s[arr[i]].w >= prevW && s[arr[i]].l >= prevL) {
                    } else {
                        count++
                    }
                    prevW = s[arr[i]].w
                    prevL = s[arr[i]].l
                }
                if (minCount > count) {
                    sb.append("late ${count} ${minCount}")
                    minCount = count
                    println(sb)

                }
                return
            }
            for (i in 0..<k) {
                if (!visit[i]) {
                    visit[i] = true
                    arr[depth] = i
                    combination(depth + 1, k)
                    visit[i] = false
                }
            }
        }

        fun handleStickSlowly(s: Array<StickR>) {

            arr = IntArray(s.size)
            visit = BooleanArray(s.size)
            combination(0, s.size)
            println(minCount)
        }
        //For test

        handleStick(s)
        handleStickSlowly(s)

//        if (minCount != minCountOrigin) {
//            println("SomeThingWrong : ${s.joinToString(" ")}")
//        }
    }
    print(sb)
}

data class StickR(val l: Int, val w: Int)

/*
1
5
10 2 9 1 4 10 3 9 2 2

1
3
1 2 2 3 4 5

SomeThingWrong : Stick(l=8, w=1) Stick(l=9, w=1) Stick(l=2, w=2) Stick(l=0, w=7) Stick(l=3, w=7) Stick(l=9, w=8) Stick(l=2, w=9)
1
7
8 1 9 1 2 2 0 7 3 7 9 8 2 9
 */
