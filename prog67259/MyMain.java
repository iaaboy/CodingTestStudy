package prog67259;

import java.util.*;

/* 경주로 건설
 * https://school.programmers.co.kr/learn/courses/30/lessons/67259
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] boards = {
                { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, // 900
                { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } }, // 3800
                { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 0 } }, // 2100
                { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 1 },
                        { 0, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 } }, // 3200
        };

        Solution mSol = new Solution();
        for (int[][] board : boards) {
            System.out.println(mSol.solution(board));
            // break;
        }
    }
}

class Solution {
    int[] offsetY = { 1, -1, 0, 0 };
    int[] offsetX = { 0, 0, -1, 1 };
    int n;

    public int solution(int[][] board) {
        PriorityQueue<LastWork> pQ = new PriorityQueue<>((me, you) -> me.cost - you.cost);
        n = board.length;
        if (board[0][1] != 1) {
            HashSet<Vertex> visitedSet = new HashSet<>();
            visitedSet.add(new Vertex(0, 0));
            visitedSet.add(new Vertex(0, 1));
            pQ.add(new LastWork(0, 1, true, 1, visitedSet));
        }

        if (board[1][0] != 1) {
            HashSet<Vertex> visitedSet = new HashSet<>();
            visitedSet.add(new Vertex(0, 0));
            visitedSet.add(new Vertex(0, 1));
            pQ.add(new LastWork(1, 0, false, 1, visitedSet));
        }

        while (!pQ.isEmpty()) {
            LastWork curWork = pQ.poll();
            // System.out.println("poll" + curWork);

            for (int i = 0; i < 4; i++) {
                int nextX = curWork.x + offsetX[i];
                int nextY = curWork.y + offsetY[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) { // 범위 밖이면,
                    continue;
                }
                if (curWork.visitedSet.contains(new Vertex(nextY, nextX))) { // 방문한 곳이면,
                    continue;
                }
                if (board[nextY][nextX] == 1) { // 벽이면,
                    continue;
                }

                HashSet<Vertex> visitedSet = new HashSet<>(curWork.visitedSet);
                visitedSet.add(new Vertex(nextY, nextX));
                LastWork nextW = new LastWork(nextY, nextX, false, curWork.cost + 1, visitedSet);
                if (curWork.fromX) { // x축 진행중
                    if (i < 2) { // 다음 y
                        nextW.fromX = false;
                        nextW.cost += 5;
                    } else {
                        nextW.fromX = true;
                    }
                } else { // Y축 진행중
                    if (i < 2) { // 다음 y
                        nextW.fromX = false;
                    } else {
                        nextW.fromX = true;
                        nextW.cost += 5;
                    }
                }
                // System.out.println("put" + nextW);
                if (nextW.y == n - 1 && nextW.x == n - 1) {
                    // System.out.println("arrived at goal !!!" + nextW.cost);
                    return nextW.cost * 100;
                }
                pQ.add(nextW);
            }
        }

        int answer = 0;
        return answer;
    }

    class LastWork {
        int y;
        int x;
        int cost;
        boolean fromX;
        HashSet<Vertex> visitedSet;

        public LastWork(int y, int x, boolean fromX, int cost, HashSet<Vertex> visitedSet) {
            this.y = y;
            this.x = x;
            this.fromX = fromX;
            this.cost = cost;
            this.visitedSet = visitedSet;
        }

        @Override
        public String toString() {
            return "<" + y + "," + x + "> " + cost + "\n" + visitedSet;
        }
    }

    class Vertex {
        Integer y;
        Integer x;

        public Vertex(Integer y, Integer x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object obj) {
            Vertex other = (Vertex) obj;
            return other.y == y && other.x == x;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            return prime * y.hashCode() + x.hashCode();
        }

        @Override
        public String toString() {
            return "<" + y + "," + x + ">";
        }
    }
}