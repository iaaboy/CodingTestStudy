package acmicpc11054;

import java.io.*;
import java.util.*;

/* 가장 긴 바이토닉 부분 수열
 * https://www.acmicpc.net/problem/11054
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        int[] countLtoR = new int[N];
        int[] lengthRtoL = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int me = 0; me < N; me++) {
            for (int j = me; j >= 0; j--) {
                if (arr[me] > arr[j]) {
                    countLtoR[me] = Math.max(countLtoR[me], countLtoR[j] + 1);
                }
            }
        }
        for (int me = N; me >= 0; me--) {
            for (int j = me; j < N; j++) {
                if (arr[me] > arr[j]) {
                    lengthRtoL[me] = Math.max(lengthRtoL[me], lengthRtoL[j] + 1);
                }
            }
        }

        // System.out.println(Arrays.toString(countLtoR));
        // System.out.println(Arrays.toString(lengthRtoL));
        int countMax = 0;
        for (int i = 0; i < N; i++) {
            countMax = Math.max(countMax, countLtoR[i] + lengthRtoL[i]);
        }
        System.out.println(countMax + 1);
    }
}