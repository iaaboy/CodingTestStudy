package acmicpc24508;

import java.io.*;
import java.util.*;

/* 나도리팡
 * https://www.acmicpc.net/problem/24508
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum = (sum + arr[i]) % K;
        }
        if (sum != 0) {
            System.out.println("NO");
            return;
        }
        Arrays.sort(arr);

        int l = 0;
        int r = arr.length - 1;

        while (true) {
            if (arr[l] + arr[r] < K) {
                arr[r] += arr[l];
                T -= arr[l];
                l++;
            } else if (arr[l] + arr[r] > K) {
                T -= K - arr[r];
                arr[l] = arr[l] + arr[r] - K;
                r--;
            } else { // l+r == K
                T -= arr[l];
                arr[r] = K;
                l++;
                r--;
            }
            if (T < 0) {
                System.out.println("NO");
                return;
            }
            if (l >= r) {
                System.out.println("YES");
                return;
            }
        }
    }
}
