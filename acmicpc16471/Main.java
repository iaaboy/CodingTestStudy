package acmicpc16471;

import java.io.*;
import java.util.*;

/* 작은 수 내기
 * https://www.acmicpc.net/problem/16471
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Integer[] me = new Integer[N];
        Integer[] you = new Integer[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            me[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            you[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(me);
        Arrays.sort(you);

        int n = (N + 1) / 2;

        // System.out.println(Arrays.toString(me));
        // System.out.println(Arrays.toString(you));

        int offset = N / 2;
        for (int i = 0; i < n; i++) {
            if (me[i] >= you[i + offset]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}
