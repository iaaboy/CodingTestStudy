package acmicpc1021;

import java.io.*;
import java.util.*;

/* 회전하는 큐
 * https://www.acmicpc.net/problem/1021
 * ArrayDeque를 이용해서 해당 원소가 나올때까지 뺀다.
 * 원소가 나오면 이제까지 이동한 수를 count한다.
 * 반대로 빼는 경우도 고려해야하므로, (전체 사이즈 - count , count) 둘중 작은 것으로 count
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }
        // StringBuilder debugSb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        int sum = 0;
        for (int i = 0; i < M; i++) {
            Integer num = Integer.parseInt(st.nextToken());
            int count = 0;
            while (dq.peek() != num) {
                count++;
                dq.addLast(dq.pollFirst());
                ;
            }
            // debugSb.append(num + " " + (Math.min(count, dq.size() - count)) + " / ");
            sum += Math.min(count, dq.size() - count);
            dq.poll();
        }
        // System.out.println(debugSb);
        System.out.println(sum);
    }
}
