package prog87694;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[][][] rectangle = {
                { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } },
                { { 1, 1, 8, 4 }, { 2, 2, 4, 9 }, { 3, 6, 9, 8 }, { 6, 3, 7, 7 } },
                { { 1, 1, 5, 7 } },
                { { 2, 1, 7, 5 }, { 6, 4, 10, 10 } },
                { { 2, 2, 5, 5 }, { 1, 3, 6, 4 }, { 3, 1, 4, 6 } },
        };
        int ip[][] = {
                { 1, 3, 7, 8 },
                { 9, 7, 6, 1 },
                { 1, 1, 4, 7 },
                { 3, 1, 7, 10 },
                { 1, 4, 6, 3 },
        };
        Solution mSol = new Solution();
        // for (int i = 0; i < rectangle.length; i++) {
        // System.out.println(mSol.solution(rectangle[i], ip[i][0], ip[i][1], ip[i][2],
        // ip[i][3]));
        // }

        int i = 1;
        System.out.println(mSol.solution(rectangle[i], ip[i][0], ip[i][1], ip[i][2], ip[i][3]));
    }
}

class Solution {
    Rect[] rects;
    TreeSet<Point> allPtr;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        allPtr = new TreeSet<>();
        rects = new Rect[rectangle.length];

        for (int i = 0; i < rectangle.length; i++) {
            rects[i] = new Rect(rectangle[i][0], rectangle[i][1], rectangle[i][2], rectangle[i][3], i);
        }

        int rId = 0;
        for (Rect r : rects) {
            for (int x = r.p1.x; x <= r.p2.x; x++) {
                if (isPointOutside(x, r.p1.y))
                    allPtr.add(new Point(x, r.p1.y, rId));
                if (isPointOutside(x, r.p2.y))
                    allPtr.add(new Point(x, r.p2.y, rId));
                // System.out.print(x + " " + r.p1.y + ", " + x + " " + r.p2.y + ", ");
            }
            // System.out.println();
            for (int y = r.p1.y; y <= r.p2.y; y++) {
                if (isPointOutside(r.p1.x, y))
                    allPtr.add(new Point(r.p1.x, y, rId));
                if (isPointOutside(r.p2.x, y))
                    allPtr.add(new Point(r.p2.x, y, rId));

                // System.out.print(r.p1.x + " " + y + ", " + r.p2.x + " " + y + ", ");
            }
            rId++;
            // System.out.println("\n |||" + allPtr);
            // System.out.println("");
        }

        System.out.println(allPtr);
        System.out.println(Arrays.toString(rects));
        int totalPoints = allPtr.size();
        answer = trip(characterX, characterY, itemX, itemY);

        answer = Math.min(answer, totalPoints - answer);
        System.out.println("Result: " + answer);
        return answer;
    }

    private int trip(int fromX, int fromY, int toX, int toY) {
        int result = 0;
        Point curPoint = null;

        Iterator curPtr = allPtr.iterator();
        while (curPtr.hasNext()) {
            curPoint = (Point) curPtr.next();
            if (curPoint.x == fromX && curPoint.y == fromY) {
                System.out.println("From: " + curPoint);
                allPtr.remove(curPoint);
                break;
            }
        }

        while (!allPtr.isEmpty() && !(curPoint.x == toX && curPoint.y == toY)) {
            result++;
            curPoint = findNext(curPoint);
            allPtr.remove(curPoint);
        }

        return result;
    }

    private Point findNext(Point other) {
        Point curPoint;
        Point candidate = null;
        // 1 같은 그룹
        Iterator curPtr = allPtr.iterator();
        while (curPtr.hasNext()) {
            curPoint = (Point) curPtr.next();
            if (curPoint.rectId == other.rectId
                    && Math.abs(curPoint.x - other.x) + Math.abs(curPoint.y - other.y) == 1) {

                System.out.println("Found: " + curPoint);
                return curPoint;

            }
            if (Math.abs(curPoint.x - other.x) + Math.abs(curPoint.y - other.y) == 1) {
                candidate = curPoint;
            }
        }
        System.out.println("Found secondary: " + candidate);
        return candidate;
        // 2 다른 그룹 1개만 차이
    }

    private boolean isPointOutside(int x, int y) {
        boolean result = true;

        for (Rect r : rects) {
            if ((r.p1.x < x && r.p2.x > x) && (r.p1.y < y && r.p2.y > y)) {
                result = false;
                break;
            }
        }

        if (!result) {
            System.out.println("insidePoint: " + "x:" + x + ", y:" + y);
        }

        return result;
    }
}

class Rect {
    Point p1;
    Point p2;

    public Rect(int x1, int y1, int x2, int y2, int rId) {
        this.p1 = new Point(x1, y1, rId);
        this.p2 = new Point(x2, y2, rId);
    }

    @Override
    public String toString() {
        return p1.toString() + "|" + p2.toString();
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    int rectId;

    public Point(int x, int y, int rectId) {
        this.x = x;
        this.y = y;
        this.rectId = rectId;
    }

    @Override
    public int compareTo(Point o) {
        if (x == o.x) {
            return y - o.y;
        } else {
            return x - o.x;
        }
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ":" + rectId + ")";
    }
}