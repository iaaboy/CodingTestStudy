package acmicpc14222;

import java.io.*;
import java.util.*;

/* 배열과 연산
 * https://www.acmicpc.net/problem/14222
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 1; i <= N; i++) {
            if (!iPossible(arr, i, K)) {
                System.out.println("0");
                return;
            }
        }
        System.out.println("1");
    }

    private static boolean iPossible(int[] arr, int target, int K) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0)
                continue;
            if (arr[j] > target) {
                break;
            }
            for (int i = 0; i < 51; i++) {
                if (arr[j] + i * K == target) {
                    arr[j] = 0;
                    return true;
                } else if (arr[j] + i * K > target) {
                    break;
                }
            }
        }
        return false;
    }
}