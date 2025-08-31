package acmicpc34094;

import java.io.*;
import java.util.*;

/* 골드리치의 비밀 금고
 * https://www.acmicpc.net/problem/34094
 */

public class Main {
    static int maxNum = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, arr[i]);
        }
        maxNum++;

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        if (arr[N - 1] == 0) {
            sb.append("0\n");
        } else {
            int x = 0;
            for (int e : arr) {
                if (e == x)
                    x++;
            }
            sb.append(x + 1).append("\n");
        }
        for (int a : arr) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
