package acmicpc2910;

import java.io.*;
import java.util.*;

/* 빈도 정렬
 * https://www.acmicpc.net/problem/2910
 */

public class Main {
    static HashMap<Integer, Integer> frequencyCount = new HashMap<>();
    static HashMap<Integer, Integer> minIndex = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            frequencyCount.put(arr[i], frequencyCount.getOrDefault(arr[i], 0) + 1);
            if (!minIndex.containsKey(arr[i])) {
                minIndex.put(arr[i], i);
            }
        }
        Arrays.sort(arr, (a, b) -> {
            if (frequencyCount.get(b) == frequencyCount.get(a)) {
                return minIndex.get(a) - minIndex.get(b);
            } else {
                return frequencyCount.get(b) - frequencyCount.get(a);
            }
        });
        // System.out.println(frequencyCount);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
