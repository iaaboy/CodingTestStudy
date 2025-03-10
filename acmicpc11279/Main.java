package acmicpc11279;

import java.io.*;
import java.util.*;

/* 최대 힙
 * https://www.acmicpc.net/problem/11279
PriorityQueue에 값을 넣고, pop을 요청 받으면 뽑는다. 끝!
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(num);
            }
        }
        System.out.print(sb);
    }
}
