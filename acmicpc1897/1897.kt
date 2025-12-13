package acmicpc1897

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = st.nextToken().toInt()
    val startWord = st.nextToken().toCharArray()
    val dictionary = Array(91) {
        ArrayList<CharArray>()
    }
    var maxLength = startWord.size
    repeat(N) {
        val word = bf.readLine().toCharArray()
        dictionary[word.size].add(word)
        maxLength = maxLength.coerceAtLeast(word.size)
    }
    val possibleWords = Array(91) {
        ArrayList<CharArray>()
    }
    possibleWords[startWord.size].add(startWord)
    for (curLength in startWord.size + 1 .. maxLength) { //길이별로
        for (longWord in dictionary[curLength]) {
            for (shortWord in possibleWords[curLength - 1]) {
                if (isPossible(shortWord, longWord)) {
                    possibleWords[curLength].add(longWord)
                    break
                }
            }
        }
    }
//    for (arrays in possibleWords) {
//        val sb = StringBuilder()
//        for (chars in arrays) {
//            sb.append("${chars.contentToString()} ")
//        }
//        if (arrays.isNotEmpty()) {
//            println("${arrays.size} : " + sb)
//        }
//    }
    var maxIndex = -1
    for ((index, arrays) in possibleWords.withIndex()) {
        if (arrays.isNotEmpty()) {
            maxIndex = index
        }
    }
    println(possibleWords[maxIndex][0])
}

fun isPossible(shortWord: CharArray, longWord: CharArray): Boolean {
    for (ignoreIndex in 0 until longWord.size) {
        if(compareWords(shortWord, longWord, ignoreIndex)) {
            return true
        }
    }
    return false
}

fun compareWords(shortWord: CharArray, longWord: CharArray, ignoreIndex: Int): Boolean {
    for (index in shortWord.indices) {
        val indexCompare = when (index >= ignoreIndex) {
            true -> index + 1
            false -> index
        }
        if (shortWord[index] != longWord[indexCompare]) {
            return false
        }
    }
    return true
}