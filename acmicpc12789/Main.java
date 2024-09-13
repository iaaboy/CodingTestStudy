package acmicpc12789;

import java.util.*;
import java.io.*;

/* 도키도키 간식드리미
 * https://www.acmicpc.net/problem/12789
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        int ticket = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == ticket) {
                ticket++;
            } else {
                if (s.isEmpty() || s.peek() != ticket) {
                    s.push(arr[i]);
                }
            }
            while (!s.isEmpty() && s.peek() == ticket) {
                s.pop();
                ticket++;
            }
        }
        System.out.println(s.size() == 0 ? "Nice" : "Sad");
    }
}