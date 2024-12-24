package acmicpc2609;

import java.io.*;
import java.util.*;

/* 최대공약수와 최소공배수
 * https://www.acmicpc.net/problem/2609
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(gcd(a, b)).append("\n").append((a * b) / gcd(a, b)).append("\n");
        System.out.print(sb);
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
