package acmicpc14891;

import java.io.*;
import java.util.*;

/* 톱니바퀴
 * https://www.acmicpc.net/problem/14891
 * 구현!!
 */

public class Main {
    static char[][] nuts;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        nuts = new char[4][8];
        for (int i = 0; i < 4; i++) {
            nuts[i] = bf.readLine().toCharArray();
        }

        int K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1;
            boolean watchDirection = Integer.parseInt(st.nextToken()) == 1;
            rotate(number, watchDirection, true, true);
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (nuts[i][0] == '1') {
                sum += Math.pow(2, i);
            }
        }
        System.out.println(sum);
    }

    private static void rotate(int number, boolean watchDirection, boolean checkLeft, boolean checkRight) {
        // System.out.println(
        //         "rotate: " + number + (watchDirection ? " watch " : " reverse ") + checkLeft + "," + checkRight);

        // 2. check left
        boolean leftRotate = false;
        if (checkLeft && number > 0) {
            int idxMe = 6;
            int idxLeft = 2;
            if (nuts[number][idxMe] != nuts[number - 1][idxLeft]) {
                leftRotate = true;
            }
        }
        // 2-1 check right
        boolean rightRotate = false;
        if (checkRight && number < 3) {
            int idxMe = 2;
            int idxRight = 6;
            if (nuts[number][idxMe] != nuts[number + 1][idxRight]) {
                rightRotate = true;

            }
        }

        // 1. rotate me
        if (watchDirection) {
            char temp = nuts[number][7];
            for (int i = 7; i > 0; i--) {
                nuts[number][i] = nuts[number][i - 1];
            }
            nuts[number][0] = temp;
        } else {
            char temp = nuts[number][0];
            for (int i = 0; i < 7; i++) {
                nuts[number][i] = nuts[number][i + 1];
            }
            nuts[number][7] = temp;
        }

        if (leftRotate) {
            rotate(number - 1, !watchDirection, true, false);
        }
        if (rightRotate) {
            rotate(number + 1, !watchDirection, false, true);
        }
    }
}
