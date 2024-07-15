package acmicpc22116;

import java.io.*;
import java.util.*;

/*
 * TODO
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

        //binary search
        //임계값을 정한다.

        //최소 경로
        //입력 받은 임계값으로 최소 경로 탐색(가능 여부 판단)

    }
}
