package acmicpc1629;

import java.io.*;
import java.util.*;

/* 곱셈
 * https://www.acmicpc.net/problem/1629
 */

public class Main {
    static HashMap<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        long result = getResult(A, B, C);
        System.out.println(result % C);

    }

    private static long getResult(long a, long count, long c) {
        long result;
        if (memo.containsKey(count)) {
            // System.out.println("Hit" + count);
            return memo.get(count);
        } else {
            // System.out.println("Calc" + count);
        }
        if (count == 1) {
            result = a % c;
        } else {
            long x = getResult(a, count / 2, c);
            if (count % 2 == 0) {
                result = x * x % c;
            } else {
                result = ((x * x % c) * a) % c;
            }
        }
        memo.put(count, result);
        return result;
    }
}