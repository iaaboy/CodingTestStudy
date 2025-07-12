package acmicpc2527;

import java.io.*;
import java.util.*;

/* 직사각형
 * https://www.acmicpc.net/problem/2527
 * 기하, 다양한 조건 분기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Square sq1 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Square sq2 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Overwap xStatus = checkXOverwrap(sq1, sq2);
            Overwap yStatus = checkYOverwrap(sq1, sq2);
            // sb.append(xStatus + "," + yStatus + " ->  ");

            //직사각형 a
            //선분 b
            //점 c
            //공통부분 없음 d

            if (xStatus == Overwap.SEPARATE || yStatus == Overwap.SEPARATE) {
                sb.append("d").append("\n");
            } else if (xStatus == Overwap.ENDPOINT_TOUCH && yStatus == Overwap.ENDPOINT_TOUCH) {
                sb.append("c").append("\n");
            } else if (xStatus == Overwap.ENDPOINT_TOUCH || yStatus == Overwap.ENDPOINT_TOUCH) {
                sb.append("b\n");
            } else {
                sb.append("a").append("\n");
            }
        }
        System.out.print(sb);
    }
    
    static enum Overwap {
        ENCLOSED, PARTIAL_OVERLAP, ENDPOINT_TOUCH, SEPARATE, ERROR
    }

    private static Overwap checkXOverwrap(Square sq1, Square sq2) {

        Square left;
        Square right;

        if (sq1.x1 > sq2.x1) {
            left = sq2;
            right = sq1;
        } else {
            left = sq1;
            right = sq2;
        }

        // 안에
        if (left.x1 <= right.x1 && left.x2 >= right.x2) {
            return Overwap.ENCLOSED;
        }

        // 부분 겹쳐
        if (left.x1 <= right.x1 && right.x1 < left.x2 && left.x2 < right.x2) {
            return Overwap.PARTIAL_OVERLAP;
        }

        // 점 겹쳐
        if (left.x2 == right.x1 && left.x2 < right.x2) {
            return Overwap.ENDPOINT_TOUCH;
        }

        // 떨어져
        if (left.x2 < right.x1 && left.x2 < right.x2) {
            return Overwap.SEPARATE;
        }

        return Overwap.ERROR;
    }

    private static Overwap checkYOverwrap(Square sq1, Square sq2) {

        Square left;
        Square right;

        if (sq1.y1 > sq2.y1) {
            left = sq2;
            right = sq1;
        } else {
            left = sq1;
            right = sq2;
        }

        // 안에
        if (left.y1 <= right.y1 && left.y2 >= right.y2) {
            return Overwap.ENCLOSED;
        }

        // 부분 겹쳐
        if (left.y1 <= right.y1 && right.y1 < left.y2 && left.y2 < right.y2) {
            return Overwap.PARTIAL_OVERLAP;
        }

        // 점 겹쳐
        if (left.y2 == right.y1 && left.y2 < right.y2) {
            return Overwap.ENDPOINT_TOUCH;
        }

        // 떨어져
        if (left.y2 < right.y1 && left.y2 < right.y2) {
            return Overwap.SEPARATE;
        }

        return Overwap.ERROR;
    }

    static class Square {
        int x1, y1, x2, y2;

        public Square(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
