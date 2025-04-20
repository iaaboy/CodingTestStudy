package acmicpc33705;

import java.io.*;
import java.util.*;

/* 마스코트 정하기
 * https://www.acmicpc.net/problem/33705
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int oneCount = 0;
        int[] accumulSum = new int[N];
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                oneCount++;
            }
            accumulSum[i] = oneCount;
        }
        int workCount = 0;
        if (oneCount >= (N / 2 + N % 2)) {

        } else {
            boolean canSwipeOne = false;
            for (int i = 0; i < N; i++) {
                // 0 ~ i
                int left = 0;
                int right = i;
                int sum = accumulSum[right];
                int leftOne = oneCount - sum;
                if (leftOne != 0) {
                    int leftCount = accumulSum.length - (right + 1);
                    if (leftOne >= leftCount / 2 + leftCount % 2) {
                        canSwipeOne = true;
                        break;
                    }
                }

                // i ~ N
                left = i;
                right = N - 1;
                sum = accumulSum[right];
                if (left != 0) {
                    sum -= accumulSum[left - 1];
                }
                leftOne = oneCount - sum;
                if (leftOne != 0) {
                    int leftCount = accumulSum.length - (right - left + 1);
                    if (leftOne >= leftCount / 2 + leftCount % 2) {
                        canSwipeOne = true;
                        break;
                    }
                }

            }
            if (canSwipeOne) {
                workCount = 1;
            } else {
                workCount = 2;
            }
        }
        System.out.println(workCount);
    }
}
