package acmicpc20166;

import java.io.*;
import java.util.*;

/* 문자열 지옥에 빠진 호석
 * https://www.acmicpc.net/problem/20166
 */

/*
DFS로 모든 경우의 수를 탐색하며, 5글자가 될 때까지 countMap에 저장.
query를 받아서 countMap에서 찾아서 출력.
 */

public class Main {
    static char[][] map;
    static Map<String, Integer> countMap;
    static int K, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
        }
        countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, String.valueOf(map[i][j]));
            }
        }

        // System.out.println(countMap);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            String inWord = bf.readLine();
            sb.append(countMap.getOrDefault(inWord, 0)).append("\n");
            // System.out.println(countMap.getOrDefault(inWord, 0));
        }
        System.out.print(sb);
    }

    static void dfs(int y, int x, String word) {
        String s = word;
        countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        if (word.length() == 5) {

            // System.out.println(countMap);
            return;
        }
        int[] dx = { 1, 0, 0, -1, 1, 1, -1, -1 };
        int[] dy = { 0, 1, -1, 0, -1, 1, -1, 1 };
        for (int d = 0; d < 8; d++) {
            int nx = (M + x + dx[d]) % M;
            int ny = (N + y + dy[d]) % N;
            dfs(ny, nx, word + map[ny][nx]);
        }
    }
}
