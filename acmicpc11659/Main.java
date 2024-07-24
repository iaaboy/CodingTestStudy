package acmicpc11659;

import java.io.*;
import java.util.*;

/* 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] acc = new long[N];
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        acc[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            long result = from == 0 ? 0 : -acc[from - 1];
            result -= -acc[to];
            sb.append(result + "\n");
        }
        System.out.print(sb);
    }
}