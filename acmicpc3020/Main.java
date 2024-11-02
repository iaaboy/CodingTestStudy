package acmicpc3020;

import java.io.*;
import java.util.*;

/* 개똥벌레
 * https://www.acmicpc.net/problem/3020
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] arr = new int[H + 1];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (i % 2 == 0) {
                arr[0]++;
                arr[num]--;
            } else {
                arr[H - num]++;
                arr[H]--;
            }
        }
        // System.out.println(Arrays.toString(arr));
        // StringBuilder sb = new StringBuilder();
        int sum = 0;
        int minBr = Integer.MAX_VALUE;
        int minCount = 0;
        for (int i = 0; i < H; i++) {
            sum += arr[i];
            // sb.append(sum + " ");
            if (minBr > sum) {
                minBr = sum;
                minCount = 1;
            } else if (minBr == sum) {
                minCount++;
            }
        }
        // System.out.println(sb);
        System.out.println(minBr + " " + minCount);
    }
}