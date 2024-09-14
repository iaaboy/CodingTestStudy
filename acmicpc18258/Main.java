package acmicpc18258;

import java.io.*;
import java.util.*;

/* 큐 2
 * https://www.acmicpc.net/problem/18258
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Deque<Integer> q = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String cmd = st.nextToken();
            char c = cmd.charAt(0);
            if (c == 'p') {
                c = cmd.charAt(1);
                if (c == 'u') {// push
                    q.add(Integer.parseInt(st.nextToken()));
                } else { // pop
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.poll() + "\n");
                    }
                }
            } else if (c == 's') {// size
                sb.append(q.size() + "\n");
            } else if (c == 'e') {// empty
                sb.append(q.isEmpty() ? "1\n" : "0\n");
            } else if (c == 'f') {// front
                if (q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(q.getFirst() + "\n");
                }
            } else if (c == 'b') {// back
                if (q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(q.getLast() + "\n");
                }
            }
        }
        System.out.print(sb);
    }
}
