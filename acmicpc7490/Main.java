package acmicpc7490;

import java.io.*;
import java.util.*;

/* 
 * https://www.acmicpc.net/problem/21275
 */

public class Main {
    static int[] arr;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            count = Integer.parseInt(bf.readLine());
            solve(count);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void solve(int num) {
        int[] idx = new int[num - 1];
        bf(idx, 0);
    }

    private static void bf(int[] idx, int depth) {
        if (depth == idx.length) {
            // System.out.println(Arrays.toString(idx));
            calc(idx);
            return;
        }
        idx[depth] = 0;
        bf(idx, depth + 1);
        idx[depth] = 1;
        bf(idx, depth + 1);
        idx[depth] = 2;
        bf(idx, depth + 1);
    }

    private static void calc(int[] idx) {
        char[] sentence = new char[idx.length + idx.length + 1];
        int num = 1;

        for (int i = 0; i < idx.length * 2; i += 2) {
            sentence[i] = '0';
            sentence[i] += num;
            sentence[i + 1] = idx[i / 2] == 0 ? ' ' : (idx[i / 2] == 1 ? '+' : '-');
            num++;
        }
        sentence[idx.length + idx.length] = '0';
        sentence[idx.length + idx.length] += num;

        // System.out.println(Arrays.toString(sentence));

        Stack<Character> op = new Stack<>();
        Stack<Integer> number = new Stack<>();

        int digit = 1;
        for (int i = sentence.length - 1; i >= 0; i--) {
            if (sentence[i] == ' ') {
                digit *= 10;
            } else if (sentence[i] == '+' || sentence[i] == '-') {
                op.push(sentence[i]);
                digit = 1;
            } else { // number
                int n = sentence[i] - '0';
                if (digit != 1) {
                    number.push(n * digit + number.pop());
                } else {
                    number.push(n);
                }
            }
        }

        // System.out.println(op);
        // System.out.println(number);

        while (!op.isEmpty()) {
            int n1 = number.pop();
            int n2 = number.pop();
            char o = op.pop();
            if (o == '+') {
                number.push(n1 + n2);
            } else {
                number.push(n1 - n2);
            }
        }
        // System.out.println("result : " + number.peek());
        if (number.peek() == 0) {
            sb.append(String.valueOf(sentence) + "\n");
        }
    }
}