package acmicpx26260;

import java.io.*;
import java.util.*;

/*
 * https://www.acmicpc.net/problem/26260
 */

public class Main {
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        int idx = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == -1) {
                idx = i;
            }
        }
        arr[idx] = Integer.parseInt(bf.readLine());
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        int depth = getDepth(N + 1);
        printTree(N / 2, depth);
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();

    private static void printTree(int index, int depth) {
        if (depth == 0) {
            // System.out.println(arr[index]);
            return;
        } else {
            printTree(index - (int)Math.pow(2, depth - 2), depth - 1);
            printTree(index + (int)Math.pow(2, depth - 2), depth - 1);
            sb.append(arr[index]).append(" ");
        }
    }

    private static int getDepth(int n) {
        int result = 0;
        while (n > 1) {
            n /= 2;
            result++;
        }
        return result;
    }
}
