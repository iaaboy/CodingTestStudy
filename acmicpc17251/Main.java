package acmicpc17251;

import java.io.*;
import java.util.*;

/* 힘 겨루기
 * https://www.acmicpc.net/problem/17251
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] leftMax = new int[N - 1];
        int curMax = arr[0];
        for (int i = 0; i < N - 1; i++) {
            curMax = Math.max(curMax, arr[i]);
            leftMax[i] = curMax;
        }
        int[] rightMax = new int[N - 1];
        curMax = arr[N - 1];
        for (int i = N - 1; i >= 1; i--) {
            curMax = Math.max(curMax, arr[i]);
            rightMax[i - 1] = curMax;
        }
        int winCount = 0;
        for (int i = 0; i < N - 1; i++) {
            if (leftMax[i] > rightMax[i]) {
                winCount++;
            } else if (leftMax[i] < rightMax[i]) {
                winCount--;
            }
        }
        if (winCount > 0) {
            System.out.println("R");
        } else if (winCount < 0) {
            System.out.println("B");
        } else {
            System.out.println("X");
        }
    }
}
