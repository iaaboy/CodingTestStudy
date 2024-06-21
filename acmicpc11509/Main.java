package acmicpc11509;

import java.io.*;
import java.util.*;
/* 풍선 맞추기
 * https://www.acmicpc.net/problem/11509
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashMap<Integer, Integer> arrows = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (arrows.containsKey(num)) {
                // 지금 숫자 빼고
                if (arrows.get(num) == 1) {
                    arrows.remove(num);
                } else {
                    arrows.put(num, arrows.get(num) - 1);
                }

            }
            // 다음 숫자 +1
            num--;
            if (!arrows.containsKey(num)) {
                arrows.put(num, 1);
            } else {
                arrows.put(num, arrows.get(num) + 1);
            }
        }
        int sum = 0;
        for (Integer count : arrows.values()) {
            sum += count;
        }
        // System.out.println(arrows);
        System.out.println(sum);
    }
}