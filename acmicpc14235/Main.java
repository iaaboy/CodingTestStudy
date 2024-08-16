package acmicpc14235;

import java.io.*;
import java.util.*;

/* 크리스마스 선물
 * https://www.acmicpc.net/problem/14235
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuffer sb = new StringBuffer();
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 0) {
                sb.append((pQ.isEmpty() ? "-1" : pQ.poll()) + "\n");
            } else {
                for (int j = 0; j < cmd; j++) {
                    pQ.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.print(sb);
    }
}
