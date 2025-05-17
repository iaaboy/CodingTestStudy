package acmicpc13270;

import java.io.*;
import java.util.*;

/* 피보나치 치킨
 * https://www.acmicpc.net/problem/13270
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int curNum = 2;
        int preNum = 1;
        int temp = 0;
        ArrayList<int []> ck = new ArrayList<>();
        while (curNum <= N) {
            ck.add(new int[] {preNum, curNum});
            temp = curNum;
            curNum += preNum;
            preNum = temp;
        }
        int [] dpMin = new int[N + 1];
        int [] dpMax = new int[N + 1];
        Arrays.fill(dpMin, Integer.MAX_VALUE / 3);
        dpMin[0] = 0;
        for (int i = 0; i <= N; i++) {
            for (int[] c : ck) {
                if (i - c[1] >= 0) {
                    dpMin[i] = Math.min(dpMin[i - c[1]] + c[0], dpMin[i]);
                    dpMax[i] = Math.max(dpMax[i - c[1]] + c[0], dpMax[i]);
                }
            }
        }
        System.out.println(dpMin[N] + " " + dpMax[N]);
        // System.out.println(Arrays.toString(dpMin));
        // System.out.println(Arrays.toString(dpMax));
    }
}
