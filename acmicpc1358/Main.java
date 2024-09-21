package acmicpc1358;

import java.io.*;
import java.util.*;

/* 하키
 * https://www.acmicpc.net/problem/1358
 */

 public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        double W = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());
        double X = Double.parseDouble(st.nextToken());
        double Y = Double.parseDouble(st.nextToken());
        double P = Double.parseDouble(st.nextToken());
        int count = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(bf.readLine());
            double pX = Double.parseDouble(st.nextToken());
            double pY = Double.parseDouble(st.nextToken());
            boolean isInside = false;
            isInside |= checkCircle(X, Y + H / 2.0, pX, pY, H / 2.0);
            isInside |= checkCircle(X + W, Y + H / 2.0, pX, pY, H / 2.0);
            isInside |= checkSqare(W, H, X, Y, pX, pY);
            if (isInside) {
                count++;
            }
        }
        System.out.println(count);
        // System.out.print(sb);
    }

    private static boolean checkSqare(double w, double h, double x, double y, double pX, double pY) {
        return (x <= pX && pX <= x + w) && (y <= pY && pY <= y + h);
    }

    private static boolean checkCircle(double x, double y, double pX, double pY, double r) {
        double xSq = (x - pX) * (x - pX);
        double ySq = (y - pY) * (y - pY);
        double hSq = r;
        return hSq >= Math.sqrt(xSq + ySq);
    }
}
