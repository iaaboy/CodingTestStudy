package acmicpc14427;

import java.io.*;
import java.util.*;

/* 수열과 쿼리 15
 * https://www.acmicpc.net/problem/14427
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Number[] numbers = new Number[N + 1];
        PriorityQueue<Number> pq = new PriorityQueue<>((a, b) -> {
            if (a.num == b.num) {
                return a.key - b.key;
            } else {
                return a.num - b.num;
            }
        });
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int index = 1;
        for (; index <= N; index++) {
            numbers[index] = new Number(Integer.parseInt(st.nextToken()), index);
            pq.add(numbers[index]);
        }

        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(bf.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int i = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                numbers[i].isUsed = true;
                numbers[i] = new Number(v, i);
                pq.add(numbers[i]);
            } else {
                while (!pq.isEmpty() && pq.peek().isUsed) {
                    pq.poll();
                    // System.out.println("pop: " + a);
                }
                sb.append(pq.peek().key).append("\n");
            }
        }
        System.out.print(sb);
    }

    static class Number {
        int num;
        int key;

        public Number(int num, int key) {
            this.num = num;
            this.key = key;
        }

        @Override
        public String toString() {
            return num + "(" + key + ")";
        }

        boolean isUsed;
    }
}
