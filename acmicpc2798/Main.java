package acmicpc2798;

import java.io.*;
import java.util.*;

/* 블랙잭
 * https://www.acmicpc.net/problem/2798
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int j2 = 0; j2 < N; j2++) {
                    if (i == j || j == j2 || i == j2) {
                        continue;
                    }
                    int sum = arr[i] + arr[j] + arr[j2];
                    if (sum <= M && max < sum) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }                       
}
