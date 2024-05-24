package acmicpc31860;

import java.io.*;
import java.util.*;

/* 열심히 일하는 중
 * https://www.acmicpc.net/problem/31860
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 개수
        int M = Integer.parseInt(st.nextToken()); // 중요도 감소
        int K = Integer.parseInt(st.nextToken()); // 중요도 기준

        PriorityQueue<Integer> works = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < N; i++) {
            works.add(Integer.parseInt(bf.readLine()));
        }

        int satisfaction = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (!works.isEmpty() && works.peek() > K) {
            int workHandled = works.poll();
            count++;
            satisfaction = satisfaction / 2 + workHandled;
            sb.append(satisfaction + "\n");
            works.add(workHandled - M);
        }
        sb.insert(0, count + "\n");
        System.out.println(sb.toString());
    }
}
