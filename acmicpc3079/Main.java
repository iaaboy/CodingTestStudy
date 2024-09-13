package acmicpc3079;

import java.io.*;
import java.util.*;

/* 입국심사
 * https://www.acmicpc.net/problem/3079
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(bf.readLine());
        }

        // 총시간이 M 보다 크거나 같은 (upperbound)
        long left = 0;
        long right = Long.MAX_VALUE / 3;
        long total = 0;
        while (left < right) {
            long center = (left + right) / 2;
            total = 0;
            for (int i = 0; i < arr.length; i++) {
                total += center / arr[i];
                if(total > M)
                    break;
            }

            if (total >= M) {
                right = center;
            } else {
                left = center+1;
            }
        }
        System.out.println(right);
    }
}