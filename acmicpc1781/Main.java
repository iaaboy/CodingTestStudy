package acmicpc1781;

import java.io.*;
import java.util.*;

/* 컵라면
 * https://www.acmicpc.net/problem/1781
index를 가지고, PriorityQueue 저장.
우선 dueDate이 늦은 순으로 q(dateQ)에 저장
뒤쪽 dueDate부터 앞으로 하나씩 내려오면서 할 수 있는 일들을 
PriorityQueue(ramenQ)에 우선 저장(이 때 우선 순위는 라면이 많은순)
ramenQ 에서 가장 위쪽의 하나를 poll해서 total count 에 더한다.
총합을 print.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] dueDate = new int[N];
        int[] ramen = new int[N];
        PriorityQueue<Integer> dateQ = new PriorityQueue<>((a, b) -> dueDate[b] - dueDate[a]);
        PriorityQueue<Integer> ramenQ = new PriorityQueue<>((a, b) -> ramen[b] - ramen[a]);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            dueDate[i] = Integer.parseInt(st.nextToken());
            ramen[i] = Integer.parseInt(st.nextToken());
            dateQ.add(i);
        }

        int totalRamen = 0;
        for (int today = N; today >= 1; today--) {
            while (!dateQ.isEmpty() && dueDate[dateQ.peek()] >= today) {
                ramenQ.add(dateQ.poll());
            }
            if (!ramenQ.isEmpty()) {
                totalRamen += ramen[ramenQ.poll()];
            }
        }
        System.out.println(totalRamen);
    }
}
