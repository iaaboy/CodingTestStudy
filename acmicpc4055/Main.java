package acmicpc4055;

import java.io.*;
import java.util.*;

/* 파티가 좋아 파티가 좋아
 * https://www.acmicpc.net/problem/4055
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (true) {
            int N = Integer.parseInt(bf.readLine());
            if (N == 0)
                break;
            Party[] p = new Party[N];
            boolean[] visited = new boolean[48 + 1];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int s = Integer.parseInt(st.nextToken()) * 2 - 1;
                int e = (Integer.parseInt(st.nextToken()) - 1) * 2;
                p[i] = new Party(s, e);
            }
            Arrays.sort(p, (a, b) -> {
                if (a.e == b.e) {
                    return a.s - b.s;
                }
                return a.e - b.e;
            });
            for (int i = 0; i < p.length; i++) {
                // System.out.println("handle: " + p[i]);
                int s = p[i].s;
                int e = p[i].e;
                for (; s <= e; s++) {
                    if (!visited[s]) {
                        visited[s] = true;
                        p[i].attend = i;
                        break;
                    }
                }
            }
            int attendCount = 0;
            for (int i = 0; i < p.length; i++) {
                if (p[i].attend != -1) {
                    attendCount++;
                }
            }
            sb.append("On day " + t + " Emma can attend as many as " + attendCount)
            .append(" parties.\n");
            t++;
        }
        System.out.print(sb);
    }

    static class Party {
        int s;
        int e;
        int attend = -1;

        public Party(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return s + "-" + e + "/" + attend;
        }
    }
}