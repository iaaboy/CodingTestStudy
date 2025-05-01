package acmicpc3652;

import java.io.*;

/* 새트리
 * https://www.acmicpc.net/problem/3652
 */

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split("/");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        func(a, b);
        System.out.println(sb);
    }

    public static void func(int a, int b) {
        if (a == 1 && b == 1) {
            return;
        }
        if (a < b) {
            sb.append("L");
            func(b - a, a);
        } else {
            sb.append("R");
            func(b, a - b);
        }
    }
}
