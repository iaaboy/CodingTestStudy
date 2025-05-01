package acmicpc2042;

import java.io.*;
import java.util.*;

/* 구간 합 구하기
 * https://www.acmicpc.net/problem/2042
 * 세그먼트트리
 */

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int tH = getTHeight(N);
        // System.out.println(Arrays.toString(tInfo));

        int treeSize = (int) Math.pow(2, tH + 1);
        int leafStartIndex = treeSize / 2;
        tree = new long[treeSize];
        for (int i = leafStartIndex; i < leafStartIndex + N; i++) {
            tree[i] = Long.parseLong(bf.readLine());
        }
        setTree(treeSize - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(bf.readLine());
            long a = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if (a == 1) { // 데이터 변경
                changeVal((int)(leafStartIndex + s - 1), e);
            } else { // 구간합 구하기
                long sum = getSum((int)(leafStartIndex + s - 1), (int)(leafStartIndex + e - 1));
                sb.append(sum).append("\n");
            }
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
