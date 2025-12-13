package acmicpc26265

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val relation = HashMap<String, ArrayList<String>>()
    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        val mentor = st.nextToken()
        val mentee = st.nextToken()
        if (!relation.containsKey(mentor)) {
            val mList = ArrayList<String>()
            mList.add(mentee)
            relation.put(mentor, mList)
        } else {
            relation[mentor]?.add(mentee)
        }
    }
    for (mentee in relation.values) {
        mentee.sortDescending()
    }
    val sb = StringBuilder()
    for(mentor in relation.keys.sorted()) {
        relation.get(mentor)?.forEach {
            sb.append("$mentor $it\n")
        }
    }
    print(sb)
}