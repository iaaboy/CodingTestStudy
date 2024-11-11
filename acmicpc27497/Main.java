package acmicpc27497;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Deque<Character> dq = new ArrayDeque<>();
        Stack <Boolean> lastAdded = new Stack<>();
        for (int i = 0; i < N; i++) {
            String sentence = bf.readLine();
            int op = sentence.charAt(0) - '0';
            if (op == 1) {
                dq.addLast(sentence.charAt(2));
                lastAdded.push(true);
            } else if (op == 2) {
                dq.addFirst(sentence.charAt(2));
                lastAdded.push(false);
            } else if (op == 3) {
                if (dq.size() != 0) {
                    if (!lastAdded.pop()) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                    // System.out.println(dq);
                }
            }
        }
        if (dq.size() == 0) {
            System.out.println("0");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character dq2 : dq) {
                sb.append(dq2);
            }
            System.out.println(sb);
        }
    }
}
