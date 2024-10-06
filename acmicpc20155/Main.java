package acmicpc20155;

import java.io.*;
import java.util.*;

/* 우리 집 밑에 편의점이 있는데
 * https://www.acmicpc.net/problem/20155
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        HashMap<Integer, Integer> mallMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (!mallMap.containsKey(k)) {
                mallMap.put(k, 1);
            } else {
                mallMap.put(k, mallMap.get(k) + 1);
            }
        }
        // System.out.println(mallMap);
        int maxG = 0;
        for (Integer m : mallMap.values()) {
            maxG = Math.max(maxG, m);
        }
        System.out.println(maxG);
    }
}
