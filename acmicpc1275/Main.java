package acmicpc1275;

import java.io.*;
import java.util.*;

/* 커피숍2
 * https://www.acmicpc.net/problem/1275
 * 세그먼트 트리
 */

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int tH = getTHeight(N);
        // System.out.println(Arrays.toString(tInfo));

        int treeSize = (int) Math.pow(2, tH + 1);
        int leafStartIndex = treeSize / 2;
        tree = new long[treeSize];
        st = new StringTokenizer(bf.readLine());
        for (int i = leafStartIndex; i < leafStartIndex + N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
        }
        setTree(treeSize - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 구간합
            long sum = getSum((int) (leafStartIndex + Math.min(x, y) - 1), (int) (leafStartIndex + Math.max(x, y) - 1));
            sb.append(sum).append("\n");

            // 데이터 변경
            changeVal((int) (leafStartIndex + a - 1), b);
        }
        System.out.print(sb);

    // System.out.println(Arrays.toString(tree));
    }

    private static long getSum(int s, int e) {
        long partSum = 0;
        while (s <= e) {
            if (s % 2 == 1) {
                partSum += tree[s];
            }
            if (e % 2 == 0) {
                partSum += tree[e];
            }
            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }
        return partSum;
    }

    private static void changeVal(int i, long val) {
        long diff = val - tree[i];

        while (i > 0) {
            tree[i] = tree[i] + diff;
            i /= 2;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }

    private static int getTHeight(int n) {
        int h = 0;
        while (n > 0) {
            h++;
            n /= 2;
        }
        return h;
    }
}
