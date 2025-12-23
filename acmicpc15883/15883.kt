package acmicpc15883

/* 풀이중
https://www.acmicpc.net/problem/15883
 */

fun main() {
//    println("start")
    trackNumbers( 0, -1, 0, 0)
//    println(calledCount)
    print(sb)
}
var calledCount =0L
val numArray: IntArray = IntArray(8)
val sb = StringBuilder()
fun trackNumbers (a: Int, a1 : Int, b: Int, count : Int) {
    if (count == 8) {
//        println("${a.toString(16)} + ${b.toString(16)} = ${(a+b).toString(16)}")
//        if (a ==0xd812 && b == 0x48d9) {
//            println("Test")
//        }
        if(!checkNumbers(a,b)) {
            return
        }
        calledCount++
        val c = a + b
        println("${a.toString(16)} + ${b.toString(16)} = ${c.toString(16)}")
//        sb.append("${a.toString(16)} + ${b.toString(16)} = ${c.toString(16)}\n")
        //printNumber
        return
    }
    when (count) {
        0 -> {
            for (num in 1 until 16) {
                numArray[count] = num
                trackNumbers(a * 0x10 + num, a1, b, count + 1)
            }
        }
        1 -> {
            for (num in 0 until 16) {
                numArray[count] = num
                trackNumbers(a * 0x10 + num, num, b, count + 1)
            }
        }
        2 -> {
            for (num in 0 until 16) {
                numArray[count] = num
                trackNumbers(a * 0x10 + num, a1, b, count + 1)
            }
        }
        3 -> {
            for (num in 0 until 16) {
                numArray[count] = num
                if (!validateDigits(0, 3)) continue
                trackNumbers(a * 0x10 + num, a1, b, count + 1)
            }
        }
        4 -> {
            for (num in 1 until 16) {
                numArray[count] = num
                trackNumbers(a, a1, b * 0x10 + num,count + 1)
            }
        }
        5 -> {
            //a의 1과 같은지 확인
            for (num in 0 until 16) {
                if (a1 != num) continue
                numArray[count] = num
                trackNumbers(a, a1, b * 0x10 + num,count + 1)
            }
        }
        6 -> {
            for (num in 0 until 16) {
                //5번째와 1번째가 같을때,
                numArray[count] = num
                trackNumbers(a, a1, b * 0x10 + num,count + 1)
            }
        }
        7 -> {
            for (num in 0 until 16) {
                //5번째와 1번째가 같을때,
                numArray[count] = num
                if (!validateDigits(4, 7)) continue
                trackNumbers(a, a1, b * 0x10 + num,count + 1)
            }
        }
    }
}

fun validateDigits(s : Int, e : Int) : Boolean {
//    val numSet = HashSet<Int>()
//    for (i in s .. e) {
//        if (numSet.contains(numArray[i])) return false
//        numSet.add(numArray[i])
//    }
//    return true
    for (i in s .. e - 1) {
        for (j in i + 1 .. e) {
            if (numArray[i] == numArray[j]) return false
        }
    }
    return true
}

fun checkNumbers(a: Int, b: Int): Boolean {
    var c = a + b
    if (c >= 0xFFFFF || c < 0x10000) {
        return false
    }

    //check
    //S and T
    val newA = a and 0xFF
    val newC = (c and 0xFF000) / 0x1000
    if (newA != newC) return false

    // c의 5개 hex digit이 모두 유니크인지: HashSet 대신 bitmask

    var mask = 0
    repeat(5) {
        val d = c and 0xF
        val bit = 1 shl d
        if ((mask and bit) != 0) return false
        mask = mask or bit
        c = c ushr 4
    }
    return true
}
