package prog150365;

/* 미로 탈출 명령어
 * https://school.programmers.co.kr/learn/courses/30/lessons/150365
 */

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

//
/*
 * 1. 격자의 바깥으로는 나갈 수 없습니다.
 * 2. (x, y)에서 (r, c)까지 이동하는 거리가 총 k여야 합니다. 이때, (x, y)와 (r, c)격자를 포함해, 같은 격자를 두
 * 번 이상 방문해도 됩니다.
 * 3. 미로에서 탈출한 경로를 문자열로 나타냈을 때, 문자열이 사전 순으로 가장 빠른 경로로 탈출해야 합니다.
 */
class Solution {
    int[] offsetX = { 1, 0, 0, -1 };
    int[] offsetY = { 0, -1, 1, 0 };
    char[] offsetChar = { 'd', 'l', 'r', 'u' };
    int offsetMax = 4;
    int n, m, k, r, c;
    // Boolean isStop = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.r = r;
        this.c = c;
        char[] path = new char[k];

        if (goNext(x, y, 0, path)) {
            String answer = "";
            for (int i = 0; i < k; i++) {
                answer += path[i];
            }
            return answer;
        }

        return "impossible";
    }

    boolean goNext(int x, int y, int depth, char[] path) {
        // System.out.println("<" + x + "," + y + "-" + depth + "> " + Arrays.toString(path));
        if (depth == k) {
            return false;
        }

        for (int i = 0; i < offsetMax; i++) {
            int nextX = x + offsetX[i];
            int nextY = y + offsetY[i];
            if (nextX < 1 || nextX > n || nextY < 1 || nextY > m)
                continue;
            int d = Math.abs(nextX - r) + Math.abs(nextY - c);
            if ((d > k - depth - 1 /* 이 조건이 제일 중요 */ || (k - depth - 1 - d) % 2 == 1))
                continue;

            if (nextX == r && nextY == c && depth + 1 == k) {
                path[depth] = offsetChar[i];
                // System.out.println("<" + x + "," + y + "-" + depth + "> " + Arrays.toString(path));
                return true;
            }

            path[depth] = offsetChar[i];
            if (goNext(nextX, nextY, depth + 1, path)) {
                return true;
            }
        }
        return false;
    }
}