package acmicpc1874;

import java.io.*;
import java.util.*;

/* 스택 수열
 * https://www.acmicpc.net/problem/1874
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int curNum = 1;
        Stack<Integer> s = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        for (int i = 0; i < N; i++) {
            if (arr[i] == curNum) {
                sb.append("+").append("\n");
                sb.append("-").append("\n");
                curNum++;
                continue;
            }
            if (!s.empty() && s.peek() == arr[i]) {
                sb.append("-").append("\n");
                s.pop();
                continue;
            }
            while (arr[i] >= curNum) {
                sb.append("+").append("\n");
                s.push(curNum++);
            }
            if (!s.empty() && s.peek() == arr[i]) {
                sb.append("-").append("\n");
                s.pop();
                continue;
            } else {
                break;
            }
        }
        if (curNum == N + 1 && s.isEmpty()) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}