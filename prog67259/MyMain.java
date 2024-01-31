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
    public int solution(int[][] board) {

        PriorityQueue<LastWork> pQ = new PriorityQueue<>((me, you) -> {
            return me.cost - you.cost;
        });
        Boolean[][] visited = new Boolean[board.length][board[0].length];
        Arrays.stream(visited).forEach(a -> Arrays.fill(a, false));
        visited[0][0] = visited[0][1] = true;
        pQ.add(new LastWork(0, 1, true, 1, visited));

        Boolean[][] visited2 = new Boolean[board.length][board[0].length];
        Arrays.stream(visited2).forEach(a -> Arrays.fill(a, false));
        visited2[0][0] = visited2[1][0] = true;
        pQ.add(new LastWork(1, 0, false, 1, visited2));

        while (!pQ.isEmpty()) {
            LastWork curWork = pQ.poll();

            // System.out.println("poll" + curWork);

            for (int i = 0; i < 4; i++) {
                int nextX = curWork.x + offsetX[i];
                int nextY = curWork.y + offsetY[i];
                if (nextX < 0 || nextX >= board[0].length || nextY < 0 || nextY >= board.length) { //범위 밖이면,
                    continue;
                }
                if (curWork.visited[nextY][nextX]) { // 방문한 곳이면,
                    continue;
                }
                if (board[nextY][nextX] == 1) { // 벽이면,
                    continue;
                }

                Boolean[][] visitedCopy = new Boolean[board.length][board[0].length];
                for (int j = 0; j < board.length; j++) {
                    visitedCopy[j] = curWork.visited[j].clone();
                }
                LastWork nextW = new LastWork(nextY, nextX, false, curWork.cost + 1, visitedCopy);
                nextW.visited[nextY][nextX] = true;
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
                if (nextW.y == board.length - 1 && nextW.x == board[0].length - 1) {
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
        Boolean[][] visited;

        public LastWork(int y, int x, boolean fromX, int cost, Boolean[][] visited) {
            this.y = y;
            this.x = x;
            this.fromX = fromX;
            this.cost = cost;
            this.visited = visited;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            for (Boolean[] v : visited) {
                sb.append(Arrays.toString(v) + "\n");
            }
            return "<" + y + "," + x + "> " + cost + "\n" + sb.toString();
        }
    }
}