package acmicpc10866;

import java.io.*;
import java.util.*;

/* 덱
 * https://www.acmicpc.net/problem/10866
 * deque를 그대로 구현.
 */

public class Main {
    static int num = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] cmd = { "push_front", "push_back", "pop_front", "pop_back", "size", "empty",
                "front", "back" };
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        Runnable[] tasks = new Runnable[] {
                () -> dq.addFirst(num),
                () -> dq.addLast(num),
                () -> sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n"),
                () -> sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n"),
                () -> sb.append(dq.size()).append("\n"),
                () -> sb.append(dq.isEmpty() ? 1 : 0).append("\n"),
                () -> sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n"),
                () -> sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n"),
        };

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String curCommand = st.nextToken();
            for (int j = 0; j < cmd.length; j++) {
                if (cmd[j].contentEquals(curCommand)) {
                    if (j < 2) {
                        num = Integer.parseInt(st.nextToken());
                    }
                    tasks[j].run();
                }
            }
        }

        System.out.println(sb);
    }
}
