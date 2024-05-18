package acmicpc2164;

import java.io.*;
import java.util.*;

public class MyMain {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            dq.add(i + 1);
        }

        while (dq.size() > 1) {
            // System.out.println(dq);
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }
        System.out.println(dq.poll());
    }
}
