package acmicpc10828;

import java.io.*;
import java.util.*;

/* 스택
 *  https://www.acmicpc.net/problem/10828
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String cmd = st.nextToken();
            switch (cmd.charAt(0)) {
                case 'p':
                    if (cmd.charAt(1) == 'u') {
                        stack.push(Integer.parseInt(st.nextToken()));
                    } else { // pop
                        if (stack.isEmpty()) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(stack.pop()).append("\n");
                        }
                    }
                    break;
                case 's':
                    sb.append(stack.size()).append("\n");
                    break;
                case 'e':
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 't':
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
    }
}
