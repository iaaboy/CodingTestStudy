package acmicpc31408;

import java.io.*;
import java.util.*;

/* 당직 근무표
 * https://www.acmicpc.net/problem/31408
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] num = new int[100000 + 1];
        for (int i = 0; i < N; i++) {
            num[Integer.parseInt(st.nextToken())]++;
        }
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            max = Math.max(max, num[i]);
        }
        // 짝수면
        if (N %2 == 0) {
            if (max >= N / 2 + 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        } else {
            if (max > N / 2 + 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
