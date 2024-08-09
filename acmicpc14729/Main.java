package acmicpc14729;

import java.io.*;
import java.util.*;

/* 칠무해
 * https://www.acmicpc.net/problem/14729
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        PriorityQueue<Float>pq = new PriorityQueue<>((a,b) -> {
            if (a > b) {
                return -1;
            }
            return 1;
        });
        Float[] arr = new Float[N];
        for (int i = 0; i < N; i++) {
            Float num = Float.parseFloat(bf.readLine());
            if (pq.size() < 7) {
                pq.add(num);
            } else {
                if (pq.peek() > num) {
                    pq.add(num);
                    pq.poll();
                }
            }
        }

        Stack<Float>st = new Stack<>();
        while (!pq.isEmpty()) {
            st.add(pq.poll());
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(String.format("%.3f\n", st.pop()));
        }
        System.out.print(sb);
    }
}
