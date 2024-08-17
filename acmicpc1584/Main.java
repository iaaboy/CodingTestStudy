package acmicpc1584;

import java.io.*;
import java.util.*;

/* 게임
 * https://www.acmicpc.net/problem/1584
 */

public class Main {
    static int MAX_NUM = 500;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int pay[][] = new int[MAX_NUM + 1][MAX_NUM + 1];
        int N = Integer.parseInt(bf.readLine());
        if (N > 0) {
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                setArea(pay, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
            }
        }

        int M = Integer.parseInt(bf.readLine());
        if (M > 0) {
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                setArea(pay, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -1);
            }
        }

        PriorityQueue<Location> pQ = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pQ.add(new Location(0, 0, 0, 10));
        int[][] accumulCost = new int[MAX_NUM + 1][MAX_NUM + 1];
        for (int i = 0; i < accumulCost.length; i++) {
            Arrays.fill(accumulCost[i], Integer.MAX_VALUE);
        }
        accumulCost[0][0] = pay[0][0];
        while (!pQ.isEmpty()) {
            Location cL = pQ.poll();
            // System.out.println(cL);
            if (cL.y == MAX_NUM && cL.x == MAX_NUM) {
                
                System.out.println((cL.distance));
                // bf.readLine();

                // for (int i = 0; i <= MAX_NUM; i++) {
                //     System.out.println(Arrays.toString(pay[i]));
                // }
                // bf.readLine();
                // System.out.println();
                // for (int i = 0; i <= MAX_NUM; i++) {
                //     System.out.println(Arrays.toString(accumulCost[i]));
                // }
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = cL.y + offsetY[i];
                int nextX = cL.x + offsetX[i];
                if (nextX < 0 || nextY < 0 || nextX > MAX_NUM || nextY > MAX_NUM)
                    continue;
                if (Math.abs(i - cL.prev) == 2)
                    continue;

                if (pay[nextY][nextX] != -1) {
                    int c = cL.distance + pay[nextY][nextX];
                    if (accumulCost[nextY][nextX] > c) {
                        accumulCost[nextY][nextX] = c;
                        pQ.add(new Location(nextY, nextX, c, i));
                    }
                }
            }
        }
        System.out.println(("-1"));

    }

    private static void setArea(int[][] pay, int x1, int y1, int x2, int y2, int val) {
        for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
            for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                pay[i][j] = val;
            }
        }
    }

    static class Location {
        int y;
        int x;
        int distance;
        int prev;

        public Location(int y, int x, int distance, int prev) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return y + "," + x + ":" + distance;
        }
    }

    static int[] offsetY = { 0, -1, 0, 1 };
    static int[] offsetX = { -1, 0, 1, 0 };
}
