package acmicpc10158;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());// 가로
        int y = Integer.parseInt(st.nextToken());// 세로

        int t = Integer.parseInt(bf.readLine());
        int[] dx = { 1, -1, -1, 1 };
        int[] dy = { 1, 1, -1, -1 };
        int direction = 0;
        while (t-- > 0) {
            if ((x == 0 || x == w) && (y == 0 || y == h)) {
                // 이전 방향으로
                direction += 2;
                direction %= 4;
            } else if (x == w) {
                //이전 방향 0, 4
                if (direction == 0) {
                    direction = 1;
                } else if (direction == 3) {
                    direction = 2;
                }
            } else if (y == h) {
                if (direction == 0) {
                    direction = 3;
                } else if (direction == 1) {
                    direction = 2;
                }
            } else if (x == 0) {
                if (direction == 2) {
                    direction = 3;
                } else if (direction == 1) {
                    direction = 0;
                }
            } else if (y == 0) {
                if (direction == 3) {
                    direction = 0;
                } else if (direction == 2) {
                    direction = 1;
                }
            }
            x += dx[direction];
            y += dy[direction];
            // System.out.println(x + " " + y);
        }
        System.out.println(x + " " + y);
    }
}
