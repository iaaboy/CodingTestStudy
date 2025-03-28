package acmicpc9184;

import java.io.*;
import java.util.*;

/* 신나는 함수 실행
 * https://www.acmicpc.net/problem/9184
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MCOUNT; i++) {
            for (int j = 0; j < MCOUNT; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            int result = w(a, b, c);
            sb.append("w(" + a + ", " + b + ", " + c + ") = " + result).append("\n");
        }
        System.out.print(sb);
    }

    static int MCOUNT = 101;
    static int[][][] memo = new int[MCOUNT][MCOUNT][MCOUNT];

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            memo[50 + a][50 + b][50 + c] = 1;
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (memo[50 + a][50 + b][50 + c] != -1) {
            return memo[50 + a][50 + b][50 + c];
        }

        int result;
        if (a < b && b < c) {
            result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            result = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        memo[50 + a][50 + b][50 + c] = result;
        return result;
    }

}
