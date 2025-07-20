package acmicpc25945;

import java.io.*;
import java.util.*;

/* 컨테이너 재배치
 * https://www.acmicpc.net/problem/25945
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int avr = (int) sum / arr.length;
        long rest = sum - avr * arr.length;
        int[] ideal = new int[N];
        for (int i = 0; i < N; i++) {
            ideal[i] = avr;
            if (i > N - rest - 1) {
                ideal[i]++;
            }
        }
        Arrays.sort(arr);

        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(ideal));

        int left = -1;
        int right = N - 1;
        for (int i = 0; i < N; i++) {
            if (left == -1 && arr[i] < ideal[i]) {
                left = i;
            }
            if (right == N - 1 && arr[i] > ideal[i]) {
                right = i;
            }
        }
        if (left == -1) {
            left = 0;
        }
        // System.out.println(left + " " + right);
        sum = 0;
        while (left != right && right < N) {
            int diffLeft = ideal[left] - arr[left];
            int diffRight = arr[right] - ideal[right];
            if (diffLeft > diffRight) {
                sum += (long)diffRight;
                arr[left] += diffRight;
                arr[right] -= diffRight;
                right++;
            } else if (diffLeft == diffRight) {
                sum += (long)diffRight;
                arr[left] += diffRight;
                arr[right] -= diffRight;
                left++;
                right++;
            } else if (diffLeft == 0) {
                left++;
            } else {
                sum += (long)diffLeft;
                arr[left] += diffLeft;
                arr[right] -= diffLeft;
                left++;
            }
            
        }
        System.out.println(sum);

        // System.out.println(Arrays.toString(arr));
    }
}
