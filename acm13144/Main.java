package acm13144;

import java.io.*;
import java.util.*;

/* List of Unique Numbers
 * https://www.acmicpc.net/problem/13144
 */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 2];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int maxInt = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxInt = Math.max(maxInt, arr[i]);
        } 
        int l = 1;
        int r = 1;
        int[] num_cnt = new int[maxInt + 1];
        long ans = 0;
        num_cnt[arr[1]] = 1;
        while (r <= N) {
            if (num_cnt[arr[r]] == 2) {
                while (l <= r) {
                    num_cnt[arr[l++]]--;
                    if (num_cnt[arr[r]] == 1)
                        break;
                }
            }
            num_cnt[arr[++r]]++;
            ans += (long)r - l;
            // System.out.println(l + ",," + r);
            // System.out.println(Arrays.toString(num_cnt));
        }
        System.out.println(ans);
    }
}
