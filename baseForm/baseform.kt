package baseForm

import java.io.*
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    var st = StringTokenizer(bf.readLine())
    var top = 0
    var bottom = 0
    var both = 0
    val hanger = IntArray(N) {
        val hang = st.nextToken().toInt()
        when(hang) {
            1 -> top++
            2 -> bottom++
            3 -> both++
        }
        hang
    }
    st = StringTokenizer(bf.readLine())
    var U = st.nextToken().toInt()
    var D = st.nextToken().toInt()
    if (U > top + both || D > bottom + both) {
        println("NO")
    } else {
        U -= top
        D -= bottom
        for(i in 0 until N) {
            if (U > 0 && hanger[i] == 3) {
                hanger[i] = 1
                U--
            } else if (D > 0 && hanger[i] == 3) {
                hanger[i] = 2
                D--
            }
        }
        val sb = StringBuilder("YES\n")
        for (h in hanger) {
            if (h == 1) {
                sb.append('U')
            } else if (h == 2) {
                sb.append('D')
            }
        }
        println(sb)
    }
}

