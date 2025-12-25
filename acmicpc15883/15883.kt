package acmicpc15883

/* First In Last Out, 구현 백트랙킹
https://www.acmicpc.net/problem/15883
 */

fun main() {
    for (L in 1..15) {
        for (I in 0..15) {
            for (S in 1..15) {
                for (T in 0..15) {
                    for (F in 1..15) {
                        for (O in 0 .. 15) {
                            if(!unique6(L,I,S,T,F,O)) continue

                            val a = L * 0x1000 + I * 0x100 + S * 0x10 + T
                            val b = F * 0x1000 + I * 0x100 + L * 0x10 + O
                            val c = a + b

                            val S3 = (c ushr 16) and 0xF
                            val T3 = (c ushr 12) and 0xF
                            val A3 = (c ushr 8) and 0xF
                            val C3 = (c ushr 4) and 0xF
                            val K3 = c and 0xF
                            if (S != S3 || T != T3) continue

                            if(!unique9(L,I,S,T,F,O,A3,C3,K3)) continue

                            println("${a.toString(16)} + ${b.toString(16)} = ${c.toString(16)}")
                        }
                    }
                }
            }
        }
    }
}

fun unique6(L:Int,I:Int,S:Int,T:Int,F:Int,O:Int): Boolean {
    var mask = 0
    fun add(x:Int): Boolean {
        val bit = 1 shl x
        if ((mask and bit) != 0) return false
        mask = mask or bit
        return true
    }
    return add(L) && add(I) && add(S) && add(T) && add(F) && add(O)
}

fun unique9(
    a: Int, b: Int, c: Int,
    d: Int, e: Int, f: Int,
    g: Int, h: Int, i: Int
): Boolean {
    var mask = 0

    fun add(x: Int): Boolean {
        val bit = 1 shl x
        if ((mask and bit) != 0) return false
        mask = mask or bit
        return true
    }

    return add(a) &&
            add(b) &&
            add(c) &&
            add(d) &&
            add(e) &&
            add(f) &&
            add(g) &&
            add(h) &&
            add(i)
}
