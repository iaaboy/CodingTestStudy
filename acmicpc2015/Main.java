package acmicpc2015;

import java.io.*;
import java.util.*;

/* 수들의 합 4
 * https://www.acmicpc.net/problem/2015
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        Long K = Long.parseLong(st.nextToken());
        long[] arr = new long[N];
        long sum = 0;
        long count = 0;
        st = new StringTokenizer(bf.readLine());
        HashMap<Long, Long> map = new HashMap<>();
        map.put(K, 0L);
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());
            arr[i] = sum;
            if (arr[i] == K) {
                count++;
            }
            if (map.containsKey(arr[i] - K))
                count += map.get(arr[i] - K);
            if (!map.containsKey(arr[i]))
                map.put(arr[i], 1L);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }
        System.out.println(count);
    }
}
