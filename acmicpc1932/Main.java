package acmicpc1932;

import java.io.*;
import java.util.*;

/* 정수 삼각형
 * https://www.acmicpc.net/problem/1932
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 1];
        // StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int tmp = 0;
            int j = 1;
            for (; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                int saved = tmp;
                tmp = num + Math.max(arr[j], arr[j - 1]);
                arr[j - 1] = saved;
            }
            arr[j - 1] = tmp;
            // sb.append(i + ":" + Arrays.toString(arr)).append("\n");
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
        // System.out.print(sb);
    }
}