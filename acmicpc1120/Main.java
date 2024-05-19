package acmicpc1120;

import java.io.*;
import java.util.*;

/* 문자열
 * https://www.acmicpc.net/problem/1120
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();
        int sizeDiff = b.length - a.length;
        int maxMatch = 0;

        for (int offset = 0; offset <= sizeDiff; offset++) {
            maxMatch = Math.max(maxMatch, countMatch(a, b, offset));
        }
        System.out.println(a.length - maxMatch);
    }

    private static int countMatch(char[] a, char[] b, int offset) {
        int result = 0;
        for (int i = offset; i < a.length + offset; i++) {
            if (a[i - offset] == b[i]) {
                result++;
            }
        }
        return result;
    }
}
