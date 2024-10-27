package acmicpc1149;

import java.io.*;
import java.util.StringTokenizer;

/* RGB거리
 * https://www.acmicpc.net/problem/1149
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] sum = new int[3];
        for (int i = 0; i < N; i++) {
            int[] arr = new int[3];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken()) + Math.min(sum[(j + 1) % 3], sum[(j + 2) % 3]);
            }
            sum = arr;
        }
        int answer = Math.min(sum[0], Math.min(sum[1], sum[2]));
        System.out.println(answer);
    }
}
