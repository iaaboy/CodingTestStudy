package acmicpc5175;

import java.io.*;
import java.util.*;

/* 문제없는 문제
 * https://www.acmicpc.net/problem/5175
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder debugSb = new StringBuilder();
        int TestIndex = 1;
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int mMask = 0;
            mMask = getMask(M);
            int[] issues = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                int issueMask = 0;
                while (st.hasMoreTokens()) {
                    issueMask |= 1 << (Integer.parseInt(st.nextToken()) - 1);
                }
                issues[i] = issueMask;
            }
            int loopMax = getMask(N);
            int minBitCount = Integer.MAX_VALUE;
            int chosenIndex = 0;
            for (int i = 0; i <= loopMax; i++) {
                int mask = 0;
                int bitCount = 0;
                for (int bit = 0; bit < N; bit++) {
                    if ((i & 1 << bit) > 0) {
                        bitCount++;
                        mask |= issues[bit];
                    }
                }
                if (mask == mMask && minBitCount > bitCount) {
                    minBitCount = bitCount;
                    chosenIndex = i;
                    // System.out.println("Hit: " + Integer.toBinaryString(mask) + ".." + Integer.toBinaryString(i) + " , "
                    //         + bitCount);
                }
            }
            int bitMask = 1;
            debugSb.append("Data Set " + TestIndex++ +":");
            for (int i = 0; i < N; i++) {
                if ((chosenIndex & bitMask << i) > 0) {
                    debugSb.append(" " + (char)('A' + i));
                }
            }
            debugSb.append("\n\n");
        }
        System.out.print(debugSb);
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
