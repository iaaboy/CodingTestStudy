package acmicoc10421

import java.io.*
import java.util.*

/* 수식 완성하기, 완전탐색
https://www.acmicpc.net/problem/10421
 */

lateinit var inArr: IntArray
lateinit var multiResultSize: IntArray
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    val N = bf.readLine().toInt()
    var st = StringTokenizer(bf.readLine())
    inArr = IntArray(N) {
        st.nextToken().toInt()
    }
    multiResultSize = IntArray(inArr[1]) {
        inArr[2 + it]
    }.reversed().toIntArray()

    val K = bf.readLine().toInt()
    st = StringTokenizer(bf.readLine())
    val numbers = HashSet<Int>(K)
    repeat(K) {
        numbers.add(st.nextToken().toInt())
    }
    val firstVal = IntArray(inArr[0])
    val secondVal = IntArray(inArr[1])
    setNum(firstVal, secondVal, numbers, 0)
    println(count)
}

private fun IntArray.toInt(): Int {
    var num = 0
    this.forEach {
        num *= 10
        num += it
    }
    return num
}

var count = 0
fun setNum(firstVal: IntArray, secondVal: IntArray, numbers: HashSet<Int>, index: Int) {
    if (index == firstVal.size + secondVal.size) {
        val isValid = validateDigits(firstVal, numbers, secondVal.toInt(), inArr.last())
        if (!isValid) return
//        println("${firstVal.contentToString()}, ${secondVal.contentToString()} ${firstVal.toInt() * secondVal.toInt()}")
        count++
        return
    }

    for (num in numbers) {
        if (index < firstVal.size) {
            firstVal[index] = num
        } else {
            val secondIndex = secondVal.size - (index - firstVal.size) - 1
            secondVal[secondIndex] = num
            val isValid = validateDigits(firstVal, numbers, num, multiResultSize[secondIndex])
            if (!isValid) continue
        }

        setNum(firstVal, secondVal, numbers, index + 1)
    }
}

fun validateDigits(numArray: IntArray, numbers: HashSet<Int>, num: Int, digitCount: Int): Boolean {
    //numArray 와 num 을 곱한다.
    var arrayNumber = numArray.toInt()
    arrayNumber *= num
    val arrayNumberString = arrayNumber.toString().toCharArray()

    if (arrayNumberString.size != digitCount) return false

    for (nCh in arrayNumber.toString().toCharArray()) {
        val digit = nCh - '0'
        if (!numbers.contains(digit)) {
            return false
        }
    }
    //곱한수와 digit check
//    println("${numArray.toInt()} * $num = $arrayNumber ")
    return true
}