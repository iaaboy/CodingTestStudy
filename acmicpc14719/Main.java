package acmicpc14719;

import java.io.*;
import java.util.*;

/* 빗물
 * https://www.acmicpc.net/problem/14719
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int filledSum = 0;
        int nextTower;
        for (int i = 0; i < arr.length - 2;) {
            if (arr[i] > arr[i + 1]) {
                nextTower = getNextTower(arr, i);
                if (nextTower != -1) {
                    filledSum += fillArr(arr, i, nextTower);
                } else {
                    nextTower = i + 1;
                }
            } else {
                nextTower = i + 1;
            }
            i = nextTower;
        }
        int prevTower;
        for (int i = arr.length - 1; i >= 1;) {
            if (arr[i] > arr[i - 1]) {
                prevTower = getPrevTower(arr, i);
                if (prevTower != -1) {
                    filledSum += fillReverseArr(arr, i, prevTower);
                } else {
                    prevTower = i - 1;
                }
            } else {
                prevTower = i - 1;
            }
            i = prevTower;
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(filledSum);
    }

    private static int getPrevTower(int[] arr, int curIdx) {
        for (int i = curIdx - 1; i >= 0; i--) {
            if (arr[curIdx] <= arr[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int fillArr(int[] arr, int currentTower, int nextTower) {
        int filledCnt = 0;
        for (int i = currentTower + 1; i < nextTower; i++) {
            filledCnt += arr[currentTower] - arr[i];
            arr[i] = arr[currentTower];
        }
        return filledCnt;
    }

    private static int fillReverseArr(int[] arr, int currentTower, int nextTower) {
        int filledCnt = 0;
        for (int i = currentTower - 1; i > nextTower; i--) {
            filledCnt += arr[currentTower] - arr[i];
            arr[i] = arr[currentTower];
        }
        return filledCnt;
    }

    private static int getNextTower(int[] arr, int curIdx) {
        for (int i = curIdx + 1; i < arr.length; i++) {
            if (arr[curIdx] <= arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
