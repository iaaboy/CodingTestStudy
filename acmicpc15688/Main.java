package acmicpc15688;

import java.io.*;
import java.util.*;

/* 수 정렬하기 5
 * https://www.acmicpc.net/problem/15688
 * 
단순 정렬 문제.
 */

public class Main {

    static int[] cities;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}