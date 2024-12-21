package acmicpc2153;

import java.io.*;

/* 소수 단어
 * https://www.acmicpc.net/problem/2153
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] inStr = bf.readLine().toCharArray();
        int num = 0;
        for (int i = 0; i < inStr.length; i++)
            num += (inStr[i] >= 'a' && inStr[i] <= 'z') ? inStr[i] - 'a' + 1 : inStr[i] - 'A' + 27;
        System.out.println(isPrime(num) ? "It is a prime word." : "It is not a prime word.");
    }

    static boolean isPrime(int num) {
        if (num == 1) {
            return true;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
