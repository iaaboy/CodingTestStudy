package acmicpc12915;

import java.io.*;
import java.util.*;

/* 대회 개최
 * https://www.acmicpc.net/problem/12915
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int e = Integer.parseInt(st.nextToken());
        int em = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int mh = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        // int count = 0;
        // for (int i = 0; i < 1000000; i++) {
        // if(!checkNum(i, e, em, m, mh, h)) {
        // break;
        // } else {
        // count++;
        // }
        // }
        // System.out.println(count - 1);

        int left = 0;
        int right = 1000000;
        int now = right / 2;
        while (left != right - 1) {
            // System.out.println(left + "," + right);
            if (checkNum(now, e, em, m, mh, h)) {
                left = now;
                now = (left + right) / 2;
            } else {
                right = now;
                now = (left + right) / 2;
            }
        }
        // System.out.println(left + "," + right);
        if (checkNum(right, e, em, m, mh, h)) {
            System.out.println(right);
        } else {
            System.out.println(left);
        }
    }

    private static boolean checkNum(int now, int e, int em, int m, int mh, int h) {
        int low = e + em;
        int mid = m;
        int high = h + mh;
        if (now > low) {
            return false;
        } else {
            if (now > e) {
                mid += Math.max(0, em - (now - e));
            } else {
                mid += em;
            }
        }

        if (now > high) {
            return false;
        } else {
            if (now > h) {
                mid += Math.max(0, mh - (now - h));
            } else {
                mid += mh;
            }
        }

        if (now > mid) {
            return false;
        } else
            return true;
    }
}
