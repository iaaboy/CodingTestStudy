package acmicpc2436;

import java.io.*;
import java.util.*;

/* 공약수
 * https://www.acmicpc.net/problem/2436
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long i = a;
        // if (a > b) {
        // a = b;
        // b = i;
        // i = a;
        // }

        ArrayList<Long> aCandi = new ArrayList<>();
        for (; i <= b; i += a) {
            if (b % i == 0) {
                aCandi.add(i);
            }
        }

        long maxSum = Long.MAX_VALUE;
        long aa = 0;
        long bb = 0;
        for (int j = 0; j < aCandi.size(); j++) {
            for (int j2 = j; j2 < aCandi.size(); j2++) {
                long l = aCandi.get(j);
                long r = aCandi.get(j2);
                if (isFit(l, r, b)) {
                    // System.out.prlongln(aCandi.get(j) + " , " + aCandi.get(j2));
                    if (maxSum > l + r) {
                        aa = l;
                        bb = r;
                        maxSum = l + r;
                    }
                }
            }
        }
        System.out.println(aa + " " + bb);
    }

    private static boolean isFit(long n1, long n2, long b) {
        long gcd = lcm(n1, n2);
        return gcd == b;
    }

    private static long lcm(long a, long b) {
        long gcd = ucledianGcd(a, b);
        return a * b / gcd;
    }

    private static long ucledianGcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
