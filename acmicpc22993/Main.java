package acmicpc22993;

import java.io.*;
import java.util.*;

/* 서든어택 3
 * https://www.acmicpc.net/problem/22993
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Integer[] arr = new Integer[N - 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long me = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (me > arr[i]) {
                me += arr[i];
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}