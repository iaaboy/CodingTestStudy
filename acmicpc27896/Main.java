package acmicpc27896;

import java.io.*;
import java.util.*;

/* 특별한 서빙 
 * https://www.acmicpc.net/problem/27896
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        long bulman = 0;
        int gaji = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int meal = Integer.parseInt(st.nextToken());
            q.add(meal);
            bulman += meal;
            while (bulman >= M) {
                gaji++;
                bulman -= (q.poll() * 2);
            }
        }
        System.out.println(gaji);
    }
}