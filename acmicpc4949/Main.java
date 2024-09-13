package acmicpc4949;

import java.io.*;
import java.util.*;

/* 균형잡힌 세상
 * https://www.acmicpc.net/problem/4949
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            char[] arr = bf.readLine().toCharArray();
            if (arr.length == 1 && arr[0] == '.') {
                break;
            }
            Stack<Character> brace = new Stack<>();
            boolean balanced = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(') {
                    brace.add(arr[i]);
                } else if (arr[i] == ')') {
                    if (brace.isEmpty() || brace.peek() != '(') {
                        // no
                        balanced = false;
                        break;
                    } else {
                        brace.pop();
                    }
                }
                if (arr[i] == '[') {
                    brace.add(arr[i]);
                } else if (arr[i] == ']') {
                    if (brace.isEmpty() || brace.peek() != '[') {
                        // no
                        balanced = false;
                        break;
                    } else {
                        brace.pop();
                    }
                }
            }
            if (!brace.isEmpty()) {
                balanced = false;
            }
            sb.append(balanced ? "yes\n" : "no\n");
        }
        System.out.print(sb);
    }
}