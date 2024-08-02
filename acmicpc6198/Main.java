package acmicpc6198;

import java.io.*;

/* 옥상 정원 꾸미기
 * https://www.acmicpc.net/problem/6198
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int[] count = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    count[i]++;
                } else {
                    break;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum+=count[i];
        }
        System.out.println(sum);
    }
}
