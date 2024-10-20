package acmicpc27973;

import java.io.*;
import java.util.*;

/* 지연 평가
 * https://www.acmicpc.net/problem/27973
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long sumTotal = 0;
        long mulTotal = 1;
        long idx = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 3) {
                sb.append(idx * mulTotal + sumTotal).append("\n");
            } else {
                int X = Integer.parseInt(st.nextToken());
                if (cmd == 2) {
                    idx += X;
                } else if (cmd == 1) {
                    mulTotal *= X;
                    sumTotal *= X;
                } else if (cmd == 0) {
                    sumTotal += X;
                }
            }
            // System.out.print("midResult: " + sb);
        }
        System.out.print(sb);
    }
}
