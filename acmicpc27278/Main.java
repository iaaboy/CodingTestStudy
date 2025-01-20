package acmicpc27278;

import java.io.*;
import java.util.*;

/* 영내순환버스
 * https://www.acmicpc.net/problem/27278
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N * 2];
        int[] preSum = new int[N * 2];
        int roundSum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i + N] = arr[i];
        }
        for (int i = 1; i < N * 2; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            int startWait = Integer.parseInt(st.nextToken());

            // int busArrival = getBusArrival(preSum, in, startWait, roundSum);

            for (int j = 0; j <= roundSum; j++) {
                int busArrival = getBusArrival(preSum, in, startWait, roundSum);
                System.out.println(busArrival);
            }

            
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(preSum));

    }

    private static int getBusArrival(int[] preSum, int in, int startWait, int roundSum) {

        return -1;
    }
}
