package acmicpc1735;

import java.io.*;
import java.util.*;

/* 분수 합
 * https://www.acmicpc.net/problem/1735
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int s = a * d + b * c;
        int p = b * d;

        int gcd = ucledianGcd(s, p);
        while (gcd > 1) {
            s /= gcd;
            p /= gcd;
            gcd = ucledianGcd(s, p);
        }
        System.out.println(s + " " + p);
    }

    private static int ucledianGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
