package acmicpc2273;

import java.io.*;
import java.util.*;

/* 줄 서기
 * https://www.acmicpc.net/problem/2273
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean [][] mapBack = new boolean[N][N];
        boolean [][] mapFront = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            mapBack[s][e] = true;
            mapFront[e][s] = true;
        }

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    mapBack[s][e] |= (mapBack[s][m] && mapBack[m][e]);
                    mapFront[s][e] |= (mapFront[s][m] && mapFront[m][e]);
                }
            }
        }
        int [] countBack = new int[N];
        int [] countFront = new int[N];
        for (int i = 0; i < countFront.length; i++) {
            int countB = 0;
            int countF = 0;
            if (mapBack[i][i] || mapFront[i][i]) {
                System.out.println(-1);
                return;
            }
            for (int j = 0; j < countFront.length; j++) {
                if (mapBack[i][j]) {
                    countB++;
                }
                if (mapFront[i][j]) {
                    countF++;
                }
            }
            countBack[i] = countB;
            countFront[i] = countF;
        }
        // System.out.println(Arrays.toString(countBack));
        // System.out.println(Arrays.toString(countFront));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int start = 1 + countFront[i];
            int end = N - countBack[i];
            sb.append(start).append(" ").append(end).append("\n");
        }
        System.out.print(sb);
    }
}
