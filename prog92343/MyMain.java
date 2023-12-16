package prog92343;

import java.util.*;

/* 양과 늑대
 * https://school.programmers.co.kr/learn/courses/30/lessons/92343
 */

public class MyMain {
    public static void main(String[] args) {
        int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
                { 4, 6 }, { 8, 9 } };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(info, edges));
    }
}

class Solution {
    int[][] dir;
    boolean[] isVisited;
    int[] info;
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        dir = new int[info.length][2];
        isVisited = new boolean[info.length];
        for (int[] d : dir) {
            d[0] = d[1] = -1;
        }
        for (int[] e : edges) {
            if (dir[e[0]][0] == -1) {
                dir[e[0]][0] = e[1];
            } else {
                dir[e[0]][1] = e[1];
            }
        }
        this.info = info;

        visit(0, 0, 0, new ArrayList<>(), new ArrayList<>());

        return answer;
    }

    void visit(int cur, int ship, int wolf, ArrayList<Integer> candidate, ArrayList<Integer> history) { /* history 는 디버깅용 */
        int next0 = dir[cur][0];
        int next1 = dir[cur][1];
        if (info[cur] == 0) {
            ship++;
        } else {
            wolf++;
        }
        if (wolf >= ship) {
            return;
        }
        answer = Math.max(answer, ship);

        // System.out.println(
        // "c:" + cur + " ,ship: " + ship + " ,wolf: " + wolf + " ,candi: " + candidate
        // + " ,hist: " + history);

        //자식 노드1
        if (next0 != -1) {
            ArrayList<Integer> mNext = new ArrayList<>(candidate);
            ArrayList<Integer> visited = new ArrayList<>(history);
            visited.add(cur);
            if (next1 != -1) {
                mNext.add(next1);
            }
            visit(next0, ship, wolf, mNext, visited);
        }
        //자식 노드2
        if (next1 != -1) {
            ArrayList<Integer> mNext = new ArrayList<>(candidate);
            ArrayList<Integer> visited = new ArrayList<>(history);
            visited.add(cur);
            if (next0 != -1) {
                mNext.add(next0);
            }
            visit(next1, ship, wolf, mNext, visited);
        }

        //반대쪽 방문하지 않은 노드
        for (int c : candidate) {
            ArrayList<Integer> mNext = new ArrayList<>(candidate);
            ArrayList<Integer> visited = new ArrayList<>(history);
            visited.add(cur);
            mNext.remove((Integer) c);
            if (next1 != -1) {
                mNext.add(next1);
            }
            if (next0 != -1) {
                mNext.add(next0);
            }
            visit(c, ship, wolf, mNext, visited);
        }
    }
}