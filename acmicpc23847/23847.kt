package acmicpc23847

import java.io.*
import java.util.*

/* INU 막대기, 오일러 경로
https://www.acmicpc.net/problem/23847
 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toInt()
    val sticks = ArrayList<Triple<Char, Char, Int>>()

    repeat(n) {
        val st = StringTokenizer(bf.readLine())
        val letters = st.nextToken()
        sticks.add(Triple(letters[0], letters[1], st.nextToken().toInt()))
    }

    val graph = HashMap<Char, MutableList<Pair<Char, Int>>>()
    val degree = HashMap<Char, Int>()

    val vertex = arrayOf('I', 'N', 'U')
    vertex.forEach { v ->
        graph[v] = mutableListOf()
        degree[v] = 0
    }

    sticks.forEach { (u, v, w) ->
        graph.getValue(u).add(Pair(v, w))
        graph.getValue(v).add(Pair(u, w))
        degree[u] = degree.getValue(u) + 1
        degree[v] = degree.getValue(v) + 1
    }

//    println(graph)

    val visited = HashSet<Char>()
    val components = ArrayList<List<Char>>()

    fun dfs(node: Char, component: ArrayList<Char>) {
        visited.add(node)
        component.add(node)
        graph.getValue(node).forEach { (neighbor, _) ->
            if (neighbor !in visited) {
                dfs(neighbor, component)
            }
        }
    }

    vertex.forEach { v ->
        if (v !in visited && degree.getValue(v) > 0) {
            val component = ArrayList<Char>()
            dfs(v, component)
            components.add(component)
        }
    }

//    println(visited)
//    println(components)

    fun maxPathInComponent(comp: List<Char>): Int {
        val oddDegreeCount = comp.count { degree.getValue(it) % 2 == 1 }

        if (oddDegreeCount == 0 || oddDegreeCount == 2) {
            return sticks.filter { (u, v, _) -> u in comp || v in comp }.sumOf { it.third }
        }

        return 0
    }

    val answer = components.maxOfOrNull { maxPathInComponent(it) } ?: 0
    println(answer)
}

/*

7
II 3
II 3
II 3
IN 5
IN 2
UU 7
NU 3

>> 26

5
II 3
II 3
II 3
UU 7
NU 3

5
II 3
II 3
II 3
IN 5
IN 2

4
II 3
IN 5
IN 2
IU 4

>> 14
 */