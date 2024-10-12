package acmicpc23848;

import java.io.*;
import java.util.*;

/* 콘센트
 * https://www.acmicpc.net/problem/23843
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            pq.add(0);
        }
        int time = 0;
        for (int i = N - 1; i >= 0; i--) {
            int pop = pq.poll(); // 남은 시간이 적은 순으로 pop, 남아 있는 아이템중에 남은 시간이 많은 순으로 push
            time = pop + arr[i];
            System.out.println(pop + "," + arr[i] + " : " + time);
            pq.add(time);
        }
        while (!pq.isEmpty()) {
            time = pq.poll();
        }

        System.out.println(time);// 마지막 남은 시간을 print
    }
}
