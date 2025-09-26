package acmicpc32408;

import java.io.*;
import java.util.*;

/* 대전 도시철도 2호선
 * https://www.acmicpc.net/problem/32408
 */

public class Main {
    static Vertex[] v;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        v = new Vertex[N + 1];
        for (int i = 0; i <= N; i++) {
            v[i] = new Vertex();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            v[start].nodes.add(end);
            v[end].nodes.add(start);
        }
        Stack<Integer> firstLine = new Stack<>();
        visited = new boolean[N + 1];
        visited[1] = true;
        firstLine.push(1);
        find1stLine(firstLine, 1);

        // System.out.println(firstLine);
        visited = new boolean[N + 1];
        while (!firstLine.isEmpty()) {
            visited[firstLine.pop()] = true;
        }
        Stack<Integer> soleCount = new Stack<Integer>();
        long totalCount = 0;
        for (int i = 1; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int count = getCount(i);
                // System.out.println(i + " : " + count);
                soleCount.add(count);
                totalCount += count;
            }
        }
        // System.out.println(soleCount);
        long possibleLines = 0;
        while (soleCount.size() > 1) {
            Integer c = soleCount.pop();
            totalCount -= c;
            possibleLines += c * totalCount;
        }
        System.out.println(possibleLines);
    }

    private static Integer getCount(int c) {
        int count = 1;
        for (Integer next : v[c].nodes) {
            if (!visited[next]) {
                visited[next] = true;
                count += getCount(next);
            }
        }
        return count;
    }

    private static boolean find1stLine(Stack<Integer> firstLine, int c) {
        // System.out.println(c + " : " + firstLine);
        if (c == N) {
            return true;
        }
        for (Integer next : v[c].nodes) {
            if (!visited[next]) {
                firstLine.push(next);
                visited[next] = true;
                if (find1stLine(firstLine, next)) {
                    return true;
                }
                firstLine.pop();
            }
        }
        return false;
    }

    static class Vertex {
        ArrayList<Integer> nodes = new ArrayList<>();
    }
}

/*
11
1 2
1 3
1 4
2 5
3 6
4 7
4 8
6 9
9 10
1 11
 */