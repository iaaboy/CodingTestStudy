package acmicpc2023;

import java.io.*;

/* 신기한 소수
 * https://www.acmicpc.net/problem/2023
 */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int maxN;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        maxN = (int) Math.pow(10, N);
        checkPrime(0, 0);
        System.out.print(sb);
    }

    private static void checkPrime(int num, int depth) {
        if (depth == N) {
            // System.out.println(num);
            sb.append(num).append("\n");
            return;
        }
        for (int i = 1; i <= 10; i++) {
            if (isPrime(num * 10 + i)) {
                checkPrime(num * 10 + i, depth + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
