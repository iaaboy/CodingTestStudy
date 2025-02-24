package acmicpc9527;

import java.io.*;
import java.util.*;

/* 1의 개수 세기
 * https://www.acmicpc.net/problem/9527
 */

/*
1. 2의 i승 1개수를 사전에 구한다.
2. 누적합 개념을 이용하여, 0~N까지 1의 합을 구한다.
    ShiftRight하면서 구한다.
    // 해당 비트 이전 까지의 1의 개수(dp[i-1])를 추가
    // 해당 비트가 1인 경우, 그 비트 이후의 숫자도 포함하므로 (x - (1L << i) + 1) 만큼 추가

3. N2 - (N1 - 1) , 구간의 1 개수를 구한다.

 */

class Main {
    static long A, B;
    static long[] dp = new long[57];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dp[0] = 1; //dp[i] == 2의 i승 1개수  1,2,5,13,33,81,192....
        for (int i = 1; i < 56; ++i) {
            dp[i] = 2 * dp[i - 1] + (1L << i);
        }

        System.out.println(countOne(B) - countOne(A - 1));
    }

    // x 이하의 숫자에서 1이 등장하는 개수를 구하는 함수
    static long countOne(long x) {
        long result = 0; // 1의 개수를 저장할 변수
        // System.out.println("count : " + Long.toBinaryString(x));
        // 2^54부터 시작하여 큰 비트부터 확인
        for (int i = 54; i > 0; i--) {
            if ((x & (1L << i)) != 0) { // x의 i번째 비트가 1이면

                // 해당 비트 이전까지의 1의 개수(dp[i-1])를 추가
                result += dp[i - 1];

                // 해당 비트가 1인 경우, 그 비트 이후의 숫자도 포함하므로 (x - (1L << i) + 1) 만큼 추가
                result += x - (1L << i) + 1;

                // 현재 비트를 0으로 만들고 반복을 계속함
                x -= 1L << i;

                // System.out.println(Long.toBinaryString(x));
            }
        }

        // 마지막 남은 1의 개수를 추가 (x의 최하위 비트가 1인지 확인)
        result += x & 1;

        return result;
    }

}