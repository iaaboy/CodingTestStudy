package acmicpc2096;

import java.io.*;
import java.util.StringTokenizer;

/* 내려가기
 * https://www.acmicpc.net/problem/2096
 */

/*
3
1 2 3
4 5 6
4 9 0
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][][] memo = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            memo[i][1][0] = memo[i][0][0] = Integer.parseInt(st.nextToken());
            memo[i][1][1] = memo[i][0][1] = Integer.parseInt(st.nextToken());
            memo[i][1][2] = memo[i][0][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < memo.length; i++) {
            memo[i][0][0] += Math.max(memo[i - 1][0][0], memo[i - 1][0][1]);
            memo[i][0][1] += Math.max(memo[i - 1][0][0], Math.max(memo[i - 1][0][1], memo[i - 1][0][2]));
            memo[i][0][2] += Math.max(memo[i - 1][0][1], memo[i - 1][0][2]);

            memo[i][1][0] += Math.min(memo[i - 1][1][0], memo[i - 1][1][1]);
            memo[i][1][1] += Math.min(memo[i - 1][1][0], Math.min(memo[i - 1][1][1], memo[i - 1][1][2]));
            memo[i][1][2] += Math.min(memo[i - 1][1][1], memo[i - 1][1][2]);
        }
        System.out.println(
                Math.max(memo[memo.length - 1][0][0],
                        Math.max(memo[memo.length - 1][0][1], memo[memo.length - 1][0][2]))
                        + " " +
                        Math.min(memo[memo.length - 1][1][0],
                                Math.min(memo[memo.length - 1][1][1], memo[memo.length - 1][1][2])));
    }
}
