package acmicpc15661;

import java.io.*;
import java.util.*;

/* 링크와 스타트
 * https://www.acmicpc.net/problem/15661
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] team = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int loopMax = getMask(N);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < loopMax; i++) {
            int sumA = 0;
            int sumB = 0;
            for (int bitA = 0; bitA < N; bitA++) {
                int maskA = (i & (1 << bitA));
                for (int bitB = 0; bitB < N; bitB++) {
                    if (bitA == bitB)
                        continue;
                    int maskB = (i & (1 << bitB));
                    if (maskA > 0 && maskB > 0) {
                        sumA += team[bitA][bitB];
                    } else if (maskA == 0 && maskB == 0) {
                        sumB += team[bitA][bitB];
                    }
                }
            }
            // System.out.println(Integer.toBinaryString(i) + ": " + sumA + " , " + sumB);
            if (minDiff > Math.abs(sumA - sumB)) {
                minDiff = Math.abs(sumA - sumB);
                // System.out.println(" -> update minDiff " + minDiff);
            }
        }
        System.out.println(minDiff);
    }

    private static int getMask(int M) {
        int mMask = 0;
        while (M > 0) {
            mMask |= 1 << M - 1;
            M--;
        }
        return mMask;
    }
}
