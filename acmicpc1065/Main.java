package acmicpc1065;

import java.io.*;

/* 한수
 * https://www.acmicpc.net/problem/1065
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int count = 0;
        if (N <= 99) {
            System.out.println(N);
        } else {
            for (int i = 100; i <= N; i++) {
                int a = i / 100;
                int b = (i % 100) / 10;
                int c = (i % 10);
                if (b - a == c - b) {
                    count++;
                }
            }
            System.out.println(count + 99);
        }
    }
}
