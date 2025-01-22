package acmicpc20922;

import java.io.*;
import java.util.*;

/* 겹치는 건 싫어
 * https://www.acmicpc.net/problem/20922
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(bf.readLine());
        int maxN = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxN = Math.max(maxN, arr[i]);
        }
        int[] cnt = new int[maxN + 1];
        int l = 0, r = 0;
        int length = 1;
        cnt[arr[0]]++;
        while (r < N) {
            if (l == r) {
                r++;
                cnt[arr[r]]++;
            } else if (cnt[arr[r]] > K) {
                cnt[arr[l]]--;
                l++;
            } else { // cnt[arr[r]] <= K
                r++;
                int idx = arr[r];
                cnt[idx]++;
            }
            length = Math.max(length, r - l);
            // System.out.println(l + " .. " + r);
            // System.out.println(Arrays.toString(cnt));
        }
        System.out.println(length);
    }
}
