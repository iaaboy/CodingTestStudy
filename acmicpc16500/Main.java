package acmicpc16500;

import java.io.*;
import java.util.Arrays;

/* 문자열 판별
 * https://www.acmicpc.net/problem/16500
 */

public class Main {
    static char[] comparer;
    static char[][] words;
    static int end, N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        comparer = bf.readLine().toCharArray();
        N = Integer.parseInt(bf.readLine());
        words = new char[N][N];
        for (int i = 0; i < N; i++) {
            words[i] = bf.readLine().toCharArray();
        }
        end = comparer.length;
        int [] isPossible = new int[comparer.length + 1];
        isPossible[0] = 1;
        for (int i = 0; i < comparer.length; i++) {
            for (int wordIndex = 0; wordIndex < N; wordIndex++) {
                if (isPossible[i] == 1 && isMatch(wordIndex, i)) {
                    isPossible[i + words[wordIndex].length] = 1;
                }
            }
        }
        // System.out.println(Arrays.toString(isPossible));
        System.out.println(isPossible[comparer.length]);
    }

    private static boolean isMatch(int wordNumber, int comparerIndex) {
        for (int cs = 0; cs < words[wordNumber].length; cs++) {
            if (comparerIndex + cs >= comparer.length) {
                return false;
            }
            if (words[wordNumber][cs] != comparer[comparerIndex + cs]) {
                return false;
            }
        }
        return true;
    }
}

/*
softwarecontest
2
software
contest1

alleysoftwarecontest
3
software
alley
contest
 */