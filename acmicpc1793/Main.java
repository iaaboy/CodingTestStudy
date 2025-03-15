package acmicpc1793;

import java.io.*;
import java.util.*;

/* 타일링
 * https://www.acmicpc.net/problem/1793
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = 250;
        char [][] dp = new char [N + 2][];
        dp[0] = "1".toCharArray();
        dp[1] = "1".toCharArray();
        dp[2] = "3".toCharArray();
        for (int i = 3; i <= N; i++) {
            // dp[i] = (dp[i - 1] + dp[i - 2] * 2);
            dp[i] = charPlus(dp[i-1], charPlus(dp[i-2], dp[i-2]));
        }
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int num = Integer.parseInt(s.next());
            System.out.println(new String(dp[num]));
        }
    }
    private static char[] charPlus(char[] a, char[] b) {
        int size = Math.max(a.length, b.length);
        char[] result = new char[Math.max(a.length, b.length) + 1];
        int carry = 0;
        for (int i = 0; i < size + 1; i++) {
            int sum = carry;
            if (i < a.length) {
                sum += a[a.length - 1 - i] - '0';
            }
            if (i < b.length) {
                sum += b[b.length - 1 - i] - '0';
            }
            carry = sum / 10;
            result[result.length - 1 - i] = (char) (sum % 10 + '0');
        }
        if (result[0] == '0') {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            return result;
        }
    }
}
