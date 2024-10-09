package acmicpc11403;

import java.io.*;
import java.util.*;

/* 경로 찾기
 * https://www.acmicpc.net/problem/11403
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int mid = 0; mid < N; mid++) {
            for (int st = 0; st < N; st++) {
                for (int ed = 0; ed < N; ed++) {
                    if (arr[st][mid] == 1 && arr[mid][ed] == 1) {
                        arr[st][ed] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
