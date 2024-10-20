package acmicpc23284;

import java.io.*;
import java.util.*;

/* 모든 스택 수열
 * https://www.acmicpc.net/problem/23284
 */

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        boolean[] visit = new boolean[N];
        permutation(arr, visit, 0, N);
        // System.out.println("answer");
        System.out.print(sb);
    }

    static void permutation(int[] arr, boolean[] visit, int depth, int r) {
        if (depth == r) {
            // System.out.println("permu:" + checkArr(arr) + " -> " + Arrays.toString(arr));
            if (checkArr(arr)) {
                for (int i = 0; i < r; i++) {
                    sb.append(arr[i] + " ");
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < r; i++) {
            if (visit[i] == false) {
                arr[depth] = i + 1;
                visit[i] = true;
                permutation(arr, visit, depth + 1, r);
                visit[i] = false;
            }
        }
    }

    static boolean checkArr(int[] arr) {
        int curNum = 1;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == curNum) {
                curNum++;
                continue;
            }
            if (!s.empty() && s.peek() == arr[i]) {
                s.pop();
                continue;
            }
            while (arr[i] >= curNum) {
                s.push(curNum++);
            }
            if (!s.empty() && s.peek() == arr[i]) {
                s.pop();
                continue;
            } else {
                break;
            }
        }
        if (curNum == arr.length + 1 && s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
