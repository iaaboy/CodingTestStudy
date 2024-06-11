package acmicpc21318;

import java.io.*;
import java.util.*;

/* 피아노 체조
 * https://www.acmicpc.net/problem/21318
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int count = 0;
        int prevVal = Integer.parseInt(st.nextToken());
        int [] diff = new int[N];
        for (int i = 1; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(prevVal > input) {
                count++;
            }
            diff[i] = count;
            prevVal = input;
        }
        int Q = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append((diff[to - 1] - diff[from - 1]) + "\n");
        }
        System.out.print(sb );
    }
}
