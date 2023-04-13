package prog159993;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[][] exam = { 
            {"LOSOE",
            "XXXXX",
            "OOOOO",
            "XXXXX",
            "OOOOO"},
                { "SOOOL",
                        "XXXXO",
                        "OOOOO",
                        "OXXXX",
                        "OOOOE" },
                { "LOOXS",
                        "OOOOX",
                        "OOOOO",
                        "OOOOO",
                        "EOOOO" }
        };
        Solution mSol = new Solution();
        for (String[] ex : exam) {
            System.out.println(mSol.solution(ex));
        }
    }
}

class Solution {
    String[] maps;
    boolean[][] visited;
    int xLen, yLen;

    public int solution(String[] maps) {
        int answer = 0;
        this.maps = maps;
        xLen = maps[0].length();
        yLen = maps.length;
        visited = new boolean[yLen][xLen];
        for (int i = 0; i < maps.length; i++) {
            System.out.println(maps[i]);
        }

        Node start = findS('S');
        visited[start.y][start.x] = true;
        int toLever = getMinPath(start, 'L');

        if(toLever == 0) {
            return -1;
        }

        visited = new boolean[yLen][xLen];
        start = findS('L');
        start.visited = true;
        int toGoal = getMinPath(start, 'E');
        answer = toLever + toGoal;

        if(toGoal == 0) {
            return -1;
        }
        return answer;
    }

    /*
     * 못 찾으면 -1
     * 찾으면 distance
     */
    int getMinPath(Node start, char target) {
        int curDist = 0;
        PriorityQueue<Node> pQ = new PriorityQueue<Node>();

        pQ.add(start);
        while (pQ.size() > 0) {
            int curX = pQ.peek().x;
            int curY = pQ.peek().y;
            curDist = pQ.peek().distance;
            pQ.remove();

            // if currentNode의 사방 체크
            if (curX != 0) { // x-1
                if (checkTarget(curY, curX - 1, target))
                    return curDist + 1;
                if (!visited[curY][curX - 1] && maps[curY].charAt(curX-1) != 'X') {
                    visited[curY][curX - 1] = true;
                    System.out.println("x:"  + (curX - 1) + ", y:" + curY + ",min:" + (curDist + 1));
                    pQ.add(new Node(curX - 1, curY, curDist + 1));
                }
            }
            if (curY != 0) { // y-1
                if (checkTarget(curY - 1, curX, target))
                    return curDist + 1;
                if (!visited[curY - 1][curX] && maps[curY-1].charAt(curX) != 'X') {
                    visited[curY - 1][curX] = true;
                    System.out.println("x:"  + (curX) + ", y:" + (curY-1) + ",min:" + (curDist + 1));
                    pQ.add(new Node(curX, curY - 1, curDist + 1));
                }
            }
            if (curX != xLen - 1) { // x+1
                if (checkTarget(curY, curX + 1, target))
                    return curDist + 1;
                if (!visited[curY][curX + 1] && maps[curY].charAt(curX+1) != 'X') {
                    visited[curY][curX + 1] = true;
                    System.out.println("x:"  + (curX + 1) + ", y:" + curY + ",min:" + (curDist + 1));
                    pQ.add(new Node(curX + 1, curY, curDist + 1));
                }
            }
            if (curY != yLen - 1) { // y+1
                if (checkTarget(curY + 1, curX, target))
                    return curDist + 1;
                if (!visited[curY + 1][curX] && maps[curY+1].charAt(curX) != 'X') {
                    visited[curY + 1][curX] = true;
                    System.out.println("x:"  + (curX) + ", y:" + (curY+1) + ",min:" + (curDist + 1));
                    pQ.add(new Node(curX, curY + 1, curDist + 1));
                }
            }
        }
        pQ.clear();
        return 0;
    }

    boolean checkTarget(int y, int x, char target) {
        if (maps[y].charAt(x) == target) {
            return true;
        } else
            return false;
    }

    private Node findS(char inChar) {
        int foundX = 0;
        int y = 0;
        for (String line : maps) {
            foundX = line.indexOf(inChar);
            if (foundX > -1) {
                break;
            }
            y++;
        }
        return new Node(foundX, y, 0);
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int distance;
    boolean visited;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        visited = false;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ":" + distance + ")";
    }

    @Override
    public int compareTo(Node o) { // copareTo리턴 값 예제 찾아보기!
        if (this.distance > o.distance) {
            return 1;
        }
        return -1;
    }
}