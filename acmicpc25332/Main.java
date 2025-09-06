package acmicpc25332;

import java.io.*;
import java.util.*;

/* 수들의 합 8
 * https://www.acmicpc.net/problem/25332
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        long [] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st1.nextToken()) - Long.parseLong(st2.nextToken());
        }
        long totalCount = 0;
        int psum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < N; i++) {
            psum += arr[i];
            if (map.containsKey(psum)) {
                totalCount += map.get(psum);
                map.put(psum, map.get(psum) + 1);
                // System.out.println(psum + " " +  totalCount);
            } else {
                map.put(psum, 1);
            }
            // System.out.println(map);
        }

        // System.out.println(mp);
        
        System.out.println(totalCount);
    }
}
