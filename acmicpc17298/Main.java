package acmicpc17298;

import java.io.*;
import java.util.*;

/* 오큰수
 * https://www.acmicpc.net/problem/17298
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
        for (int i = 1; i <= N; i++) {
            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                arr[s.pop()] = arr[i];
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            arr[s.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}