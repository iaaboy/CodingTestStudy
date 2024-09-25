package acmicpc20437;

import java.io.*;
import java.util.*;

/* 문자열 게임 2
 * https://www.acmicpc.net/problem/20437
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            HashMap<Character, Deque<Integer>> map = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                char ch = 'a';
                ch += i;
                map.put(ch, new LinkedList<>());
            }
            char[] w = bf.readLine().toCharArray();
            int K = Integer.parseInt(bf.readLine());
            int maxLen = -1;
            int minLen = Integer.MAX_VALUE;
            for (int i = 0; i < w.length; i++) {
                char ch = w[i];
                Deque<Integer> q = map.get(ch);
                q.add(i);
                if (q.size() >= K) {
                    int length = q.peekLast() - q.pollFirst() + 1;
                    maxLen = Math.max(maxLen, length);
                    minLen = Math.min(minLen, length);
                    // System.out.println(ch + "," + i + ":" + length);
                }
            }
            if (maxLen != -1) {
                sb.append(minLen).append(" ").append(maxLen).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }
        System.out.print(sb);
    }
}
