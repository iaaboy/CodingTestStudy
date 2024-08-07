package acmicpc1388;

import java.io.*;
import java.util.*;

/* 바닥 장식
 * https://www.acmicpc.net/problem/1388
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        // 가로
        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean isContinue = false;
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '-') {
                    isContinue = true;
                } else {
                    if (isContinue) {
                        count++;
                        isContinue = false;
                    }
                }
            }
            if (isContinue) {
                count++;
            }
        }

        // 세로
        for (int i = 0; i < M; i++) {
            boolean isContinue = false;
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == '|') {
                    isContinue = true;
                } else {
                    if (isContinue) {
                        count++;
                        isContinue = false;
                    }
                }
            }
            if (isContinue) {
                count++;
            }
        }
        System.out.println(count);
    }
}
