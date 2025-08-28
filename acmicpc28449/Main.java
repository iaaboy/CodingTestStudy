package acmicpc28449;

import java.io.*;
import java.util.*;

/* 누가 이길까
 * https://www.acmicpc.net/problem/28449
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] arr2 = new int[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr2);
        long winSum = 0;
        long loseSum = 0;
        long drawSum = 0;
        for (int i = 0; i < N; i++) {
            int win = myUnderBound(arr2, arr[i]) + 1;
            winSum += win;
            int lose = arr2.length - upperBound(arr2, arr[i]);
            loseSum += lose;
            int draw = arr2.length - lose - win;
            drawSum += draw;
            // int lower = lowerBound(arr, arr[i]);
            // System.out.println(arr[i] + ":" + win +"/" + lose +"/" + draw);
        }
        System.out.println(winSum + " " + loseSum + " " + drawSum);
    }

    private static int myUnderBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int center = (left + right) / 2;
            // if (b[arr[center]] < key) {
            if (arr[center] < key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return right - 1;
    }

    private static int upperBound(int[] arr, int key) { // 특정 target보다 큰 첫번째 원소의 인덱스
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int center = (left + right) / 2;
            if (arr[center] <= key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return left;
    }
}