package prog60061;

import java.util.Arrays;

/* 기둥과 보 설치
 * https://school.programmers.co.kr/learn/courses/30/lessons/60061
 */

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 1, 5, 5 };
        int[][][] build_frame = {
                { { 1, 0, 0, 1 }, { 1, 0, 0, 1 } },
                { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 }, { 5, 1, 0, 1 },
                        { 4, 2, 1, 1 }, { 3, 2, 1, 1 } },
                { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 2, 1, 1, 1 },
                        { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } }
        };
        Solution mSol = new Solution();
        for (int j = 1; j < 3; j++) {
            int[][] result = mSol.solution(n[j], build_frame[j]);
            for (int i = 0; i < result.length; i++) {
                System.out.println(Arrays.toString(result[i]));
            }
            System.out.println();
        }

    }
}

class Solution {
    VERTEX[][] blueprint;
    int n;

    public int[][] solution(int n, int[][] build_frame) {
        n++;
        this.n = n;
        blueprint = new VERTEX[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                blueprint[j][i] = new VERTEX();
            }
        }

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if (a == 0 && b == 0) { // 기둥 삭제
                removeG(y, x);
            } else if (a == 1 && b == 0) {
                removeB(y, x);
            } else if (a == 0 && b == 1) { // 기둥 설치
                if (gAddible(y, x)) {
                    blueprint[y][x].g = true;
                }
            } else if (a == 1 && b == 1) { // 보 설치
                if (bAddible(y, x)) {
                    blueprint[y][x].b = true;
                }
            }

            // printblueprint();
            // System.out.println(x + "," + y + "," + (a == 1 ? "b" : "g") + "," + (b == 1 ?
            // "add" : "remove"));
        }

        int count = 0;
        for (VERTEX[] frame : blueprint) {
            for (VERTEX vt : frame) {
                if (vt.b)
                    count++;
                if (vt.g)
                    count++;
            }
        }

        int[][] answer = new int[count][3];
        count = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (blueprint[y][x].g) {
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count++][2] = 0;
                }
                if (blueprint[y][x].b) {
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count++][2] = 1;
                }
            }
        }

        return answer;
    }

    private void removeB(int y, int x) {
        blueprint[y][x].b = false;

        boolean checkNeighbor = true;

        checkNeighbor = checkAll();

        // // 여기에 기둥이 있으면 체크
        // if (checkNeighbor && blueprint[y][x].g) {
        // checkNeighbor &= gAddible(y, x);
        // }
        // // x+1에 기둥이 있으면 체크
        // if (checkNeighbor && x + 1 < n && blueprint[y][x + 1].g) {
        // checkNeighbor &= gAddible(y, x + 1);
        // }

        // // x-1 에 보가 있으면 체크
        // if (x - 1 >= 0 && blueprint[y][x - 1].b) {
        // checkNeighbor &= bAddible(y, x - 1);
        // }
        // // x+1 에 보가 있으면 체크
        // if (checkNeighbor && x + 1 < n && blueprint[y][x + 1].b) {
        // checkNeighbor &= bAddible(y, x + 1);
        // }

        if (!checkNeighbor) {
            blueprint[y][x].b = true;
        }
    }

    private void removeG(int y, int x) {
        blueprint[y][x].g = false;

        boolean checkNeighbor = true;

        checkNeighbor = checkAll();

        // // y+1에 기둥이 있으면 체크
        // if (y + 1 < n && blueprint[y + 1][x].b) {
        // checkNeighbor &= gAddible(y + 1, x);
        // }

        // // x-1, y+1 에 보가 있으면 체크
        // if (checkNeighbor && x - 1 >= 0 && y + 1 < n && blueprint[y + 1][x - 1].b) {
        // checkNeighbor &= bAddible(y + 1, x - 1);
        // }

        // // y+1 에 보가 있으면 체크
        // if (checkNeighbor && y + 1 < n && blueprint[y + 1][x].b) {
        // checkNeighbor &= bAddible(y + 1, x);
        // }

        if (!checkNeighbor) {
            blueprint[y][x].g = true;
        }
    }

    private boolean checkAll() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (blueprint[y][x].g) {
                    if (!gAddible(y, x)) {
                        return false;
                    }
                }
                if (blueprint[y][x].b) {
                    if (!bAddible(y, x)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean gAddible(int y, int x) {
        if (y == 0 || ((y > 0) && blueprint[y - 1][x].g)) { // 1. 바닥이거나, 다른 기둥 위
            // addible
            return true;
        }
        if (blueprint[y][x].b || (x > 0 && blueprint[y][x - 1].b)) { // 2. 보의 한쪽 끝
            // addible
            return true;
        }
        return false;
    }

    private boolean bAddible(int y, int x) {
        // if (y == 0 ) {
        // return false;
        // }
        if ((y > 0 && blueprint[y - 1][x].g) || (y > 0 && x < n - 1 && blueprint[y - 1][x + 1].g)) { // 한쪽 끝이 기둥위
            return true;
        }
        if ((x > 0 && blueprint[y][x - 1].b) && (x < n - 1 && blueprint[y][x + 1].b)) { // 양쪽에 보가 있다.
            return true;
        }
        return false;
    }

    void printblueprint() {
        // for (int i = blueprint.length - 1; i >= 0; i--) {
        // System.out.println(Arrays.toString(blueprint[i]));
        // }
    }

    class VERTEX {
        boolean b, g;

        @Override
        public String toString() {
            return (g ? "g" : "-") + "," + (b ? "b" : "-");
        }
    }
}