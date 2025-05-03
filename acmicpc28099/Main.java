package acmicpc28099;

import java.io.*;
import java.util.*;

/* 이상한 배열
 * https://www.acmicpc.net/problem/28099
 * 세그먼트 트리를 이용하여 특정 구간의 최대값을 구한다.
 * 같은 값이 나올 경우 해당 구간내 최대값을 구하고, 현재 위치(같은값) 보다 큰 경우가 있으면 이상한 배열이 아님.
 */

public class Main {
    static int[] tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answerSB = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            int len = getLen(N) * 2;
            tree = new int[len];
            int idx = len / 2;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = idx; i < idx + N; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = len - 1; i >= 0; i -= 2) {
                tree[i / 2] = Math.max(tree[i], tree[i - 1]);
            }

            // System.out.println(Arrays.toString(tree));
            // System.out.println(getMax(idx + 0, idx + 3));
            HashMap <Integer,Integer> lastIdx = new HashMap<>();
            String result = "Yes\n";
            for (int i = idx; i < idx + N; i++) {
                if (lastIdx.containsKey(tree[i])) {
                    int start = lastIdx.get(tree[i]);
                    int end = i;
                    // System.out.println("check: " + start + "," + end + " : " + tree[i] + " vs "+ getMax(lastIdx.get(tree[i]), i));
                    if (tree[i] < getMax(start, end)) {
                        // System.out.println("Wrong");
                        result = "No\n";
                    }
                }
                lastIdx.put(tree[i], i);
            }
            answerSB.append(result);
        }
        System.out.print(answerSB);
    }

    private static int getMax(int s, int e) {
        int max = 0;
        while (s <= e) {
            if (s % 2 == 1) {
                max = Math.max(max, tree[s]);
            }
            if (e % 2 == 0) {
                max = Math.max(max, tree[e]);
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
