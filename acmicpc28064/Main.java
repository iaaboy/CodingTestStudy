package acmicpc28064;

import java.io.*;
import java.util.*;

/* 이민희진
 * https://www.acmicpc.net/problem/28064
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        char[][] n = new char[N][];
        for (int i = 0; i < N; i++) {
            n[i] = bf.readLine().toCharArray();
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (compareName(n[i], n[j])) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean compareName(char[] n1, char[] n2) {

        int cmpMax = Math.min(n2.length, n1.length);
        for (int i = 1; i <= cmpMax; i++) {
            if (cmpName(n1, n2, i) || cmpName(n2, n1, i)) {
                return true;
            }
        }
        // System.out.println("fail : " + new String(n1) + " : " + new String(n2));
        return false;
    }

    private static boolean cmpName(char[] n1, char[] n2, int cnt) {
        for (int i = 0; i < cnt; i++) {
            if (n1[i] != n2[n2.length - cnt + i]) {
                return false;
            }
        }
        return true;
    }
}
