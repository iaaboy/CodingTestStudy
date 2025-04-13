package acmicpc11401;

import java.io.*;
import java.util.*;
/* 이항 계수 3
 * https://www.acmicpc.net/problem/11401

 중요 !    (a / b) % MOD != (a % MOD) / (b % MOD) 
 확장 유클리드 알고리즘으로 b % MOD 의 역원을 찾아서 
 나머지 값을 구함.
 !!! 나중에 다시 찾아볼것.
 */


public class Main {
    static long[] factorial;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        long a = factorial[n];
        long b = (factorial[k] * factorial[n - k]) % MOD;

        // 확장 유클리드 알고리즘으로 b의 역원 구하기
        GcdResult res = extendedGCD(b, MOD);
        long inverseB = res.x;
        if (inverseB < 0)
            inverseB += MOD;

        long ans = (a * inverseB) % MOD;
        System.out.println(ans);
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