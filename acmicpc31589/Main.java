package acmicpc31589;

import java.io.*;
import java.util.*;

/* 포도주 시음
 * https://www.acmicpc.net/problem/31589
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] wines = new int[N];
        for (int i = 0; i < N; i++) {
            wines[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wines);
        int left = 0;
        int right = N - 1;
        int curLevel = 0;
        long result = 0;
        for (int i = 0; i < K; i++) {
            if (i % 2 == 0) {
                result += wines[right] - curLevel;
                right--;
            } else {
                curLevel = wines[left];
                left++;
            }
        }
        System.out.println(result);
    }
}
