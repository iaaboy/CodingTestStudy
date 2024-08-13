package acmicpc2075;

import java.io.*;
import java.util.*;

/* N번째 큰 수
 * https://www.acmicpc.net/problem/2075
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

        int[] idx = new int[N];
        Arrays.fill(idx, N - 1);
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            maxIdx = 0;
            for (int j = 1; j < N; j++) {
                if (idx[maxIdx] >= 0 && arr[idx[maxIdx]][maxIdx] < arr[idx[j]][j]) {
                    maxIdx = j;
                }
            }
            // System.out.println(arr[idx[maxIdx]][maxIdx]);
            idx[maxIdx]--;
        }
        System.out.println(arr[idx[maxIdx] + 1][maxIdx]);
    }
}
