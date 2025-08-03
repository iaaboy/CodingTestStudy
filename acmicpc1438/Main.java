package acmicpc1438;

import java.io.*;
import java.util.*;

/* 가장 작은 직사각형
 * https://www.acmicpc.net/problem/1438
 * 슬라이딩 윈도우, 완탐으로는 최적화 해도 풀리지 않음.
 */

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        TreeSet<Integer> ySet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            Point p = new Point(x, y);
            points.add(p);
            ySet.add(y);
        }

        if (N == 2) {
            System.out.println(4);
            return;
        }

        List<Integer> ys = new ArrayList<>(ySet);

        int minWidth = Integer.MAX_VALUE;

        for (int i = 0; i < ys.size(); i++) {
            for (int j = 0; j < ys.size(); j++) {
                int yLow = ys.get(i);
                int yHigh = ys.get(j);

                List<Integer> xs = new ArrayList<>();
                for (Point p : points) {
                    if (p.y >= yLow && p.y <= yHigh) {
                        xs.add(p.x);
                    }
                }

                if (xs.size() < N / 2)
                    continue;

                Collections.sort(xs);

                for (int t = 0; t + N / 2 - 1 < xs.size(); t++) {
                    int xLow = xs.get(t);
                    int xHigh = xs.get(t + N / 2 - 1);
                    int width = (xHigh - xLow + 2) * (yHigh - yLow + 2);
                    minWidth = Math.min(minWidth, width);
                }
            }
        }

        System.out.println(minWidth);
    }
}
