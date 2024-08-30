package acmicpc12738;

import java.io.*;
import java.util.*;

/* 가장 긴 증가하는 부분 수열 3
 * https://www.acmicpc.net/problem/12738
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        arr[0] = num;
        int lis = 0;
        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            int low = 0;
            int high = lis;
            if (num > arr[lis]) {
                arr[++lis] = num;
            } else {
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (arr[mid] < num) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                arr[low] = num;
            }
            // System.out.println(Arrays.toString(arr));
        }
        System.out.println(lis + 1);
        // System.out.println(Arrays.toString(arr));
        br.close();
    }
}