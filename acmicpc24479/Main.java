package acmicpc24479;

import java.io.*;
import java.util.*;

/* 알고리즘 수업 - 깊이 우선 탐색 1
 * https://www.acmicpc.net/problem/24479
 */

public class Main {
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer ste = new StringTokenizer(bf.readLine());
            nodes.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        int [] visited = new int[N];
        dfs(E, 1);
    }

    static void dfs(int now , int count) { // # V : 정점 집합, E : 간선 집합, R : 시작 정점
//        visited[count] = now;

    }
}
