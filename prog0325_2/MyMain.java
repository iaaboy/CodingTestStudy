package prog0325_2;

import java.util.*;

public class MyMain {

    // https://school.programmers.co.kr/learn/courses/30/lessons/1844
    public static void main(String[] args) {
        int[][] maps0 = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } , { 0, 0, 0, 0, 1 } , { 0, 0, 0, 0, 1 } , { 0, 0, 0, 0, 1 } };
        int[][] maps2 = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1 } };

        Solution mSolution = new Solution();
        System.out.println(mSolution.solution(maps0));
        // System.out.println(mSolution.solution(maps));
        System.out.println(mSolution.solution(maps2));
    }
}

class Solution {
    class Node implements Comparable<Node> {
        int y, x, distance;

        Node(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance > o.distance) {
                return 1;
            }
            return 0;
        }

        // @Override
        // public String toString() {
        //     String str = new String();

        //     str = "(" + y + "," + x + ")" + " " + distance;
        //     return str;
        // }
    }

    boolean visited[][];
    PriorityQueue<Node> pQ;
    int[][] mapRef;
    int goalX;
    int goalY;
    int result;

    public int solution(int[][] maps) {
        Node currenctNode;

        goalX = maps[0].length - 1;
        goalY = maps.length - 1;
        result = -1;

        visited = new boolean [maps.length][maps[0].length];
        mapRef = maps;
        pQ = new PriorityQueue<>();

        pQ.add(new Node(0, 0, 1));

        while (pQ.size() > 0) {
            currenctNode = pQ.peek();
            pQ.remove();

            //System.out.println("current: " + currenctNode.y + "," + currenctNode.x + ":" + currenctNode.distance);

            if (check(currenctNode)) {
                return result;
            }
        }

        return result;
    }

    int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private boolean check(Node nd) {
        boolean checkResult = false;

        //visited[nd.y][nd.x] = true;

        for (int i = 0; i < 4; i++) {
            checkResult = checheckAddck(nd, i);
            if (checkResult) // goal을 찾음.
                break;
        }

        return checkResult;
    }

    private boolean checheckAddck(Node nd, int dIdx) {
        // 4방향 체크
        int y = nd.y + directions[dIdx][1];
        int x = nd.x + directions[dIdx][0];

        if (x < 0 || y < 0 || x > goalX || y > goalY) {
            return false;
        }

        if (visited[y][x]) {
            return false;
        }

        if (y == goalY && x == goalX) {
            result = nd.distance +1;
            return true;
        }

        if (mapRef[y][x] == 1) {
            //System.out.println("add to Queue: " + y + "," + x);
            //중요 !!! queue넣을 때에 visited 처리하는 것이 효율설에 영향을 줌.!!!
            // 그렇게 하지 않으면, 중복 내용이 queue에 들어감.
            visited[y][x] = true;
            pQ.add(new Node(y, x, nd.distance + 1));
        }/* else if (mapRef[y][x] == 0) {
            // wall do nothing
        } else {
            System.out.println("Something Wrong");
        } */

        return false;
    }
}
