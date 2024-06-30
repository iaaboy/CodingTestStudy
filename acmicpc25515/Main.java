package acmicpc25515;

import java.io.*;
import java.util.*;

public class Main {
    static int[] left;
    static int[] right;
    static int[] val;
    static int target;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        left = new int[N];
        right = new int[N];
        val = new int[N];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (left[p] == -1) {
                left[p] = c;
            } else {
                right[p] = c;
            }
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }
        visitNext(0, 0);
    }

    private static void visitNext(int cur, int depth) {
        if (val[cur] == target) {
            System.out.println(depth);
            return;
        }
        if (left[cur] >= 0) {
            visitNext(left[cur], depth + 1);
        }
        if (right[cur] >= 0) {
            visitNext(right[cur], depth + 1);
        }
    }
}
