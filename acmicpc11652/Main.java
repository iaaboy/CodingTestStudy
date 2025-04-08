package acmicpc11652;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/* 카드
 * https://www.acmicpc.net/problem/11652
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<Long, Integer> numCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(bf.readLine());
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        // System.out.println(numCount);
        int maxCount = 0;
        long maxKey = Long.MIN_VALUE;
        for (Entry<Long,Integer> entrySet : numCount.entrySet()) {
            if (entrySet.getValue() > maxCount || (entrySet.getValue() == maxCount && maxKey > entrySet.getKey())) {
                maxKey = entrySet.getKey();
                maxCount = entrySet.getValue();
            }
        }
        System.out.println(maxKey);
    }
}
