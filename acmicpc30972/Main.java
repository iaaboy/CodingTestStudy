package acmicpc30972;

import java.io.*;
import java.util.*;

/* 닭강정의 전설
 * https://www.acmicpc.net/problem/30972
 */

public class Main {
    static int arr[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += Integer.parseInt(st.nextToken());
                if (i == 0) {
                    arr[i][j] = sum;
                } else {
                    arr[i][j] = arr[i - 1][j] + sum;
                }
            }
        }

        int Q = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            int sum1 = getSum(r1, c1, r2, c2);
            int sum2 = getSum(r1 + 1, c1 + 1, r2 - 1, c2 - 1);
            // sb.append(sum1 + "," + sum2 + "\n");
            sb.append(2 * sum2 - sum1).append("\n");
        }
        System.out.print(sb);

        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(arr[i]));
        // }

    }

    private static int getSum(int r1, int c1, int r2, int c2) {
        int sum = arr[r2][c2];
        if (c1 > 0) {
            sum -= arr[r2][c1 - 1];
        }
        if (r1 > 0) {
            sum -= arr[r1 - 1][c2];
        }
        if (r1 > 0 && c1 > 0) {
            sum += arr[r1 - 1][c1 - 1];
        }
        return sum;
    }
}
