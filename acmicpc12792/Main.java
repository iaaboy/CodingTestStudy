package acmicpc12792;

import java.io.*;
import java.util.*;

/* 주작 주 주작
 * https://www.acmicpc.net/problem/12792
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean allOne = false;
        for (int i = 0; i < N; i++) {
            if (arr[i] != i + 1) {
                allOne = true;
                break;
            }
        }
        if (allOne) {
            System.out.println(-1);
            return;
        }
        System.out.println(1000003);
    }
}