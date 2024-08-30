package acmicpc14002;

import java.io.*;
import java.util.*;

/*
 * 실패
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
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
            // System.out.println(lis + ": " + Arrays.toString(arr));
        }
        System.out.println(lis + 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lis + 1; i++) {
            sb.append(arr[i] + " ");
        }
        String result = sb.substring(0, sb.length() - 1);
        System.out.println(result);
        br.close();
    }
}