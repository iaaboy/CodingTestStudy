package acmicpc17390;

import java.io.*;
import java.util.*;

/* 이건 꼭 풀어야 해!
 * https://www.acmicpc.net/problem/17390
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arrAccumul = new int[A + 1];
        int[] arr = new int[A];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 1; i <= A; i++) {
            sum += arr[i - 1];
            arrAccumul[i] = sum;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(arrAccumul[to] - arrAccumul[from - 1] + "\n");
        }
        System.out.print(sb);
    }
}
