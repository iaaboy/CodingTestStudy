package acmicpc1918;

import java.io.*;
import java.util.*;

/* 후위 표기식
 * https://www.acmicpc.net/problem/1918
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] eq = bf.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < eq.length; i++) {
            int p = proirity(eq[i]);
            if (isOp(eq[i])) {
                while (!stack.isEmpty() && proirity(stack.peek()) >= p) {
                    sb.append(stack.pop());
                }
                stack.push(eq[i]);
            } else if (eq[i] == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else if (eq[i] == '(') {
                stack.push(eq[i]);
            } else { // operand
                sb.append(eq[i]);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    private static boolean isOp(char ch) {
        return ch == '/' || ch == '*' || ch == '+' || ch == '-';
    }

    static int proirity(char ch) {
        if (ch == '/' || ch == '*') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 0;
        }
    }
}