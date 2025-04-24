package acmicpc1402;

import java.io.*;

/* 아무래도이문제는A번난이도인것같다
 * https://www.acmicpc.net/problem/1402
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            bf.readLine();
            sb.append("yes\n");
        }
        System.out.print(sb);
    }
}
