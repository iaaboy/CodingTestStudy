package acmicpc6549;

import java.io.*;
import java.util.*;

/* 히스토그램에서 가장 큰 직사각형
 * https://www.acmicpc.net/problem/6549
1725와 풀이법 동일
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            long[] arr = new long[N + 2];
            for (int i = 1; i <= N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            long maxWidth = 0;
            for (int i = 1; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) { // 나보다 큰애까지 pop.
                    long height = arr[stack.pop()];
                    long width = i - stack.peek() - 1;
                    // System.out.println(i + "," + height + "*" + width);
                    // System.out.println(stack.peek() + ":" +stack);
                    width *= height;
                    maxWidth = Math.max(maxWidth, width);
                }
                stack.add(i);
                // System.out.println(stack);
            }

            System.out.println(maxWidth);
        }
    }
}
