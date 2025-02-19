package acmicpc2493;

import java.io.*;
import java.util.*;

/* 탑
 * https://www.acmicpc.net/problem/2493
 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        for (int i = N; i >= 1; i--) {
            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                arr[s.pop()] = i;
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            arr[s.pop()] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}