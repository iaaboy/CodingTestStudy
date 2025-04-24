package acmicpc30618;

import java.io.*;
import java.util.*;

/* donstructive
 * https://www.acmicpc.net/problem/30618
애드혹에 가까움..
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        int[] arr = new int[N];
        for (int i = arr.length; i > 0; i--) {
            if (i % 2 == 0) {
                adq.addLast(i);
            } else {
                adq.addFirst(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer a : adq) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}