package acmicpc3054;

import java.io.*;
import java.util.*;

/* 피터팬 프레임
 * https://www.acmicpc.net/problem/3054
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] inStr = bf.readLine().toCharArray();
        int n = inStr.length;
        n = 5 * n - (n - 1);
        char[][] output = new char[5][n];
        for (int i = 0; i < output.length; i++) {
            Arrays.fill(output[i], '.');
        }
        int[] dx = { 0, 1, 2, 1, 0, -1, -2, -1 };
        int[] dy = { 2, 1, 0, -1, -2, -1, 0, 1 };
        for (int i = 0; i < inStr.length; i++) {
            char ch = '#';
            if (i % 3 == 2) {
                ch = '*';
            }
            int baseX = 2 + i * 4;
            int baseY = 2;
            output[baseY][baseX] = inStr[i];
            for (int j = 0; j < 8; j++) {
                int nx = baseX + dx[j];
                int ny = baseY + dy[j];
                if (output[ny][nx] != '*') {
                    output[ny][nx] = ch;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(output[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
