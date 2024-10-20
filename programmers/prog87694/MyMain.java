package prog87694;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[][][] rectangle = {
                { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } },
                { { 1, 1, 8, 4 }, { 2, 2, 4, 9 }, { 3, 6, 9, 8 }, { 6, 3, 7, 7 } },
                { { 1, 1, 5, 7 } },
                { { 2, 1, 7, 5 }, { 6, 4, 10, 10 } },
                { { 2, 2, 5, 5 }, { 1, 3, 6, 4 }, { 3, 1, 4, 6 } }
        };
        int ip[][] = {
                { 1, 3, 7, 8 },
                { 9, 7, 6, 1 },
                { 1, 1, 4, 7 },
                { 3, 1, 7, 10 },
                { 1, 4, 6, 3 }
        };

        // int i = 2;

        for (int i = 0; i < 5; i++) {
            Solution mSol = new Solution();
            System.out.println(mSol.solution(rectangle[i], ip[i][0], ip[i][1], ip[i][2], ip[i][3]));
        }
    }
}

class Solution {
    Rect[] rects;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        rects = new Rect[rectangle.length];
        for (int i = 0; i < rectangle.length; i++) {
            rects[i] = new Rect(rectangle[i][0] * 2, rectangle[i][1] * 2, rectangle[i][2] * 2, rectangle[i][3] * 2, i);
        }
        // set contact
        setNeighbor();

        // System.out.println(allPtr);
        // System.out.println(rects[0] + "\n");
        // System.out.println(rects[1] + "\n");
        // System.out.println(rects[2] + "\n");
        // System.out.println(rects[3] + "\n");
        // System.out.println(Arrays.toString(rects));

        answer = trip(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        // System.out.println("Result: " + answer);
        return answer;
    }

    private void setNeighbor() {
        for (int me = 0; me < rects.length; me++) {
            for (int other = 0; other < rects.length; other++) {
                if (me == other)
                    continue;
                for (int i = 0; i < rects[me].outline.size(); i++) {
                    for (int j = 0; j < rects[other].outline.size(); j++) {
                        if (rects[me].outline.get(i).x == rects[other].outline.get(j).x
                                && rects[me].outline.get(i).y == rects[other].outline.get(j).y) {
                            rects[me].outline.get(i).contact = rects[other].outline.get(j).rectId;
                            rects[other].outline.get(j).contact = rects[me].outline.get(i).rectId;
                        }
                    }
                }
            }
        }
    }

    int midResult = -1;
    int fromX;
    int fromY;

    private int trip(int fromX, int fromY, int toX, int toY) {
        int result = 0;

        this.fromX = fromX;
        this.fromY = fromY;

        // 도형을 찾는다.
        Point curP = null;
        for (Rect r : rects) {
            for (Point p : r.outline) {
                if (p.x == fromX && p.y == fromY) {
                    curP = p;
                    break;
                }
            }
            if (curP != null)
                break;
        }

        // System.out.println("start Y,X: " + curP);
        while (!(curP.isVisited && curP.x == fromX && curP.y == fromY)) {
            if (curP.contact != -1) {
                curP = nextPoint(curP, true);
            } else {
                curP = nextPoint(curP, false);
            }
            result++;
            // System.out.println("goNext: " + curP + ",r: " + result);

            if (curP.x == toX && curP.y == toY) {
                midResult = result;
                // System.out.println("result: " + result);
            }
        }
        // System.out.println("final result: " + result);

        result = Math.min(midResult / 2, (result - midResult) / 2);

        return result;
    }

    Point nextPoint(Point curP, boolean isCross) {
        int rectId = curP.rectId;
        if (isCross) {
            rectId = curP.contact;
            for (Point p : rects[rectId].outline) {
                if (curP.x == p.x && curP.y == p.y) {
                    p.isVisited = true;
                }
            }
        }
        for (Point p : rects[rectId].outline) {
            if (!p.isVisited && p.rectId != -1 && ((curP.x == p.x && Math.abs(curP.y - p.y) == 1)
                    || curP.y == p.y && Math.abs(curP.x - p.x) == 1)) {
                if (isCross) {
                    // 상대 도형 내부인지 확인
                    // System.out.println(curP);
                    // System.out.println(p);

                    // System.out.println(rects[curP.rectId].p1);
                    // System.out.println(rects[curP.rectId].p2);

                    if ((rects[curP.rectId].p1.x <= p.x && rects[curP.rectId].p2.x >= p.x
                            && rects[curP.rectId].p1.y <= p.y && rects[curP.rectId].p2.y >= p.y)) {
                        // System.out.println("pass: " + p);p.isVisited = true;
                        continue;
                    }

                }

                if (midResult < 0 && (p.x == fromX) && (p.y == fromY)) {
                    continue;
                }

                p.isVisited = true;
                return p;
            }
        }

        return null;
    }
}

class Rect {
    Point p1;
    Point p2;
    ArrayList<Point> outline = new ArrayList<>();

    public Rect(int x1, int y1, int x2, int y2, int rId) {
        this.p1 = new Point(y1, x1, rId);
        this.p2 = new Point(y2, x2, rId);
        for (int i = x1; i <= x2; i++) {
            outline.add(new Point(y1, i, rId));
            outline.add(new Point(y2, i, rId));
        }
        for (int k = y1 + 1; k < y2; k++) {
            outline.add(new Point(k, x1, rId));
            outline.add(new Point(k, x2, rId));
        }
    }

    @Override
    public String toString() {
        return outline.toString();
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    int rectId;
    int contact;
    boolean isVisited = false;

    public Point(int y, int x, int rectId) {
        this.x = x;
        this.y = y;
        this.rectId = rectId;
        this.contact = -1;
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
        return "(" + x + "," + y + ":" + rectId + "," + contact + ")";
    }
}