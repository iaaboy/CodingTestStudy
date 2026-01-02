package baseForm

import java.io.*
import java.util.StringTokenizer

/* 팰린드롬과 관련된 수열의 개수, 수학(?)
https://www.acmicpc.net/problem/17360
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val st = StringTokenizer(bf.readLine())
    val nameMap = HashMap<String, Int>()
    repeat(N) {
        val name = st.nextToken()
        nameMap.put(name, 0)
    }

    repeat(N) {
        val st = StringTokenizer(bf.readLine())
        while (st.hasMoreTokens()) {
            val name = st.nextToken()
            nameMap.put(name, nameMap.getOrDefault(name, 0) + 1 )
        }
    }
    val favorites = ArrayList<Favorites>()
    for (entry in nameMap.entries) {
        favorites.add(Favorites(entry.key, entry.value))
    }
    favorites.sortWith { a,b ->
        if (a.count == b.count) {
            a.name.compareTo(b.name)
        } else {
            b.count - a.count
        }
    }
    val sb = StringBuilder()
    for (item in favorites) {
        sb.append("${item.name} ${item.count}\n")
    }
    print(sb)
}
data class Favorites (val name : String, val count : Int)

/*
4
aaa ccc bbb ddd
bbb ddd
aaa ddd
aaa
aaa bbb
 */

