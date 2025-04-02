package acmicpc1748;

import java.io.*;

/* 수 이어 쓰기 1
 * https://www.acmicpc.net/problem/1748
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int digit = getDigit(N);
        int count = getCount(digit - 1);
        // System.out.println(digit + ":" + count);
        // System.out.println(Math.pow(10, digit - 1) + " ~ " + N);
        count += (N - Math.pow(10, digit - 1) + 1) * digit;
        System.out.println(count);
    }

    static int [] dCount = {0, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999};
    private static int getCount(int digit) {
        int sum = 0;
        for (int i = 1; i <= digit; i++) {
            sum += i * (dCount[i] - dCount[i-1]);
        }
        return sum;
    }

    private static int getDigit(int n) {
        if (n == 0) {
            return 0;
        }
        int digit = 0;
        while (n > 0) {
            n /= 10;
            digit++;
        }
        return digit;
    }

}
