package acmicpc2508;

import java.util.*;
import java.io.*;

/* 사탕 박사 고창영
 * https://www.acmicpc.net/problem/2508
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        char[] candiC = { '>', 'o', '<' };
        char[] candiR = { 'v', 'o', '^' };
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            bf.readLine();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            char[][] arr = new char[R][C];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = bf.readLine().toCharArray();
            }

            // 가로
            
            int matchCount = 0;
            for (int i = 0; i < R; i++) {
                int idx = 0;
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] == candiC[idx]) {
                        idx++;
                        if (idx == 3) {
                            matchCount++;
                            arr[i][j-2] = arr[i][j-1] = arr[i][j] = '1';
                            idx = 0;
                        }
                    } else {
                        idx = 0;
                        if (arr[i][j] == candiC[idx]) {
                            idx++;
                        }
                    }
                }
            }
            //세로
            for (int j = 0; j < C; j++) {
                int idx = 0;
                for (int i = 0; i < R; i++) {

                    if (arr[i][j] == candiR[idx]) {
                        idx++;
                        if (idx == 3) {
                            matchCount++;
                            idx = 0;
                        }
                    } else {
                        idx = 0;
                        if (arr[i][j] == candiR[idx]) {
                            idx++;
                        }
                    }
                }
            }

            sb.append(matchCount +"\n");
        }
        System.out.print(sb);
    }
}


