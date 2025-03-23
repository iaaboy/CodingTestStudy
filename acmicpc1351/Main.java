package acmicpc1351;

import java.io.*;
import java.util.*;

/* 무한 수열
 * https://www.acmicpc.net/problem/1351
N = 7 , P = 2, Q = 3 일 때,
A7 = A(7/2) + A(7/3)
   = A(3) + A(2)
   = A(3/2) + A(3/3) + A(2/2) + A(2/3)
   = A(1) + A(1) + A(1) + A(0) .  //A(1) = A(1/3) + A(1/2) = A(0) + A(0)
   = A(0) * 7
   = 7
   재귀를 이용해 A(N)을 얻는다.
   dp적용하여 memo(hashmap)에 N일 때 값을 저자하고, 중복 계산을 피함.
 */

public class Main {
    static long P, Q;
    static HashMap<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        memo.put(0L, 1L);
        long result = getInfinite(N);
        System.out.println(result);
    }

    private static long getInfinite(long n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        long sum = getInfinite(n / P) + getInfinite(n / Q);
        memo.put(n, sum);
        return sum;
    }
}
