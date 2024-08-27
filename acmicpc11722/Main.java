package acmicpc11722;

import java.io.*;
import java.util.*;

/* 가장 긴 감소하는 부분 수열
 * https://www.acmicpc.net/problem/11722
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] count = new int[N];
        for (int me = 1; me < N; me++) {
            for (int j = 0; j < me; j++) {
                // 나보다 작은 수중에 count 제일 큰수를 골라서 count + 1
                if (arr[me] < arr[j]) {
                    count[me] = Math.max(count[me], count[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        System.out.println(max + 1);
        // System.out.println(Arrays.toString(count));
    }
}