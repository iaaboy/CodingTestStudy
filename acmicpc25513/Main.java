package acmicpc25513;

import java.io.*;
import java.util.*;

/* 빠른 오름차순 숫자 탐색
 * https://www.acmicpc.net/problem/25513
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int arr[][] = new int[5][5];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());// 세로
        int c = Integer.parseInt(st.nextToken());// 가로

        PriorityQueue<History> pq = new PriorityQueue<>((a, b) -> {
            if (a.num == b.num) {
                return a.cost - b.cost;
            } else {
                return b.num - a.num;
            }
        });
        boolean[][][] visited = new boolean[7][5][5];
        visited[arr[r][c]][r][c] = true;
        pq.add(new History(r, c, arr[r][c], 0));

        while (!pq.isEmpty()) {
            History cur = pq.poll();
            // System.out.println("visit: " + cur);
            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + oR[i];
                int nextC = cur.c + oC[i];

                if (nextC < 0 || nextR < 0 || nextC > 4 || nextR > 4)
                    continue;
                if (arr[nextR][nextC] != -1 && !visited[cur.num][nextR][nextC]) {
                    if (cur.num == 5 && arr[nextR][nextC] == 6) {
                        // System.out.print("arrived : ");
                        System.out.println((cur.cost + 1));
                        return;
                    }
                    visited[cur.num][nextR][nextC] = true;
                    int curNum = (arr[nextR][nextC] == cur.num + 1) ? arr[nextR][nextC] : cur.num;
                    pq.add(new History(nextR, nextC, curNum, cur.cost + 1));
                }
            }
        }
        System.out.println(-1);
    }

    static int[] oC = { 0, 1, -1, 0 };
    static int[] oR = { 1, 0, 0, -1 };

    static class History {
        int r, c, num;
        int cost;

        public History(int r, int c, int num, int cost) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "(" + r + "," + c + ") : " + num + "," + cost;
        }
    }
}