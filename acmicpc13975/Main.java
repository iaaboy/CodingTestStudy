package acmicpc13975;

import java.io.*;
import java.util.*;

/* 파일 합치기 3
 * https://www.acmicpc.net/problem/13975
합쳐야할 파일들의 크기가 낮을 순으로  PriorityQueue에 저장한 뒤 하나씩 꺼내면서 합침
PriorityQueue + 애드혹
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while (pq.size() >= 2) {
                long c = pq.poll();
                c += pq.poll();
                sum += c;
                pq.add(c);
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}