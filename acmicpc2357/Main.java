package acmicpc2357;

import java.io.*;
import java.util.*;

/* 최솟값과 최댓값
 * https://www.acmicpc.net/problem/2357
 * 최소값과 최대값  기준으로 세그값트 트리를 구성.
 * query를 받아서 구간의 최소값과 최대값을 출력.
 */

public class Main {
    static int[] minTree, maxTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answerSB = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int len = getLen(N) * 2;
        minTree = new int[len];
        maxTree = new int[len];
        int dataStartIndex = len / 2;
        Arrays.fill(minTree, Integer.MAX_VALUE);
        for (int i = dataStartIndex; i < dataStartIndex + N; i++) {
            int num = Integer.parseInt(bf.readLine());
            maxTree[i] = minTree[i] = num;
        }
        for (int i = len - 1; i >= 0; i -= 2) {
            minTree[i / 2] = Math.min(minTree[i], minTree[i - 1]);
            maxTree[i / 2] = Math.max(maxTree[i], maxTree[i - 1]);
        }

        // System.out.println(Arrays.toString(minTree));
        // System.out.println(Arrays.toString(maxTree));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1 + dataStartIndex;
            int end = Integer.parseInt(st.nextToken()) - 1 + dataStartIndex;
            answerSB.append(getMin(start, end)).append(" ").append(getMax(start, end)).append("\n");
        }

        System.out.print(answerSB);
    }

    private static int getMin(int s, int e) {
        int min = Integer.MAX_VALUE;
        while (s <= e) {
            if (s % 2 == 1) {
                min = Math.min(min, minTree[s]);
            }
            if (e % 2 == 0) {
                min = Math.min(min, minTree[e]);
            }
            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }
        return min;
    }

    private static int getMax(int s, int e) {
        int max = 0;
        while (s <= e) {
            if (s % 2 == 1) {
                max = Math.max(max, maxTree[s]);
            }
            if (e % 2 == 0) {
                max = Math.max(max, maxTree[e]);
            }
            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }
        return max;
    }

    public static int getLen(int input) {
        int output = 1;
        while (output < input) {
            output *= 2;
        }
        return output;
    }
}
