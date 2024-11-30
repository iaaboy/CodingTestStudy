package acmicpc1253;

import java.io.*;
import java.util.*;

/* 좋다
 * https://www.acmicpc.net/problem/1253
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sumPossible(arr, i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean sumPossible(int[] arr, int idx) {
        int sNum = arr[idx];
        int left = 0;
        int right = arr.length - 1;
        if (left == idx) {
            left++;
        }
        if (right == idx) {
            right--;
        }
        while (left != right) {
            int sum = arr[left] + arr[right];
            if (sum == sNum) {
                return true;
            } else if (sum < sNum) {
                left++;
            } else if (sum > sNum) {
                right--;
            }
            if (left == idx) {
                left++;
            }
            if (right == idx) {
                right--;
            }
        }
        return false;
    }
}