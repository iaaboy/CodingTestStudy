package acmic27496;

import java.io.*;
import java.util.*;

/* 발머의 피크 이론
 * https://www.acmicpc.net/problem/27496
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            sum -= i - L < 0 ? 0 : arr[i - L];
            if (sum >= 129 && sum <= 138) {
                count++;
            }
        }
        System.out.println(count);
    }
}
