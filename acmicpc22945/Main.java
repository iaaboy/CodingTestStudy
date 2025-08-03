package acmicpc22945;

import java.io.*;
import java.util.*;

/* 팀빌딩
 * https://www.acmicpc.net/problem/22945
 * 애드혹 같은 이분탐색
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
        int left = 0;
        int right = N - 1;
        int maxVal = 0;
        int count = 0;
        while (left + 1 != right) {
            count = right - left - 1;
            maxVal = Math.max(maxVal, count * Math.min(arr[left], arr[right]));
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(maxVal);
    }
}
