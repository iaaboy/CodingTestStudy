package acmicpc2563;

import java.io.*;
import java.util.*;

/* 색종이
 * https://www.acmicpc.net/problem/2563
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] canvas = new int[100][100];
        int area = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int j2 = y; j2 < y + 10; j2++) {
                    if (canvas[j2 - 1][j - 1] == 0) {
                        area++;
                        canvas[j2 - 1][j - 1] = 1;
                    }
                }
            }
        }
        System.out.println(area);
    }
}
