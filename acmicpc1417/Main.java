package acmicpc1417;

import java.io.*;
import java.util.*;

/* 국회의원 선거
 * https://www.acmicpc.net/problem/1417
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int me = Integer.parseInt(bf.readLine());
        int updated = me;
        for (int t = 1; t < T; t++) {
            pq.add(Integer.parseInt(bf.readLine()));
        }
        while (!pq.isEmpty() && updated <= pq.peek()) {
            updated++;
            int c = pq.poll() - 1;
            pq.add(c);
        }
        System.out.println(updated - me);
    }
}
