package acmicpc32530;

import java.io.*;
import java.util.Arrays;

/* 래환이의 택시 타기 대작전
 * https://www.acmicpc.net/problem/32530
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Integer[] times = new Integer[N];
        for (int i = 0; i < N; i++) {
            String[] t = bf.readLine().split(":");
            times[i] = 60 * Integer.parseInt(t[0]) + Integer.parseInt(t[1]);
        }
        Arrays.sort(times, (a,b) -> b-a);


        int taxiCount = 0;
        int start = -1;
        int rideCount = 0;
        for (int i = 0; i < times.length; i++) {
            if (start == -1) {
                start = times[i];
                taxiCount++;
                rideCount = 1;
            } else if (start - times[i] > 20) {
                start = times[i];
                taxiCount++;
                rideCount = 1;
            } else {
                rideCount++;
                if (rideCount == 3) {
                    start = -1;
                    rideCount = 0;
                }
            }
        }

        System.out.println(taxiCount);
    }
}
