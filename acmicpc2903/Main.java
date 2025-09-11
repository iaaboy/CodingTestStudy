package acmicpc2903;

import java.io.*;

/* 중앙 이동 알고리즘
 * https://www.acmicpc.net/problem/2903
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bf.readLine());
        long verticalSquare = 1;
        while (N > 1) {
            verticalSquare *= 2;
            N--;
        }
        verticalSquare++;
        long pointCount = verticalSquare * verticalSquare;
        System.out.println(pointCount);
    }
}
