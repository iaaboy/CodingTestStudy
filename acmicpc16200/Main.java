package acmicpc16200;

import java.io.*;
import java.util.*;

/* 해커톤
 * https://www.acmicpc.net/problem/16200
 * 정렬, 그리디
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Integer[] arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> b - a);
        int teamCount = 0;
        int members = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (members >= arr[i]) {
                members = 1;
                teamCount++;
            } else {
                members++;
            }
        }
        System.out.println(teamCount);
    }
}
