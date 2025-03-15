package acmicpc17845;

import java.io.*;
import java.util.StringTokenizer;

/* 수강 과목
 * https://www.acmicpc.net/problem/17845
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int vv = Integer.parseInt(st.nextToken());
            int ww = Integer.parseInt(st.nextToken());
            w[i] = ww;
            v[i] = vv;
        }
        new Main().solution(w, v, k);
    }

    public void solution(int[] w, int[] v, int k) { // N 출력
        int[][] maxv = new int[w.length + 1][k + 1];

        for (int y = 1; y <= w.length; y++) {
            for (int x = 0; x <= k; x++) {
                if (x - w[y - 1] < 0) {
                    // 전에꺼 그대로
                    maxv[y][x] = maxv[y - 1][x];
                } else {
                    // 전에꺼 + 다음꺼
                    maxv[y][x] = Math.max(maxv[y - 1][x], maxv[y - 1][x - w[y - 1]] + v[y - 1]);
                }
            }
        }
        System.out.println(maxv[w.length][k]);
    }
}