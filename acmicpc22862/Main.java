package acmicpc22862;

import java.io.*;
import java.util.*;

/* 가장 긴 짝수 연속한 부분 수열 (large)
 * https://www.acmicpc.net/problem/22862
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int oddCount = arr[0] % 2 != 0 ? 1 : 0;
        int maxLen = arr[0] % 2 == 0 ? 1 : 0;
        while (r < n) {
            if (oddCount <= k) {
                r++;
                if (arr[r] % 2 != 0) {
                    oddCount++;
                    // System.out.println(l + " - " + r + " : " + oddCount);
                }
            } else {
                if (arr[l] % 2 != 0) {
                    oddCount--;
                    // System.out.println(l + " - " + r + " : " + oddCount);
                }
                l++;
            }
            if (oddCount <= k && r < n) {
                // System.out.println(l + " --- " + r + " : " + oddCount); 
                maxLen = Math.max(maxLen, r - l + 1 - oddCount);
            }
        }
        System.out.println(maxLen);
    }
}
