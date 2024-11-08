package acmcicp26162;

import java.io.*;
import java.util.*;

/* 인공 원소
 * https://www.acmicpc.net/problem/26162
 */

public class Main {
    static boolean[] isPrime = new boolean[119];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= 118; i++) {
            if (isPrime[i]) {
                for (int j = 2; j * i <= 118; j++) {
                    isPrime[j * i] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (checkPrimeSum(num)) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean checkPrimeSum(int num) {
        for (int i = 2; i < num; i++) {
            int n1 = i;
            int n2 = num - i;
            if (isPrime[n1] && isPrime[n2]) {
                return true;
            }
        }
        return false;
    }
}
