package acmicpc1476;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int E = Integer.parseInt(st.nextToken()) - 1; // 15
        int S = Integer.parseInt(st.nextToken()) - 1; // 28
        int M = Integer.parseInt(st.nextToken()) - 1; // 19

        final int MAX = 10000000;
        for (int i = 0; i < MAX; i++) {
            if (i % 15 == E && i % 28 == S && i % 19 == M) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
