package acmicpc2623;

import java.io.*;
import java.util.*;

/* 음악프로그램
 * https://www.acmicpc.net/problem/2623
 */

 /*
위상 정렬 알고리즘 기본.
순환이 발생한 경우 0 을 출력하도록
  */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[] linkCount = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int K = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < K; j++) {
                int next = Integer.parseInt(st.nextToken());
                if (prev != next) {
                    linkCount[next]++;
                    graph.get(prev).add(next);
                }
                prev = next;
            }
        }

        // for (ArrayList<Integer> g : graph) {
        //     System.out.println(g);
        // }
        // System.out.println(Arrays.toString(linkCount));

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (linkCount[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (q.isEmpty()) { //순환이 발생한 경우.
                System.out.println(0);
                return;
            }
            int v = q.poll();
            sb.append(v).append("\n");
            for (int nextV : graph.get(v)) {
                linkCount[nextV]--;
                if (linkCount[nextV] == 0) {
                    q.add(nextV);
                }
            }
        }
        System.out.print(sb);
    }
}

/*
6 3
3 1 4 3
4 6 2 5 4
3 2 3 4
 */