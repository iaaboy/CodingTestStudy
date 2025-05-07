package acmicpc12760;

import java.io.*;
import java.util.*;

/* 최후의 승자는 누구?
 * https://www.acmicpc.net/problem/12760
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer[][] arr = new Integer[N][M];
        int[] winCount = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr[i], (a, b) -> b - a);
        }
        int maxWin = 0;
        for (int i = 0; i < M; i++) {// game
            int winScore = 0;
            for (int j = 0; j < N; j++) {// player
                if (arr[j][i] > winScore) {
                    winScore = arr[j][i];
                }
            }
            for (int j = 0; j < N; j++) {
                if (winScore == arr[j][i]) {
                    winCount[j]++;
                    maxWin = Math.max(maxWin, winCount[j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (winCount[i] == maxWin) {
                sb.append(i + 1).append(" ");
            }
        }
        System.out.println(sb);
    }
}