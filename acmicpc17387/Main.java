package acmicpc17387;

/* 선분 교차 2
 * https://www.acmicpc.net/problem/17387
 * CCW
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());
        long ccw1 = CCW(x1, y1, x2, y2, x3, y3);
        long ccw2 = CCW(x1, y1, x2, y2, x4, y4);
        long ccw3 = CCW(x3, y3, x4, y4, x1, y1);
        long ccw4 = CCW(x3, y3, x4, y4, x2, y2);
        // System.out.println(ccw1 + "," + ccw2 + ", " + ccw3 + "," + ccw4);
        if (ccw1 == 0 && ccw2 == 0) {
            // 좌표가 이내인지 아닌지.
            if (isInRange(x1, x2, x3, y1, y2, y3) || isInRange(x1, x2, x4, y1, y2, y4) ||
            isInRange(x3, x4, x1, y3, y4, y1) || isInRange(x3, x4, x2, y3, y4, y2)
            ) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

            return;
        } else if (ccw1 == 0) {
            if (isInRange(x1, x2, x3, y1, y2, y3)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

            return;
        } else if (ccw2 == 0) {
            if (isInRange(x1, x2, x4, y1, y2, y4)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

            return;
        }
        long INF = Long.MAX_VALUE;
        ccw1 = ccw1 == 0 ? INF : ccw1 / Math.abs(ccw1);
        ccw2 = ccw2 == 0 ? INF : ccw2 / Math.abs(ccw2);
        ccw3 = ccw3 == 0 ? INF : ccw3 / Math.abs(ccw3);
        ccw4 = ccw4 == 0 ? INF : ccw4 / Math.abs(ccw4);
        // System.out.println(ccw1*ccw2);
        // System.out.println(ccw3*ccw4);

        if (ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean isInRange(long x1, long x2, long x3, long y1, long y2, long y3) {
        boolean cond1 = Math.min(x1, x2) <= x3 && Math.max(x1, x2) >= x3;
        boolean cond2 = Math.min(y1, y2) <= y3 && Math.max(y1, y2) >= y3;
        return cond1 && cond2;
    }

    static long CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        return (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);
    }
}