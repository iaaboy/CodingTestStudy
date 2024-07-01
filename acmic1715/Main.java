package acmic1715;

import java.io.*;
import java.util.*;

/* 카드 정렬하기
 * https://www.acmicpc.net/problem/1715
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pQ.add(Integer.parseInt(bf.readLine()));
        }
        int sum = 0;
        while (pQ.size() > 1) {
            int num = pQ.poll() + pQ.poll();
            sum += num;
            pQ.add(num);
        }
        System.out.println(sum);
    }
}
