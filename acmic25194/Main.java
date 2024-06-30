package acmic25194;

import java.io.*;
import java.util.*;

/* 결전의 금요일
 * https://www.acmicpc.net/problem/25194
 */

public class Main {
    static int[] pos;
    static boolean ans;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        pos = new int[7];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a % 7 != 0)
                pos[a % 7]++;
        }
        backTrack(0);
        if (ans)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    static void backTrack(int val) {
        if (ans)
            return;
        if (val % 7 == 4) {
            ans = true;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            if (pos[i] != 0) {
                pos[i]--;
                backTrack(val + i);
                pos[i]++;
            }
        }
    }
}
