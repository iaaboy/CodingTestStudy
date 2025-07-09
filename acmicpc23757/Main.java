package acmicpc23757;

import java.io.*;
import java.util.*;

/* 아이들과 선물 상자
 * https://www.acmicpc.net/problem/23757
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(bf.readLine());
        boolean result = true;
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!result || pq.isEmpty())
                continue;
            if (num <= pq.peek()) {
                if (num != pq.peek()) {
                    pq.add(pq.poll() - num);
                }
            } else {
                result = false;
            }
        }
        System.out.println(result ? 1 : 0);
    }
}
