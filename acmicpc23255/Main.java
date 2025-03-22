package acmicpc23255;

import java.io.*;
import java.util.*;

/* 구름다리 2
 * https://www.acmicpc.net/problem/23255
 
 id가 작은것부터, 
 큰 순서대로 실행.
 주위에 있는 id중 가능한 가장 작은 값을 내 id로 지정.
 */

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        int[] color = new int[N + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            TreeSet<Integer> near = new TreeSet<>();
            for (int j : graph[i]) {
                if (color[j] != 0) {
                    near.add(color[j]);
                }
            }

            // System.out.println(i + ":" + near);
            int c = 1;
            for (int j : near) {
                if (j != c) {
                    break;
                }
                c++;
            }
            color[i] = c;
            sb.append(color[i]).append(" ");
        }

        System.out.println(sb);
    }
}
