package prog150365_2;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 3, 2, 3 };
        int[] m = { 4, 2, 3 };
        int[] x = { 2, 1, 1 };
        int[] y = { 3, 1, 2 };
        int[] r = { 3, 2, 3 };
        int[] c = { 1, 2, 3 };
        int[] k = { 5, 2, 4 };

        Solution mSol = new Solution();
        // for (int i = 0; i < 3; i++)
        int i = 0;
        System.out.println("result :" + mSol.solution(n[i], m[i], x[i], y[i], r[i], c[i], k[i]));
    }
}

class Solution {
    int r, c, k, n, m;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.r = r;
        this.c = c;
        // 알파벳 순 dfs
        char[] path = new char[k];
        StringBuffer answer = new StringBuffer();
        if (dfs(x, y, 0, path)) {
            for (char d : path) {
                answer.append(d);
            }
        } else {
            return "impossible";
        }

        return answer.toString();
    }

    int[] offsetX = { 1, 0, 0, -1 };
    int[] offsetY = { 0, -1, 1, 0 };
    char[] pathChar = { 'd', 'l', 'r', 'u' };

    private boolean dfs(int curX, int curY, int depth, char[] path) {
        System.out.println(curX + "," + curY + ":" + Arrays.toString(path));
        if (depth == k) {
            if (curX == r && curY == c) {
                System.out.println("Hit!!");
                return true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < 4; i++) {
            int nextX = curX + offsetX[i];
            int nextY = curY + offsetY[i];

            // out bound 처리
            if (nextX < 1 || nextX > n || nextY < 1 || nextY > m)
                continue;

            // 남은 거리 가망 없는 것 빼기
            int distance = Math.abs(nextX - r) + Math.abs(nextY - c);
            // 1. 도착점과 현재 지점이 이미 멀어짐.
            // 2. 남은 거리가 홀수라 도달할 수 없음.
            if (distance > k - depth - 1 || (k - depth - 1 - distance) % 2 == 1)
                continue;

            path[depth] = pathChar[i];
            if (dfs(nextX, nextY, depth + 1, path)) {
                return true;
            }
        }

        return false;
    }
}