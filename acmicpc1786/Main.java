package acmicpc1786;

import java.io.*;
import java.util.*;

/* 찾기
 * https://www.acmicpc.net/problem/1786
KMP 알고리즘
 */

public class Main {
    static int[] pi;
    static ArrayList<Integer> matchIndex = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] P = bf.readLine().toCharArray();
        char[] T = bf.readLine().toCharArray();

        setPi(T);

        int j = 0;
        for (int i = 0; i < P.length; i++) {
            while (j > 0 && P[i] != T[j]) {
                j = pi[j - 1];
            }
            if (P[i] == T[j]) {
                if (j == T.length - 1) {
                    matchIndex.add(i - T.length + 1 + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(matchIndex.size()).append("\n");
        for (Integer matchIndex : matchIndex) {
            sb.append(matchIndex).append(" ");
        }
        System.out.println(sb);

    }

    static void setPi(char[] t) {
        pi = new int[t.length];
        int j = 0;
        for (int i = 1; i < t.length; i++) {
            while (j > 0 && t[i] != t[j]) {
                j = pi[j - 1];
            }
            if (t[i] == t[j]) {
                pi[i] = ++j;
            }
        }
    }
}
