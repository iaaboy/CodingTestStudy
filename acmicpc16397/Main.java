package acmicpc16397;

import java.io.*;
import java.util.*;

/* 탈출
 * https://www.acmicpc.net/problem/16397
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 시작
        int T = Integer.parseInt(st.nextToken()); // 최대 회수
        int G = Integer.parseInt(st.nextToken()); // goal

        boolean[] isHandlled = new boolean[100000];
        Queue<BState> q = new ArrayDeque<>();
        isHandlled[N] = true;
        q.add(new BState(N, 0));
        while (!q.isEmpty()) {
            BState c = q.poll();
            if (c.n == G) {
                System.out.println(c.t);
                return;
            }
            if (c.t >= T) {
                continue;
            }
            // 1
            int next = c.n + 1;
            if (next < 100000 && !isHandlled[next]) {
                isHandlled[next] = true;
                q.add(new BState(next, c.t + 1));
            }
            // 2
            next = getNum(c.n);
            if (next != -1 && !isHandlled[next]) {
                isHandlled[next] = true;
                q.add(new BState(next, c.t + 1));
            }
        }
        System.out.println("ANG");
    }

    private static int getNum(int n) {
        int next = 2 * n;
        if (next > 99999) {
            return -1;
        } else if (next > 9999) {
            return next - 10000;
        } else if (next > 999) {
            return next - 1000;
        } else if (next > 99) {
            return next - 100;
        } else if (next > 9) {
            return next - 10;
        } else {
            return next - 1;
        }
    }

    static class BState {
        int n;
        int t;

        public BState(int n, int t) {
            this.n = n;
            this.t = t;
        }
    }
}
