package acmicpc10986;

import java.io.*;
import java.util.*;

/* 나머지 합
 * https://www.acmicpc.net/problem/10986
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] remains = new int[N];
        remains[0] = Integer.parseInt(st.nextToken()) % M;
        long[] restCount = new long[M];
        restCount[remains[0]]++;
        for (int i = 1; i < N; i++) {
            remains[i] = (remains[i - 1] + Integer.parseInt(st.nextToken())) % M;
            restCount[remains[i]]++;
        }

        long totalCount = 0;
        totalCount = restCount[0];

        for (int i = 0; i < M; i++) {
            if (restCount[i] > 1) { // 나머지 값이 같은 것 중 2개를 뽑는 모든 경우의 수
                totalCount = totalCount + restCount[i] * (restCount[i] - 1) / 2;
            }
        }
        System.out.println(totalCount);
    }
}