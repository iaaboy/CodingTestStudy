package acmicpc9372;

import java.io.*;
import java.util.*;

/* 상근이의 여행
 * https://www.acmicpc.net/problem/9372
 */

public class Main {
    static int[] ids;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                bf.readLine();
            }
            sb.append(N - 1).append("\n");
        }
        System.out.print(sb);
    }
}