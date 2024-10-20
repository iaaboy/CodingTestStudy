package prog87377;

import java.util.ArrayList;
import java.util.Arrays;

/* 교점에 별 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87377
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] line = {
                { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 0, 1 } },
                { { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } },
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++) {
            String[] result = mSol.solution(line[i]);
            for (String string : result) {
                System.out.println(string);
            }
        }

    }
}

class Solution {
    public String[] solution(int[][] line) {
        int[] xArea = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        int[] yArea = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        ArrayList<Coord> mCoords = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i; j < line.length; j++) {
                if (i == j)
                    continue;
                long adbc = (long) line[i][0] * (long) line[j][1] - (long) line[i][1] * (long) line[j][0];
                if (adbc == 0)
                    continue;
                long bfed = (long) line[i][1] * (long) line[j][2] - (long) line[i][2] * (long) line[j][1];
                long ecaf = (long) line[i][2] * (long) line[j][0] - (long) line[i][0] * (long) line[j][2];
                if (bfed % adbc != 0 || ecaf % adbc != 0)
                    continue;
                long x = bfed / adbc;
                long y = ecaf / adbc;

                xArea[0] = Math.min(xArea[0], (int) x);
                xArea[1] = Math.max(xArea[1], (int) x);
                yArea[0] = Math.min(yArea[0], (int) y);
                yArea[1] = Math.max(yArea[1], (int) y);
                mCoords.add(new Coord((int) x, (int) y));
                // System.out.println("Cross: " + i + "," + j + " -> " + x + "," + y);
            }
        }

        // System.out.println("area: " + xArea[0] + " ~ " + xArea[1] + " , " + yArea[0]
        // + " ~ " + yArea[1]);
        int xMax = xArea[1] - xArea[0];
        int yMax = yArea[1] - yArea[0];
        // System.out.println("area: " + 0 + " ~ " + xMax + " , " + 0 + " ~ " + yMax);

        char[][] ans = new char[yMax + 1][xMax + 1];
        for (int i = 0; i < ans.length; i++) {
            Arrays.fill(ans[i], '.');
        }

        for (Coord coord : mCoords) {
            // System.out.println((coord.x - xArea[0]) + "," + (coord.y - yArea[0]));
            ans[coord.y - yArea[0]][coord.x - xArea[0]] = '*';
        }

        String[] answer = new String[yMax + 1];
        for (int i = 0; i < answer.length; i++) {
            int revIndex = answer.length - 1 - i;
            answer[revIndex] = new String();
            for (int j = 0; j < ans[i].length; j++) {
                answer[revIndex] += ans[i][j];
            }
        }
        return answer;
    }

    class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}