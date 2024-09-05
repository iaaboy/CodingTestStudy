package acmicpc9205;

import java.io.*;
import java.util.*;

/* 맥주 마시면서 걸어가기
 * https://www.acmicpc.net/problem/9205
 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int x, y;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            Coord[] spots = new Coord[N + 1];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Coord house = new Coord(x, y);
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(bf.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                spots[j] = new Coord(x, y);
            }
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Coord rockFest = new Coord(x, y);
            rockFest.isFest = true;
            spots[N] = rockFest;

            boolean result = travel(spots, house);

            sb.append((result ? "happy" : "sad") + "\n");
        }
        System.out.print(sb);
    }

    private static boolean travel(Coord[] spots, Coord house) {
        Queue<Coord> q = new LinkedList<>();
        q.add(house);
        while (!q.isEmpty()) {
            Coord cur = q.poll();
            for (int i = 0; i < spots.length; i++) {
                if (!spots[i].visited) {
                    if (checkDist(cur, spots[i])) {
                        if (spots[i].isFest) {
                            return true;
                        } else {
                            spots[i].visited = true;
                            q.add(spots[i]);
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkDist(Coord cur, Coord target) {
        int xDiff = Math.abs(cur.x - target.x);
        int yDiff = Math.abs(cur.y - target.y);
        return xDiff + yDiff <= 1000;
    }

    static class Coord {
        int x;
        int y;
        boolean isFest = false;
        boolean visited = false;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
