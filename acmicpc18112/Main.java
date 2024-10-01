package acmicpc18112;

import java.io.*;
import java.util.*;

/* 이진수 게임
 * https://www.acmicpc.net/problem/18112
 */

public class Main {
    static int out;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int in = Integer.parseInt(bf.readLine(), 2);
        out = Integer.parseInt(bf.readLine(), 2);

        Queue<Integer> pq = new ArrayDeque<>();
        pq.add(in);
        HashMap<Integer, Integer> visited = new HashMap<>();
        visited.put(in, 0);

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur == out) {
                System.out.println(visited.get(cur));
                break;
            }

            for (int i = 1; i <= (cur >> 1); i = i << 1) {
                int next = cur ^ i;
                if (!visited.containsKey(next)) {
                    pq.add(next);
                    visited.put(next, visited.get(cur) + 1);
                }
            }

            // 현재 수에 1 더하기
            int cloned = cur;
            cloned++;
            if (!visited.containsKey(cloned)) {
                visited.put(cloned, visited.get(cur) + 1);
                pq.add(cloned);
                // System.out.println(cloned);
            }

            // 현재 수에 1 빼기
            int clonedSub = cur;
            clonedSub--;
            if (!visited.containsKey(clonedSub)) {
                visited.put(clonedSub, visited.get(cur) + 1);
                pq.add(clonedSub);
                // System.out.println(clonedSub);
            }
        }
    }
}
