package acmicpc27297;

import java.io.*;
import java.util.*;

/* 맨해튼에서의 모임
 * https://www.acmicpc.net/problem/27297
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] arr = new long[N][M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[j][i] = Long.parseLong(st.nextToken());
            }
        }
        long s = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long min = getMinManhatten(arr[i]);
            for (long ls : arr[i]) {
                s += Math.abs(min - ls);
            }
            sb.append(min).append(" ");
        }
        sb.insert(0, s + "\n");
        System.out.println(sb);
    }

    private static long getMinManhatten(long[] line) {
        Arrays.sort(line);
        long median = line[line.length / 2]; // 중앙값
        return median;
    }
}
