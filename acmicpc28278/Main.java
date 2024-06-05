package acmicpc28278;

import java.io.*;
import java.util.*;

/* 스택 2
 * https://www.acmicpc.net/problem/28278
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> mStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                mStack.push(Integer.parseInt(st.nextToken()));
            } else if (q == 2) {
                sb.append((mStack.isEmpty() ? -1 : mStack.pop()) + "\n");
            } else if (q == 3) {
                sb.append(mStack.size() + "\n");
            } else if (q == 4) {
                sb.append((mStack.isEmpty() ? 1 : 0) + "\n");
            } else if (q == 5) {
                sb.append((mStack.isEmpty() ? -1 : mStack.peek()) + "\n");
            }
        }
        System.out.println(sb);
    }
}
