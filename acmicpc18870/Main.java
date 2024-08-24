package acmicpc18870;

import java.io.*;
import java.util.*;

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
        // System.out.println(Arrays.toString(alignedIdx));
        Integer[] biggerCount = new Integer[N];

        biggerCount[alignedIdx[0]] = 0;
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
