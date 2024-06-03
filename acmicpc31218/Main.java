package acmicpc31218;

import java.io.*;
import java.util.*;

/* 자료 구조의 왕
 * https://www.acmicpc.net/problem/31218
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int count = n * m;
        int[][] map = new int[n + 1][m + 1];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(bf.readLine());
            int query = Integer.parseInt(st.nextToken());
            if (query == 3) {
                sb.append(count + "\n");
            } else if (query == 1) {
                int dy = Integer.parseInt(st.nextToken());
                int dx = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                while (map[y][x] == 0) {
                    map[y][x] = 1;
                    count--;
                    y += dy;
                    x += dx;
                    if (x < 1 || y < 1 || y > n || x > m)
                        break;
                }
            } else if (query == 2) {
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                sb.append(map[y][x] + "\n");
            }
        }
        System.out.println(sb);
    }
}
