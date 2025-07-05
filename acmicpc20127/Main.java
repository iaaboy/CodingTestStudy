package acmicpc20127;

import java.io.*;
import java.util.*;

/* Y-수열
 * https://www.acmicpc.net/problem/20127
 * 애드혹
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

        int incCount = 0;
        int incIndex = 0;
        int decCount = 0;
        int decIndex = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i - 1]) {
                incCount++;
                incIndex = i;
            }
            if (arr[i] > arr[i - 1]) {
                decCount++;
                decIndex = i;
            }
        }
        // System.out.println(incCount + "혹" + decIndex);
        int result = Integer.MAX_VALUE;
        if (incCount == 0 || decCount == 0) {
            result = 0;
        }
        if (incCount == 1 && arr[0] >= arr[N - 1]) {
            result = Math.min(incIndex, result);
        }
        if (decCount == 1 && arr[0] <= arr[N - 1]) {
            result = Math.min(result, decIndex);
        }
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }
}
