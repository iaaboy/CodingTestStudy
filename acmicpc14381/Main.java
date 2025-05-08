package acmicpc14381;

import java.io.*;

/* 숫자세는 양 (Small)
 * https://www.acmicpc.net/problem/14381
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(bf.readLine());
            boolean[] hasNum = new boolean[10];
            int count = 0;
            int j = 1;
            loop: for (; j <= 1000000; j++) {
                int nextNum = num * j;
                for (char c : Integer.toString(nextNum).toCharArray()) {
                    // System.out.print(c);
                    if (!hasNum[c - '0']) {
                        count++;
                        hasNum[c - '0'] = true;
                    }
                    if (count == 10) {
                        break loop;
                    }
                }
                if (j > 1 && num == nextNum) {
                    j = 0;
                    break loop;
                }
                // System.out.print(" ");
            }
            sb.append("Case #").append(i).append(": ");
            if (j == 0) {
                sb.append("INSOMNIA");
            } else {
                sb.append(num * j);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
