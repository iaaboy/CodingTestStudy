package acmicpc1766;

import java.io.*;
import java.util.*;

/* 문제집
 * https://www.acmicpc.net/problem/1766
 
위상정렬 + 우선순위 큐
linkcount를 이용하여 각 노드의 진입차수를 저장하고, 진입차수가 0인 노드를 우선순위 큐에 넣어준다.
큐에서 노드를 꺼내면서 해당 노드와 연결된 노드의 진입차수를 1씩 감소시킨다.
진입차수가 0이 되면 우선순위 큐에 넣어준다.

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
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            linkCount[next]++;
            graph.get(prev).add(next);
        }

        // for (ArrayList<Integer> g : graph) {
        //     System.out.println(g);
        // }
        // System.out.println(Arrays.toString(linkCount));

        for (int i = 0; i <= N; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = N; i >= 1; i--) {
            if (linkCount[i] == 0) {
                pq.add(i);
            }
        }
        
        while (!pq.isEmpty()) {
            int v = pq.poll();
            sb.append(v).append(" ");
            for (int nextV : graph.get(v)) {
                linkCount[nextV]--;
                if (linkCount[nextV] == 0) {
                    pq.add(nextV);
                }
            }
        }
        System.out.println(sb);
    }
}
