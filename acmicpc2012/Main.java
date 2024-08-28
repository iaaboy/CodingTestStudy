package acmicpc2012;

import java.io.*;
import java.util.*;

/* 등수 매기기
 * https://www.acmicpc.net/problem/2012
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        long diffSum = 0;
        for (int i = 0; i < N; i++) {
            diffSum += Math.abs(arr[i] - (i + 1));
        }
        System.out.println(diffSum);
    }
}
