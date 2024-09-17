package acmicpc28279;

import java.io.*;
import java.util.*;

/* 덱 2
 * https://www.acmicpc.net/problem/28279
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int num = Integer.parseInt(st.nextToken());
                dq.addFirst(num);
            } else if (cmd == 2) {
                int num = Integer.parseInt(st.nextToken());
                dq.addLast(num);
            } else if (cmd == 3) {
                sb.append((dq.size() == 0 ? -1 : dq.pollFirst()) + "\n");
            } else if (cmd == 4) {
                sb.append((dq.size() == 0 ? -1 : dq.pollLast()) + "\n");
            } else if (cmd == 5) {
                sb.append(dq.size() + "\n");
            } else if (cmd == 6) {
                sb.append(dq.isEmpty() ? "1\n" : "0\n");
            } else if (cmd == 7) {
                sb.append((dq.size() == 0 ? -1 : dq.peekFirst()) + "\n");
            } else if (cmd == 8) {
                sb.append((dq.size() == 0 ? -1 : dq.peekLast()) + "\n");
            }
        }
        System.out.print(sb);
    }
}
