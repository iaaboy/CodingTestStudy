package acmicpc16925;

import java.io.*;
import java.util.*;

/* 문자열 추측
 * https://www.acmicpc.net/problem/16925
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[][] inChr = new char[2 * N - 2][];
        int[] candiIndex = new int[2];
        int idx = 0;
        Integer[] sortedIndex = new Integer[2 * N - 2];
        for (int i = 0; i < 2 * N - 2; i++) {
            inChr[i] = bf.readLine().toCharArray();
            if (inChr[i].length >= N - 1) {
                candiIndex[idx++] = i;
            }
            sortedIndex[i] = i;
        }

        Arrays.sort(sortedIndex, (a, b) -> inChr[b].length - inChr[a].length);

        // System.out.println();
        // for (int i = 0; i < 2 * N - 2; i++) {
        // System.out.println(new String(inChr[sortedIndex[i]]));
        // }

        char[] candi1;
        for (int j = 0; j < 2; j++) {
            if (j == 0) {
                candi1 = mergeChars(inChr[candiIndex[0]], inChr[candiIndex[1]]);
            } else {
                candi1 = mergeChars(inChr[candiIndex[1]], inChr[candiIndex[0]]);
            }

            // System.out.println(candi1);

            char[] result = new char[2 * N - 2];
            boolean pairResult = true;
            for (int i = 0; i < 2 * N - 2; i += 2) {
                char checkP = checkFromStart(candi1, inChr[sortedIndex[i]]);
                char checkP1 = checkFromStart(candi1, inChr[sortedIndex[i + 1]]);

                char checkS = checkFromEnd(candi1, inChr[sortedIndex[i]]);
                char checkS1 = checkFromEnd(candi1, inChr[sortedIndex[i + 1]]);
                if (checkP == 'P' && checkS1 == 'S') {
                    result[sortedIndex[i]] = checkP;
                    result[sortedIndex[i + 1]] = checkS1;
                    // System.out.println((new String(inChr[sortedIndex[i]])) + ":" + checkP + " "
                    // + (new String(inChr[sortedIndex[i + 1]])) + "," + checkS1);
                } else if (checkP1 == 'P' && checkS == 'S') {
                    result[sortedIndex[i]] = checkS;
                    result[sortedIndex[i + 1]] = checkP1;
                    // System.out.println((new String(inChr[sortedIndex[i]])) + ":" + checkS + " "
                    // + (new String(inChr[sortedIndex[i + 1]])) + "," + checkP1);
                } else {
                    // should break;
                    pairResult = false;
                }
            }
            if (pairResult == true) {
                // finish
                StringBuilder sb = new StringBuilder();
                sb.append(candi1).append("\n");
                sb.append(new String(result));
                System.out.println(sb);
                return;
            }
        }
    }

    private static char checkFromEnd(char[] candi1, char[] cs) {
        int csIdx = 0;
        for (int i = candi1.length - cs.length; i < cs.length; i++) {
            if (candi1[i] != cs[csIdx++]) {
                return 'X';
            }
        }
        return 'S';
    }

    private static char checkFromStart(char[] candi1, char[] cs) {
        for (int i = 0; i < cs.length; i++) {
            if (candi1[i] != cs[i]) {
                return 'X';
            }
        }
        return 'P';
    }

    private static char[] mergeChars(char[] cs, char[] cs2) {
        char[] result = new char[cs.length + 1];
        for (int i = 0; i < cs.length; i++) {
            result[i] = cs[i];
        }
        result[cs.length] = cs2[cs2.length - 1];
        return result;
    }
}
