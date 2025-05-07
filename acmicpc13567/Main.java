package acmicpc13567;

import java.io.*;
import java.util.*;

/* 로봇
 * https://www.acmicpc.net/problem/13567
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { 1, 0, -1, 0 };
        int x = 0, y = 0;
        int dir = 0;
        boolean succseed = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            String cmd = st.nextToken();
            if (cmd.contentEquals("MOVE")) {
                int multi = Integer.parseInt(st.nextToken());
                x += dx[dir] * multi;
                y += dy[dir] * multi;
                if (x < 0 || y < 0 || x >= M || y >= M) {
                    succseed = false;
                }
            } else {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    dir++;
                    if (dir > 3) {
                        dir = 0;
                    }
                } else {
                    dir--;
                    if (dir < 0) {
                        dir = 3;
                    }
                }
            }
        }
        if (succseed) {
            System.out.println(x + " " + y);
        } else {
            System.out.println(-1);
        }
    }
}
