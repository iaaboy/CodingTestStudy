package acmicpc5524;

import java.io.*;

/* 입실 관리
 * https://www.acmicpc.net/problem/5524
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            sb.append(s.toLowerCase() + "\n");
        }
        System.out.println(sb);
    }
}
