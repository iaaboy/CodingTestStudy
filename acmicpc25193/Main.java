package acmicpc25193;

import java.io.*;

/* 곰곰이의 식단 관리
 * https://www.acmicpc.net/problem/25193
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] foods = bf.readLine().toCharArray();
        int cCount = 0;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i] == 'C') {
                cCount++;
            }
        }
        if (cCount == 0) {
            System.out.println(cCount);
            return;
        }

        for (int i = 1; i <= foods.length; i++) {
            if (checkPossible(i, cCount, foods.length)) {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean checkPossible(int unit, int totalChichen, int length) {
        int gap = totalChichen / unit + (totalChichen % unit == 0 ? 0 : 1) - 1;
        if (length >= totalChichen + gap) {
            return true;
        } else {
            return false;
        }
    }
}
