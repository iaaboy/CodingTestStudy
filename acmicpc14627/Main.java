package acmicpc14627;

import java.io.*;
import java.util.*;

/* 파닭파닭
 * https://www.acmicpc.net/problem/14627
 * 이분탐색
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] go = new long[S];
        long total = 0;

        for (int i = 0; i < S; i++) {
            go[i] = Long.parseLong(bf.readLine());
            total += go[i];
        }

        long min = 1;
        long max = (long) 1e9;
        long result = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < go.length; i++) {
                if (go[i] >= mid) {
                    sum += go[i] / mid;
                }
            }

            if (sum >= C) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(total - result * C);
    }
}
