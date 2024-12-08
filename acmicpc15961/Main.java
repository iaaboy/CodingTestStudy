package acmicpc15961;

import java.io.*;
import java.util.*;

/* 회전 초밥
 * https://www.acmicpc.net/problem/2531
 * https://www.acmicpc.net/problem/15961
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 개수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가지수
        int K = Integer.parseInt(st.nextToken()); // 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        int[] tray = new int[N + K];
        int[] myBowl = new int[d + 1];
        for (int i = 0; i < N; i++) {
            tray[i] = Integer.parseInt(bf.readLine());
        }
        for (int i = N; i < N + K; i++) {
            tray[i] = tray[i - N];
        }
        int curCount = 0;
        int maxDish = 0;
        for (int i = 0; i < N + K; i++) {
            // i를 handle ++
            if (myBowl[tray[i]] == 0) {
                curCount++;
            }
            myBowl[tray[i]]++;
            // i - K를 handle --
            if (i - K >= 0) {
                myBowl[tray[i - K]]--;
                if (myBowl[tray[i - K]] == 0) {
                    curCount--;
                }
            }
            if (myBowl[c] == 0) {
                // System.out.println(curCount + 1);
                maxDish = Math.max(maxDish, curCount + 1);
            } else {
                // System.out.println(curCount);
                maxDish = Math.max(maxDish, curCount);
            }
        }

        System.out.println(maxDish);
    }
}
