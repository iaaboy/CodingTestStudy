package acmicpc1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* 가운데를 말해요
 * https://www.acmicpc.net/problem/1655
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        PriorityQueue<Integer> high = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> low = new PriorityQueue<>((a, b) -> b - a);

        StringBuilder sb = new StringBuilder();

        int mid = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(buf.readLine());
            if (low.isEmpty() || high.isEmpty()) {
                low.add(num);
            } else if (num > high.peek()) {
                high.add(num);
            } else {
                low.add(num);
            }
            if (low.size() > high.size() + 1) {
                // move low to high
                high.add(low.poll());
            } else if (high.size() > low.size()) {
                // move high to low
                low.add(high.poll());
            }
            // System.out.println(low.peek() + " : " + low + "," + high);
            sb.append(low.peek() + "\n");
        }
        System.out.println(sb);

        buf.close();
    }
}