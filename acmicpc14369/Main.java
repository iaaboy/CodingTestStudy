package acmicpc14369;

import java.io.*;
import java.util.*;

/* 전화번호 수수께끼 (Small)
 * https://www.acmicpc.net/problem/14369
 */

public class Main {
    static int[][] countMap;
    static StringBuilder sb;
    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        String[] numbers = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
        countMap = new int[10][26];

        for (int i = 0; i < numbers.length; i++) {
            char[] numChar = numbers[i].toCharArray();
            for (int j = 0; j < numChar.length; j++) {
                countMap[i][numChar[j] - 'A']++;
            }
        }

        // for (int i = 0; i < countMap.length; i++) {
        // System.out.println(Arrays.toString(countMap[i]));
        // }

        sb = new StringBuilder();

        for (count = 0; count < N; count++) {
            int[] countSpel = new int[26];
            char[] numCh = bf.readLine().toCharArray();
            for (int j = 0; j < numCh.length; j++) {
                countSpel[numCh[j] - 'A']++;
            }
            isClear = false;
            checkNumber(countSpel, "");
        }
        System.out.println(sb);
    }

    static String[] nn = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    static boolean isClear = false;

    private static void checkNumber(int[] spelCount, String result) {
        if (isClear) {
            return;
        }
        // checkAll zero
        boolean isAllZero = true;
        for (int i = 0; i < spelCount.length; i++) {
            if (spelCount[i] != 0) {
                isAllZero = false;
                break;
            }
        }
        if (isAllZero) {
            // System.err.println("AllZero" + result);
            isClear = true;
            sb.append("Case #" + (count + 1) + ": " + result + "\n");
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (checkPossible(spelCount, countMap[i])) {
                int[] spelCountNext = spelCount.clone();
                for (int j = 0; j < spelCountNext.length; j++) {
                    spelCountNext[j] -= countMap[i][j];
                }
                checkNumber(spelCountNext, result + nn[i]);
            }
        }
    }

    private static boolean checkPossible(int[] spelCount, int[] compSpel) {
        for (int i = 0; i < 26; i++) {
            if (spelCount[i] < compSpel[i]) {
                return false;
            }
        }
        return true;
    }
}