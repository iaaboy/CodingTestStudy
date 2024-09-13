package acmicpc31423;

import java.io.*;
import java.util.*;
/* 신촌 통폐합 계획
 * https://www.acmicpc.net/problem/31423 
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] names = new String[N];
        int[] next = new int[N + 1];
        int[] tail = new int[N + 1];
        for (int i = 0; i < N; i++) {
            names[i] = bf.readLine();
            next[i + 1] = i + 1;
            tail[i + 1] = i + 1;
        }
        int startIdx = 0;
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            next[tail[from]] = to;
            tail[from] = tail[to];
            startIdx = from;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(names[startIdx - 1]);
            startIdx = next[startIdx];
        }
        System.out.println(sb);
    }
}