package acmicpc11689;

import java.io.*;
import java.util.*;

/* GCD(n, k) = 1
 * https://www.acmicpc.net/problem/11689
 * 오일러피 함수
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bf.readLine());
        long oilerN = N;
        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                oilerN -= oilerN / i;
            }
            while (N % i == 0) {
                N /= i;
            }
        }
        if (N > 1) {
            oilerN -= oilerN / N;
        }

        System.out.println(oilerN);
    }
}
