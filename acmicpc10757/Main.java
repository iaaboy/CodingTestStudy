package acmicpc10757;

import java.io.*;
import java.util.*;

/* 큰 수 A+B
 * https://www.acmicpc.net/problem/10757
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();

        char[] result = charPlus(a, b);
        System.out.println(result[0] == '0' ? new String(result, 1, result.length - 1) : new String(result));
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
        return result;
    }
}
