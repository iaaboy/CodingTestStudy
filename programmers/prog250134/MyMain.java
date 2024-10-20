package prog250134;

import java.util.*;

/* [PCCP 기출문제] 4번 / 수레 움직이기
 * https://school.programmers.co.kr/learn/courses/30/lessons/250134
 */

public class MyMain {
    public static void main(String[] args) {
        // 1 ≤ maze의 길이 (= 세로 길이) ≤ 4
        // 1 ≤ maze[i]의 길이 (= 가로 길이) ≤ 4
        // 0 빈칸
        // 1 빨간 수레의 시작 칸 / 지나간 자리 11 / 둘다 13
        // 2 파란 수레의 시작 칸 / 지나간 자리 12
        // 3 빨간 수레의 도착 칸
        // 4 파란 수레의 도착 칸
        // 5 벽
        int[][][] mazes = {
                { { 1, 4 }, { 0, 0 }, { 2, 3 } },
                { { 1, 0, 2 }, { 0, 0, 0 }, { 5, 0, 5 }, { 4, 0, 3 } },
                { { 1, 5 }, { 2, 5 }, { 4, 5 }, { 3, 5 } },
                { { 4, 1, 2, 3 } }
        };

        Solution mSol = new Solution();
        for (int[][] maze : mazes) {
            System.out.println(mSol.solution(maze));
        }
    }
}

class Solution {
    int v, h;
    int[][] maze;
    int[] offsetX = { 0, 1, -1, 0 };
    int[] offsetY = { 1, 0, 0, -1 };
    int[][] routeRed, routeBlue;
    static int X = 0;
    static int Y = 1;
    int curDepth = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        v = maze.length;
        h = maze[0].length;
        this.maze = maze;
        int[] red = new int[2];
        int[] blue = new int[2];
        routeRed = new int[v][h]; // red의 경로
        routeBlue = new int[v][h]; // blue의 경로

        for (int y = 0; y < v; y++)
            for (int x = 0; x < h; x++) {
                if (maze[y][x] == 1) {
                    red[Y] = y;
                    red[X] = x;
                    routeRed[y][x] = 1;
                }
                if (maze[y][x] == 2) {
                    blue[Y] = y;
                    blue[X] = x;
                    routeBlue[y][x] = 1;
                }
                if (maze[y][x] == 5) {
                    routeRed[y][x] = -1;
                    routeBlue[y][x] = -1;
                }
            }

        curDepth = Integer.MAX_VALUE;
        journey(red, blue, 2);

        // 답이 없으면 0, 있으면 depth값
        return curDepth == Integer.MAX_VALUE ? 0 : curDepth - 2;
    }

    void journey(int[] red, int[] blue, int depth) {
        if (curDepth != Integer.MAX_VALUE && curDepth <= depth) {
            return;
        }

        if (maze[red[Y]][red[X]] == 3 && maze[blue[Y]][blue[X]] == 4) {
            if (curDepth > depth)
                curDepth = depth;
            // System.out.println(depth + ": Cur <" + red[Y] + "," + red[X] + "><" + blue[Y]
            // + "," + blue[X] + ">");
            // printR();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRY = red[Y];
            int nextRX = red[X];
            if (maze[red[Y]][red[X]] != 3) {
                nextRY += offsetY[i];
                nextRX += offsetX[i];
            }

            if (nextRY < 0 || nextRY >= v || nextRX < 0 || nextRX >= h) // 범위에서 벗어나면 무시
                continue;

            if (routeRed[nextRY][nextRX] == 0 || maze[nextRY][nextRX] == 3) {
                int[] newRed = new int[2];
                newRed[Y] = nextRY;
                newRed[X] = nextRX;

                for (int j = 0; j < 4; j++) {
                    int nextBY = blue[Y];
                    int nextBX = blue[X];
                    if (maze[blue[Y]][blue[X]] != 4) {
                        nextBY += offsetY[j];
                        nextBX += offsetX[j];
                    }
                    int[] newBlue = new int[2];
                    newBlue[Y] = nextBY;
                    newBlue[X] = nextBX;
                    if (nextBY < 0 || nextBY >= v || nextBX < 0 || nextBX >= h) // 범위에서 벗어나면 무시
                        continue;
                    if ((routeBlue[nextBY][nextBX] == 0 || maze[nextBY][nextBX] == 4) &&
                            !(nextBY == nextRY && nextBX == nextRX) &&
                            !(nextBY == red[Y] && nextBX == red[X] && blue[Y] == nextRY && blue[X] == nextRX)) {
                        routeRed[nextRY][nextRX] = depth;
                        routeBlue[nextBY][nextBX] = depth;
                        // System.out.println(Arrays.toString(newRed) + "|" + Arrays.toString(newBlue));
                        journey(newRed, newBlue, depth + 1); // 다음 좌표를 넣고, 재귀
                        routeRed[nextRY][nextRX] = 0;
                        routeBlue[nextBY][nextBX] = 0;
                    }
                }
            }
        }
    }

    void printR() {
        for (int i = 0; i < routeRed.length; i++) {
            System.out.print("R:" + Arrays.toString(routeRed[i]) + "   ");
            System.out.println("B:" + Arrays.toString(routeBlue[i]));
        }
        System.out.println("-----");
    }
}