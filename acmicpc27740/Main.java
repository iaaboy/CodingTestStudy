package acmicpc27740;

import java.io.*;
import java.util.*;

/* 시프트 연산
 * https://www.acmicpc.net/problem/27740
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 2];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr[0] = 1;
        arr[N + 1] = 1;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(arr));

        int minCount = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;

        int left = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i-1] == 1) {
                left = i - 1;
            }
            if (arr[i] == 0 && arr[i+1] == 1) {
                int right = i + 1;
                int shiftLeftCount = left;
                int shiftRightCount = N + 1 - right;
                int shiftCount = Math.min(shiftLeftCount, shiftRightCount) * 2 + Math.max(shiftLeftCount, shiftRightCount);
                // System.out.println(left + "-" + right + " : " + shiftLeftCount + " " + shiftRightCount + " --> " + shiftCount);
                if (shiftCount <= minCount) {
                    minCount = shiftCount;
                    minLeft = shiftLeftCount;
                    minRight = shiftRightCount;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (minCount > N) {
            minCount = N;
            minLeft = N;
            minRight = 0;
        }
        sb.append(minCount).append("\n");
        if (minLeft < minRight) {
            for (int i = 0; i < minLeft; i++) {
                sb.append('L');
            }
            for (int i = 0; i < minCount - minLeft; i++) {
                sb.append('R');
            }
        } else {
           for (int i = 0; i < minRight; i++) {
                sb.append('R');
            }
            for (int i = 0; i < minCount - minRight; i++) {
                sb.append('L');
            } 
        }
        System.out.println(sb);
    }
}

