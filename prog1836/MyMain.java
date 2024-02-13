package prog1836;

import java.util.*;

/* 리틀 프렌즈 사천성
 * https://school.programmers.co.kr/learn/courses/30/lessons/1836
 */

public class MyMain {
    public static void main(String[] args) {
        int[] m = { 3, 3, 2, 4, 2, 5 };
        int[] n = { 3, 3, 4, 4, 2, 5 };
        String[][] thisboard = {
                { "AZA", "BZB", "***" },
                { "DBA", "C*A", "CDB" }, // "ABCD"
                { "NRYN", "ARYA" }, // "RYAN"
                { ".ZI.", "M.**", "MZU.", ".IU." }, // "MUZI"
                { "AB", "BA" }, // "IMPOSSIBLE",
                { "FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE" }
        };
        Solution mSol = new Solution();
        for (int i = 1; i < 2; i++) {
            System.out.println(mSol.solution(m[i], n[i], thisboard[i]));
        }
    }
}

class Solution {
    static List<Vertex> list;
    static int[] offsetY = { -1, 1, 0, 0 }, offsetX = { 0, 0, -1, 1 };
    static char[][] map;
    static boolean[][] visit;
    static int yMax, xMax;

    public String solution(int m, int n, String[] board) {

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        list = new ArrayList<>();
        map = new char[m + 1][n + 1];
        yMax = m;
        xMax = n;

        for (int i = 1; i <= yMax; i++) {
            for (int j = 1; j <= xMax; j++) {
                map[i][j] = board[i - 1].charAt(j - 1);
                if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
                    list.add(new Vertex(i, j, map[i][j]));
                    cnt++;
                }
            }
        }
        list.sort((a, b) -> a.c - b.c);
        // System.out.println(list);

        visit = new boolean[yMax + 1][xMax + 1];

        while (true) {
            boolean isRemove = false;// 삭제 되면 다음것.
            for (int a = 0; a < list.size(); a++) {
                Vertex p = list.get(a);
                int y = p.y;
                int x = p.x;
                char c = p.c;

                if (!visit[y][x]) {
                    boolean remove = dfs(c, y, x, -1, -1);

                    if (remove) {
                        isRemove = true;
                        cnt -= 2;
                        sb.append(c);
                        map[y][x] = '.';
                        list.remove(a);
                        break;
                    }
                }
            }
            if (!isRemove)
                break;
        }

        return (cnt == 0) ? sb.toString() : "IMPOSSIBLE";
    }

    static boolean dfs(char c, int y, int x, int dir, int rotate) {
        // System.out.println("dfs: " + c + "<" + y + "," + x + ">");

        if (dir != -1 && map[y][x] == c) {
            map[y][x] = '.';
            return true;
        }

        boolean result = false;
        visit[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + offsetY[i];
            int nextX = x + offsetX[i];

            if (nextY < 1 || nextX < 1 || nextY > yMax || nextX > xMax || visit[nextY][nextX])
                continue;
            if (map[nextY][nextX] != c && map[nextY][nextX] != '.')
                continue;

            if (rotate >= 1) { // 꺽여서 들어온 경우
                if (i == dir) {
                    result |= dfs(c, nextY, nextX, i, rotate);
                }
            } else {
                result |= dfs(c, nextY, nextX, i, (i == dir) ? rotate : rotate + 1);
            }
        }

        visit[y][x] = false;
        return result;
    }

    static class Vertex {
        int y, x;
        char c;

        public Vertex(int y, int x, char c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }

        @Override
        public String toString() {
            return c + "<" + y + "," + x + ">";
        }
    }
}