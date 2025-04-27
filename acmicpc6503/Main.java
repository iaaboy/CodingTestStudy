package acmicpc6503;

import java.io.*;
import java.util.HashMap;

/* 망가진 키보드
 * https://www.acmicpc.net/problem/6503
 * 
 * 투포인터로 가장 긴 "연속하는" 부분 문자열을 counting
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (T != 0) {
            char[] c = bf.readLine().toCharArray();
            HashMap<Character, Integer> chMap = new HashMap<>();
            int left = 0;
            int right = 0;
            int kbdCount = 1;
            int max = 0;
            chMap.put(c[left], 1);
            while (right < c.length - 1) {
                if (kbdCount <= T) {
                    right++;
                    chMap.put(c[right], chMap.getOrDefault(c[right], 0) + 1);
                    if (chMap.get(c[right]) == 1) {
                        kbdCount++;
                    }
                } else {
                    chMap.put(c[left], chMap.get(c[left]) - 1);
                    if (chMap.get(c[left]) == 0) {
                        kbdCount--;
                    }
                    left++;
                }
                if (kbdCount <= T) {
                    // System.out.println(kbdCount + " | " + (right - left + 1) + " : " + chMap);
                    max = Math.max(max, (right - left + 1));
                }
            }
            sb.append(max).append("\n");
            T = Integer.parseInt(bf.readLine());
        }
        System.out.print(sb);
    }
}
