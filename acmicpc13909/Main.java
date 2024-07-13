package acmicpc13909;

import java.io.*;

/* 창문 닫기
 * https://www.acmicpc.net/problem/13909
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int result = 0;
        for (int i = 1; i * i <= N; i++) {
            result++;
        }
        System.out.println(result);
    }
}
