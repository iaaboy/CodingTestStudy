package acmicpc30022;

import java.io.*;
import java.util.*;

/* 행사 준비
 * https://www.acmicpc.net/problem/30022
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int arr[][] = new int[2][N];
        Integer idx[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> ((arr[0][a] - arr[1][a]) - (arr[0][b] - arr[1][b])));
        int i = 0;
        long sum = 0;
        for (; i < A; i++) {
            sum += (long)arr[0][idx[i]];
        }
        for (; i < N; i++) {
            sum += (long)arr[1][idx[i]];
        }

        System.out.println(sum);
    }
}
