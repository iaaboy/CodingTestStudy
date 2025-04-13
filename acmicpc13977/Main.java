package acmicpc13977;

import java.io.*;
import java.util.*;

/* 이항 계수와 쿼리
 * https://www.acmicpc.net/problem/13977
11401 문제와 풀이가 동일, 여러 쿼리에 맞춰 print하도록 변경만 하면 됨.
 */

public class Main {
    static long[] factorial;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        factorial = new long[4000001];
        factorial[0] = 1;
        for (int i = 1; i <= 4000000; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long a = factorial[n];
            long b = (factorial[k] * factorial[n - k]) % MOD;

            // 확장 유클리드 알고리즘으로 b의 역원 구하기
            GcdResult res = extendedGCD(b, MOD);
            long inverseB = res.x;
            if (inverseB < 0)
                inverseB += MOD;

            long ans = (a * inverseB) % MOD;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        bf.close();
    }

    static class GcdResult {
        long gcd, x, y;

        GcdResult(long gcd, long x, long y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }

    // 확장 유클리드 알고리즘
    static GcdResult extendedGCD(long a, long b) {
        if (b == 0) {
            return new GcdResult(a, 1, 0); // gcd(a, 0) = a, x=1, y=0
        }

        GcdResult res = extendedGCD(b, a % b);
        long x1 = res.y;
        long y1 = res.x - (a / b) * res.y;

        return new GcdResult(res.gcd, x1, y1);
    }
}