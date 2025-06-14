package acmicpc15565;

import java.io.*;
import java.util.*;

/* 귀여운 라이언
 * https://www.acmicpc.net/problem/15565
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) == 1;
        }
        int left = 0;
        int right = 0;
        int count = arr[0] ? 1 : 0;
        int minCount = Integer.MAX_VALUE;
        while (right <= N) {
            if (count >= K) {
                if (arr[left]) {
                    count--;
                }
                left++;
            } else {
                right++;
                if (right == N) {
                    break;
                }
                if (arr[right]) {
                    count++;
                }
            }
            if (count >= K) {
                minCount = Math.min(minCount, right - left + 1);
            }
            // System.out.println(left + "," + right + " : " + count);
        }
        if (minCount == Integer.MAX_VALUE) {
            minCount = -1;
        }
        System.out.println(minCount);
    }
}
