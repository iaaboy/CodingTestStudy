package acmicpc8979;

import java.io.*;
import java.util.*;

/* 올림픽
 * https://www.acmicpc.net/problem/8979
메달 기준 reverse order로 정렬 후 
K 의 순위를 찾기, 동일 메달수 일때 처리 필요.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Medal[] c = new Medal[N + 1];
        c[0] = new Medal(0, Integer.MAX_VALUE, 0, 0);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            c[i] = new Medal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(c);
        int k = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i].idx == K) {
                k = i;
                break;
            }
        }
        for (; k >= 1; k--) {
            if (c[k].g != c[k - 1].g || c[k].s != c[k - 1].s || c[k].b != c[k - 1].b) {
                break;
            }
        }
        System.out.println(k);
        // System.out.println(Arrays.toString(c));

    }

    static class Medal implements Comparable<Medal> {
        int g, s, b;
        int idx;

        public Medal(int idx, int g, int s, int b) {
            this.g = g;
            this.s = s;
            this.b = b;
            this.idx = idx;
        }

        @Override
        public int compareTo(Medal o) {
            if (g == o.g) {
                if (s == o.s) {
                    return o.b - b;
                } else {
                    return o.s - s;
                }
            } else {
                return o.g - g;
            }
        }

        @Override
        public String toString() {
            return idx + ":" + g + "," + s + "," + b;
        }
    }
}
