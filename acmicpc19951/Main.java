package acmicpc19951;

import java.io.*;
import java.util.*;

/* 태상이의 훈련소 생활
 * https://www.acmicpc.net/problem/19951
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Integer N = Integer.parseInt(st.nextToken());
        Integer M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] calcAccumul = new int[N + 2];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dig = Integer.parseInt(st.nextToken());
            calcAccumul[begin] += dig;
            calcAccumul[end + 1] -= dig;
        }
        // System.out.println(Arrays.toString(calcAccumul));
        int curSum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            curSum += calcAccumul[i];
            calcAccumul[i] = curSum;
            arr[i] += calcAccumul[i];
            sb.append(arr[i] + " ");
        }
        // System.out.println(Arrays.toString(calcAccumul));
        System.out.println(sb);
    }
}
