package acmicpc1418;

import java.io.*;
import java.util.*;

/* K-세준수
 * https://www.acmicpc.net/problem/1418
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());

        int[] s = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (s[i] == 0) {
                for (int j = i; j <= N; j += i) {
                    if (j % i == 0) {
                        s[j] = Math.max(s[j], i);
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(s));

        int ans = 0;
        for (int i = 0; i <= N; i++) {
            if (s[i] <= K) {
                ans++;
            }
        }

        System.out.println(ans - 1);
    }
}
