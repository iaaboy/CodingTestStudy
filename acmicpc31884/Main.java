package acmicpc31884;

import java.io.*;
import java.util.*;

/* Stacking Sticks
 * https://www.acmicpc.net/problem/31884
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int q = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (q == 1) { // 가로
                int maxY = 0;
                for (int j = x; j < x + 4; j++) {
                    if (map.containsKey(j)) {
                        maxY = Math.max(maxY, map.get(j));
                    }
                }
                for (int j = x; j < x + 4; j++) {
                    map.put(j, maxY + 1);
                }
            } else if (q == 2) {// 세로
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 4);
                } else {
                    map.put(x, 4);
                }
            } else {
                if (!map.containsKey(x)) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(map.get(x) + "\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
