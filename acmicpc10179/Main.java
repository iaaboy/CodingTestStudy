package acmicpc10179;

import java.io.*;

/* 쿠폰
 * https://www.acmicpc.net/problem/10179
 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Double num = Double.parseDouble(bf.readLine());
            sb.append(String.format("$%.2f\n", num*0.8));
            // System.err.println(result3);
        }
        System.out.print(sb.toString());
    }
}