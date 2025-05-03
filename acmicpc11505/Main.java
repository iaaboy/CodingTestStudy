package acmicpc11505;

import java.io.*;
import java.util.*;

/* 구간 곱 구하기
 * https://www.acmicpc.net/problem/11505
 * 세그먼트 트리 
 */

public class Main {
    static long[] tree;
    static long MODBASE = 1000000007L;
    // static StringBuilder debugsb2 = new StringBuilder();

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
        Arrays.fill(tree, 1);
        for (int i = leafStartIndex; i < leafStartIndex + N; i++) {
            tree[i] = Long.parseLong(bf.readLine());
        }
        setTree(treeSize - 1);

        StringBuilder sb = new StringBuilder();
        // StringBuilder debugsb = new StringBuilder();
        // debugsb.append(Arrays.toString(tree) + "\n");
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(bf.readLine());
            long a = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if (a == 1) { // 데이터 변경
                changeVal((int) (leafStartIndex + s - 1), e);
                // debugsb.append(Arrays.toString(tree) + "\n");
            } else { // 구간곱 구하기
                long sum = getSum((int) (leafStartIndex + s - 1), (int) (leafStartIndex + e - 1));
                sb.append(sum).append("\n");
            }
        }
        System.out.print(sb);

        // System.out.println(Arrays.toString(tree));
        // System.out.print(debugsb);
        // System.out.print(debugsb2);
    }

    private static long getSum(int s, int e) {
        long partSum = 1;
        while (s <= e) {
            if (s % 2 == 1) {
                partSum = ((partSum % MODBASE) * (tree[s] % MODBASE)) % MODBASE;
                // debugsb2.append(tree[s] + "(" + s + ") ");
            }
            if (e % 2 == 0) {
                partSum = ((partSum % MODBASE) * (tree[e] % MODBASE)) % MODBASE;
                // debugsb2.append(tree[e] + "(" + e + ") ");
            }
            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }
        // debugsb2.append("\n");
        return partSum;
    }

    private static void changeVal(int i, long val) {
        tree[i] = val;
        while (i >= 1) {
            if (i % 2 == 0) { // i가 짝수
                tree[i / 2] = (tree[i] % MODBASE) * (tree[i + 1] % MODBASE);
            } else { // i가 홀수
                tree[i / 2] = (tree[i] % MODBASE) * (tree[i - 1] % MODBASE);
            }
            tree[i / 2] %= MODBASE;
            i /= 2;
        }
        return;
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] = ((tree[i / 2] % MODBASE) * (tree[i] % MODBASE)) % MODBASE;
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
