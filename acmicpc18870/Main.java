package acmicpc18870;

import java.io.*;
import java.util.*;

/* 좌표 압축
 * https://www.acmicpc.net/problem/18870
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int arr[] = new int[N];
        Integer[] alignedIdx = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            alignedIdx[i] = i;
        }
        Arrays.sort(alignedIdx, (a, b) -> arr[a] - arr[b]);
        int biggerLeft = 0;
        Integer[] biggerCount = new Integer[N];
        biggerCount[alignedIdx[0]] = biggerLeft;
        for (int i = 1; i < N; i++) {
            if (arr[alignedIdx[i]] > arr[alignedIdx[i - 1]]) {
                biggerLeft++;
            }
            biggerCount[alignedIdx[i]] = biggerLeft;
        }
        // System.out.println(Arrays.toString(biggerCount));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < biggerCount.length; i++) {
            sb.append(biggerCount[i] + " ");
        }
        System.out.println(sb);
    }
}
