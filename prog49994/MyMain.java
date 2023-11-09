package prog49994;

import java.util.HashMap;
/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */

public class MyMain {
    public static void main(String[] args) {
        String[] dirs = { "UDLRDURL" }; // , "LULLLLLLU"

        Solution mSol = new Solution();

        for (String dir : dirs)
            System.out.println(mSol.solution(dir));
    }
}

class Solution {

    int[] xDiff = { -1, 0, 0, 1 };
    int[] yDiff = { 0, -1, 1, 0 };

    public int solution(String dirs) {
        int curX = 0;
        int curY = 0;

        HashMap<Move, Boolean> moveMap = new HashMap<>();
        HashMap<Character, Integer> chMap = new HashMap<>();

        chMap.put('L', 0);
        chMap.put('D', 1);
        chMap.put('U', 2);
        chMap.put('R', 3);

        for (char ch : dirs.toCharArray()) {
            int nextX = curX + xDiff[chMap.get(ch)];
            int nextY = curY + yDiff[chMap.get(ch)];
            // System.out.println(curX + ", " + curY + ", " + nextX + ", " + nextY + " : " +
            // moveMap.size());

            if (nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5)
                continue;
            Move m = new Move(
                    Math.min(curX, nextX),
                    Math.min(curY, nextY),
                    Math.max(curX, nextX),
                    Math.max(curY, nextY));
            if (!moveMap.containsKey(m)) {
                moveMap.put(m, true);
            } else {
                // System.out.println("hasVal");
            }
            curX = nextX;
            curY = nextY;

        }
        return moveMap.size();
    }
}

class Move {
    int x1;
    int y1;
    int x2;
    int y2;

    public Move(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean equals(Object obj) {
        Move o = (Move) obj;
        return x1 == o.x1 && x2 == o.x2 && y1 == o.y1 && y2 == o.y2;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += x1 * 31;
        result += x2 * 31;
        result += y1 * 31;
        result += y2 * 31;
        return result;
    }
}