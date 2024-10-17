package acmicpc32205;

import java.io.*;
import java.util.*;

/* 네모의 꿈
 * https://www.acmicpc.net/problem/32205
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> numSet = new HashSet<>();
        int N = Integer.parseInt(bf.readLine());
        boolean hasSquare = false;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (hasSquare)
                continue;
            if (numSet.contains(a) || numSet.contains(b) || numSet.contains(c)) {
                hasSquare = true;
            }
            numSet.add(a);
            numSet.add(b);
            numSet.add(c);
        }
        System.out.println(hasSquare ? "1" : "0");
    }
}
