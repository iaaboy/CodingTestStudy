package acmicpc10826;

import java.io.*;

/* 피보나치 수 4
 * https://www.acmicpc.net/problem/10826
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        char[][] pivo = new char[n + 2][];
        pivo[0] = new char[] { '0' };
        pivo[1] = new char[] { '1' };
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                pivo[i] = charPlus(pivo[i - 1], pivo[i - 2]);
            }
        }

        String result = new String(pivo[n]);
        while (result.length() > 1 && result.charAt(0) == '0') {
            result = result.substring(1);
        }
        System.out.println(result);
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
            return new String(result, 1, result.length - 1).toCharArray();
        }
        return result;
    }
}