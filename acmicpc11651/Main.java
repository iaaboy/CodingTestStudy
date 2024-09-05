package acmicpc11651;

import java.io.*;
import java.util.*;

/* 좌표 정렬하기 2
 * https://www.acmicpc.net/problem/11651
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Coord[] c = new Coord[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            c[i] = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(c, (a, b) -> {
            if (a.y > b.y) {
                return 1;
            } else if (a.y < b.y) {
                return -1;
            } else {
                if (a.x > b.x) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            sb.append(c[i].x + " " + c[i].y + "\n");
        }
        System.out.print(sb);
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
