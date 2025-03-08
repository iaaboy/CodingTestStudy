package acmicpc1725;

import java.io.*;
import java.util.*;

/* 히스토그램
 * https://www.acmicpc.net/problem/1725
모노톤 스택 활용
나보다 큰애까지 Pop
가장 앞의 index, ~ 나 .. 넓이
높이는 지금 stack위치
둘이 곱해서 넓이를 구하고, 최대값 업데이트.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int maxWidth = 0;
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) { // 나보다 큰애까지 pop.
                int height = arr[stack.pop()];
                int width = i - stack.peek() - 1;
                // System.out.println(i + "," + height + "*" + width);
                // System.out.println(stack.peek() + ":" +stack);
                maxWidth = Math.max(maxWidth, height * width);
            }
            stack.add(i);
            // System.out.println(stack);
        }

        System.out.println(maxWidth);
    }
}