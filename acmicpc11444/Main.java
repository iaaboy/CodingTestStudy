package acmicpc11444;

import java.io.*;
import java.util.*;

/* 피보나치 수 6
 * https://www.acmicpc.net/problem/11444
 */

public class Main {
    private static final int MOD = 1000000007;
    private static HashMap<Long, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        memo.put(0L, 0);
        memo.put(1L, 1);
        memo.put(2L, 1);

        System.out.println(fibonacci(N));
    }

    public static int fibonacci(long n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result;
        if (n % 2 == 0) {
            long fibN2 = fibonacci(n / 2);
            long fibN1 = fibonacci(n / 2 - 1);
            result = (int) ((fibN2 * fibN2 + 2L * fibN2 * fibN1) % MOD);
        } else {
            result = (int) ((2L * fibonacci(n - 1) - fibonacci(n - 3) + MOD) % MOD);
        }

        memo.put(n, result);
        return result;
    }
}
