package acmicpc3160

/*
풀이중
 */
fun main() {
    val squareMap = arrayOf(
        hashSetOf(1, 4, 13, 14),
        hashSetOf(2, 5, 14, 15),
        hashSetOf(3, 6, 15, 16),
        hashSetOf(4, 7, 17, 18),
        hashSetOf(5, 8, 18, 19),
        hashSetOf(6, 9, 19, 20),
        hashSetOf(7, 10, 21, 22),
        hashSetOf(8, 11, 22, 23),
        hashSetOf(9, 12, 23, 24),
        hashSetOf(1, 2, 7, 8, 13, 15, 17, 19),
        hashSetOf(2, 3, 8, 9, 14, 16, 18, 20),
        hashSetOf(4, 5, 10, 11, 17, 19, 21, 23),
        hashSetOf(5, 6, 11, 12, 18, 20, 22, 24),
        hashSetOf(1, 2, 3, 10, 11, 12, 13, 17, 21, 16, 20, 24),
    )

    val barMap = HashMap<Int, HashSet<Int>>()
    for ((index, ints) in squareMap.withIndex()) {
        for (i in ints) {
            barMap.getOrPut(i) { HashSet() }.add(index)
        }
    }
    for ((index, ints) in squareMap.withIndex()) {
        println("$index $ints")
    }
}