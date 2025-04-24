package acmicpc25288;

import java.io.*;

/* 영어 시험
 * https://www.acmicpc.net/problem/25288
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String s = bf.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}
