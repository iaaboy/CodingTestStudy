package acmicpc33677;

import java.io.*;
import java.util.*;

/* 푸앙이와 콩나무
 * https://www.acmicpc.net/problem/33677
콩나무 길이를 index로하고, 
date 혹은 water(물준 회수) 값이 갱신될때 Queue에 넣고, 최소값을 계속 업데이트함.
1000,000값을 넣었을때, len * len overflow주의
dp
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        if (N == 0) {
            System.out.println("0 0");
            return;
        }
        int[] date = new int[N + 1];
        int[] water = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            date[i] = Integer.MAX_VALUE;
            water[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> q = new ArrayDeque<>();
        // 최소 일수, 최소 물의양
        q.add(1);
        date[1] = 1;
        water[1] = 1;
        while (!q.isEmpty()) {
            int len = q.poll();
            // System.out.println(len + ":");
            // System.out.println(Arrays.toString(date));
            // System.out.println(Arrays.toString(water));
            int[] nD = { date[len] + 1, date[len] + 1, date[len] + 1 };
            int[] nW = { water[len] + 1, water[len] + 3, water[len] + 5 };
            int[] nL = { len + 1, len * 3, len * len };
            for (int i = 0; i < 3; i++) {
                boolean isHit = false;
                if (nL[i] > N || nL[i] < 0) {
                    continue;
                }
                if (date[nL[i]] > nD[i]) {
                    date[nL[i]] = nD[i];
                    water[nL[i]] = nW[i];
                    isHit = true;
                } else if (date[nL[i]] == nD[i] && water[nL[i]] > nW[i]) {
                    date[nL[i]] = nD[i];
                    water[nL[i]] = nW[i];
                    isHit = true;
                }
                if (isHit) {
                    q.add(nL[i]);
                }
            }
        }
        System.out.println(date[N] + " " + water[N]);
    }
}
