package prog150365;

/* 미로 탈출 명령어
 * https://school.programmers.co.kr/learn/courses/30/lessons/150365
 */

import java.util.ArrayList;

public class MyMain {
    public static void main(String[] args) {
        // n m x y r c k result
        // 3 4 2 3 3 1 5 "dllrl"
        // 2 2 1 1 2 2 2 "dr"
        // 3 3 1 2 3 3 4 "impossible"

        int[] n = { 3, 2, 3 };
        int[] m = { 4, 2, 3 };
        int[] x = { 2, 1, 1 };
        int[] y = { 3, 1, 2 };
        int[] r = { 3, 2, 3 };
        int[] c = { 1, 2, 3 };
        int[] k = { 5, 2, 4 };

        Solution mSol = new Solution();
        for (int i = 0; i < 3; i++)
            System.out.println(mSol.solution(n[i], m[i], x[i], y[i], r[i], c[i], k[i]));
    }
}

class Solution {
    int m, n;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        ArrayList<String> route = new ArrayList<>();
        this.n = n;
        this.m = m;

        int moveCount = 0;

        // char lr;
        if (x > r) {
            for (int i = 0; i < x - r; i++) {
                moveCount++;
                route.add("u");
            }
        } else if (x < r) {
            for (int i = 0; i < r - x; i++) {
                moveCount++;
                route.add("d");
            }
        }

        // char ud;
        if (y > c) {
            for (int i = 0; i < y - c; i++) {
                moveCount++;
                route.add("l");
            }
        } else {
            for (int i = 0; i < c - y; i++) {
                moveCount++;
                route.add("r");
            }
        }

        route.sort(null);

        if (moveCount > k) {
            return "impossible";
        } else if (moveCount < k) {
            if ((k - moveCount) % 2 == 0) {
                checkRoutine(route, x, y, k - moveCount);
            } else {
                return "impossible";
            }
        }

        for (int i = 0; i < route.size(); i++) {
            answer += route.get(i);
        }

        return answer;
    }

    private void checkRoutine(ArrayList<String> candiList, int x, int y, int remained) {
        int count = 1;
        for (String cur : candiList) {
            if (cur.equals("d")) {
                x += 1;
            } else if (cur.equals("u")) {
                x -= 1;
            }
            if (cur.equals("l")) {
                y -= 1;
            }
            if (cur.equals("r")) {
                y += 1;
            }

            checkAddible(x, y);
            System.out.println("cur(" + x + "," + y + ") : " + count++);
        }
    }

    private void checkAddible(int x, int y) {
        ArrayList<String> candiList = new ArrayList<>();
        if (x != 0) {
            // 좌로 못 감.
            candiList.add("lr");
        }
        if (x != n) {
            // 우로 못 감.
            candiList.add("rl");
        }
        if (y != 0) {
            candiList.add("ud");
        }
        if (y != m) {
            candiList.add("du");
        }

        candiList.sort(null);
        System.out.println(candiList);
    }
}