package acmicpc2118;

import java.io.*;
import java.util.*;

/* 두 개의 탑 
 * https://www.acmicpc.net/problem/2118
 * 투포인터
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 17);
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int left = 0;
        int right = 1;
        int sumL = arr[0];
        int sumR = sum - arr[0];
        int answer = 0;
        while (left < n && left != right) {
            answer = Math.max(answer, Math.min(sumL, sumR));
            if (sumL > sumR) {
                sumL -= arr[left];
                sumR += arr[left];
                left++;
            } else {
                sumL += arr[right];
                sumR -= arr[right];
                right++;
                right %= n;
            }
        }
        System.out.println(answer);
    }
}
