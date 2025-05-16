package acmicpc9019;

import java.io.*;
import java.util.*;

/* DSLR
 * https://www.acmicpc.net/problem/9019
 *  BFS.
 */

public class Main {
    static boolean[] visit;
    static Stack<Character> history;
    static int from, to;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            visit = new boolean[10000];
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            history = new Stack<>();
            visit[from] = true;
            traverse();
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static StringBuilder sb = new StringBuilder();

    private static void traverse() {
        ArrayDeque<State> q = new ArrayDeque<>();
        visit[from] = true;
        q.add(new State(from, new StringBuilder()));
        while (!q.isEmpty()) {
            State c = q.poll();
            int next = 0;
            // D
            next = (c.current * 2);
            next %= 10000;
            if (next == to) {
                sb.append(c.word).append('D');
                return;
            }
            if (!visit[next]) {
                visit[next] = true;
                q.add(new State(next, new StringBuilder(c.word).append('D')));
            }
            // S
            next = (c.current - 1) < 0 ? 9999 : c.current - 1;
            next %= 10000;
            if (next == to) {
                sb.append(c.word).append('S');
                return;
            }
            if (!visit[next]) {
                visit[next] = true;
                q.add(new State(next, new StringBuilder(c.word).append('S')));
            }
            // L .. shift
            next = c.current / 1000 + (c.current * 10) % 10000;
            if (next == to) {
                sb.append(c.word).append('L');
                return;
            }
            if (!visit[next]) {
                visit[next] = true;
                q.add(new State(next, new StringBuilder(c.word).append('L')));
            }
            // R .. shift
            next = 1000 * (c.current % 10) + (c.current / 10) % 10000;
            if (next == to) {
                sb.append(c.word).append('R');
                return;
            }
            if (!visit[next]) {
                visit[next] = true;
                q.add(new State(next, new StringBuilder(c.word).append('R')));
            }
        }
    }

    static class State {
        int current;
        StringBuilder word;

        public State(int current, StringBuilder w) {
            this.current = current;
            this.word = w;
        }
    }
}