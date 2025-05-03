package acmicpc10868;

import java.io.*;
import java.util.*;

/* 최솟값
 * https://www.acmicpc.net/problem/10868
 * 최소값 기준으로 세그먼트 트리를 구성.
 * query를 받아서 구간의 최소값을 출력.
 */

public class Main {
    static int[] tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answerSB = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int len = getLen(N) * 2;
        tree = new int[len];
        int dataStartIndex = len / 2;
        Arrays.fill(tree, Integer.MAX_VALUE);
        for (int i = dataStartIndex; i < dataStartIndex + N; i++) {
            tree[i] = Integer.parseInt(bf.readLine());
        }
        for (int i = len - 1; i >= 0; i -= 2) {
            tree[i / 2] = Math.min(tree[i], tree[i - 1]);
        }

        // System.out.println(Arrays.toString(tree));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1 + dataStartIndex;
            int end = Integer.parseInt(st.nextToken()) - 1 + dataStartIndex;
            answerSB.append(getMin(start, end)).append("\n");
        }

        System.out.print(answerSB);
    }

    private static int getMin(int s, int e) {
        int min = Integer.MAX_VALUE;
        while (s <= e) {
            if (s % 2 == 1) {
                min = Math.min(min, tree[s]);
            }
            if (e % 2 == 0) {
                min = Math.min(min, tree[e]);
            }
            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }
        return min;
    }

    public static int getLen(int input) {
        int output = 1;
        while (output < input) {
            output *= 2;
        }
        return output;
    }
}
