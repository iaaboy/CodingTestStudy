package acmicpc15970;

import java.io.*;
import java.util.*;

/* 화살표 그리기
 * https://www.acmicpc.net/problem/15970
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<Integer, ArrayList<Integer>> points = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int point = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            if (!points.containsKey(color)) {
                points.put(color, new ArrayList<>());
            }
            points.get(color).add(point);
        }
        int sum = 0;
        for (ArrayList<Integer> v : points.values()) {
            v.sort(null);
            int size = v.size();
            for (int i = 0; i < size; i++) {
                int pre = i == 0 ? 0 : v.get(i - 1);
                int post = i == size - 1 ? 0 : v.get(i + 1);
                int me = v.get(i);
                if (i == 0) {
                    sum += post - me;
                } else if (i == size - 1) {
                    sum += me - pre;
                } else {
                    sum += Math.min(me - pre, post - me);
                }

            }
        }
        System.out.println(sum);
    }
}
