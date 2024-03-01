package acmicpc14728;

import java.io.*;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/14728

입력
3 310
50 40
100 70
200 150

출력
440
 */

public class MaMain {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] times = new int[n];
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            times[i] = k;
            scores[i] = s;
        }
        new MaMain().solution(times, scores, t);
    }

    public void solution(int[] times, int[] scores, int t) { // N 출력
        int[][] maxScores = new int[times.length + 1][t + 1];

        for (int y = 0; y < times.length; y++) {
            for (int x = 0; x < t; x++) {
                if (x - scores[y] <= 0) {
                    // 전에꺼 그대로
                } else {
                    // 전에꺼 + 다음꺼
                }
            }
        }

        System.out.println(maxScores[times.length][t]);
    }
}
