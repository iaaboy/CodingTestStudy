package acmicpc3273;

import java.io.*;
import java.util.*;

/* 두 수의 합
 * https://www.acmicpc.net/problem/3273
정렬 후 투포인터.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int arr[] = new int[N];
        Integer index[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            index[i] = i;
        }
        int K = Integer.parseInt(bf.readLine());

        Arrays.sort(index, (a, b) -> arr[a] - arr[b]);

        // System.out.println(Arrays.toString(index));

        int count = 0;
        int left = 0;
        int right = N - 1;
        while (left < right) {
            int sum = arr[index[left]] + arr[index[right]];
            if (sum > K) {
                right--;
            } else if (sum < K) {
                left++;
            } else { // sum == K
                // System.out.println(left + ", " + right + ":" + sum);
                count++;
                left++;
            }
        }
        System.out.println(count);
    }
}
