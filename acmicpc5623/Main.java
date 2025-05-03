package acmicpc5623;

import java.io.*;
import java.util.*;

/* 수열의 합
 * https://www.acmicpc.net/problem/5623
A0 + A1 = n1
A0 + A2 = n2
A1 + A2 = n3
=> (A0 + A1) + (A0 + A2) - (A1 + A2) = n1 + n2 - n3
2*A0 = n1 + n2 - n3
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int arr[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer[] = new int[N];
        if (N == 2) {
            answer = new int[] { arr[0][1] / 2, arr[1][0] / 2 };
        } else {
            for (int i = 0; i < N; i++) {
                int n1 = (i + 1) % N;
                int n2 = (i + 2) % N;
                answer[i] = (arr[i][n1] + arr[i][n2] - arr[n1][n2]) / 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
