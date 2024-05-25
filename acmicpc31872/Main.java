package acmicpc31872;

import java.io.*;
import java.util.*;

/* 강의실
 * https://www.acmicpc.net/problem/31872
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] gap = new int[N];
        gap[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gap[i] = arr[i] - arr[i - 1];
        }
        Arrays.sort(gap);
        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += gap[i];
        }
        System.out.println(sum);
    }
}
