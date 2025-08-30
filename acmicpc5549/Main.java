package acmicpc5549;

import java.io.*;
import java.util.*;

/* 행성 탐사
 * https://www.acmicpc.net/problem/5549
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(bf.readLine());
        int arrJ[][] = new int[N + 1][M + 1];
        int arrI[][] = new int[N + 1][M + 1];
        int arrO[][] = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            int jSum = 0;
            int iSum = 0;
            int oSum = 0;
            char [] line = bf.readLine().toCharArray();
            for (int j = 1; j < M + 1; j++) {
                char c = line[j - 1];
                jSum += c == 'J'? 1 : 0;
                iSum += c == 'I'? 1 : 0;
                oSum += c == 'O'? 1 : 0;
                arrJ[i][j] = jSum + arrJ[i - 1][j];
                arrI[i][j] = iSum + arrI[i - 1][j];
                arrO[i][j] = oSum + arrO[i - 1][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < N + 1; i++) {
        //     sb.append(Arrays.toString(arrJ[i])).append(" // ");
        //     sb.append(Arrays.toString(arrI[i])).append(" // ");
        //     sb.append(Arrays.toString(arrO[i])).append(" // ");
        //     sb.append("\n");
        // }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int sumI = arrJ[y2][x2] - arrJ[y2][x1] - arrJ[y1][x2] + arrJ[y1][x1];
            int sumJ = arrI[y2][x2] - arrI[y2][x1] - arrI[y1][x2] + arrI[y1][x1];
            int sumO = arrO[y2][x2] - arrO[y2][x1] - arrO[y1][x2] + arrO[y1][x1];
            sb.append(sumI + " " + sumO + " " + sumJ).append("\n");
        }
        System.out.print(sb);
    }
}