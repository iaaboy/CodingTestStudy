package acmicpc30445;

import java.io.*;

/* 행복 점수
 * https://www.acmicpc.net/problem/30445
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] instr = bf.readLine().toCharArray();
        double h = 0;
        double g = 0;
        for (char c : instr) {
            if (c == 'H' || c == 'A' || c == 'P' || c == 'Y') {
                h++;
            }
            if (c == 'S' || c == 'A' || c == 'D') {
                g++;
            }
        }
        double result = 0;
        if (h == 0 && g == 0) {
            result = 50;
        } else {
            result = 100 * h / (h + g);
        }

        System.out.printf("%.2f\n", result);

    }
}
