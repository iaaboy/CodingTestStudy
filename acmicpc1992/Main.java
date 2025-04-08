package acmicpc1992;

import java.io.*;
import java.util.*;

/* 쿼드트리
 * https://www.acmicpc.net/problem/1992
재귀.
 */

public class Main {
    static char [][] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        String result = getQuad(0,0,N);
        System.out.println(result);
    }

    private static String getQuad(int y, int x, int n) {
        if (n == 1) {
            return Character.toString(arr[y][x]);
        }
        int offset = n / 2;
        String q1 = getQuad(y, x, n / 2);
        String q2 = getQuad(y, x + offset, n / 2);
        String q3 = getQuad(y + offset, x, n / 2);
        String q4 = getQuad(y + offset, x + offset, n / 2);
        if (q1.contentEquals("1") && q2.contentEquals("1") && q3.contentEquals("1") && q4.contentEquals("1")) {
            return "1";
        } else if (q1.contentEquals("0") && q2.contentEquals("0") && q3.contentEquals("0") && q4.contentEquals("0")) {
            return "0";
        } else {
            return "(" + q1 + q2 + q3 + q4 + ")";
        }
    }
}

/*
8
00000000
00000000
00001111
00001111
00011111
00111111
00111111
00111111

(0(0011)(0(0111)01)1)
*/