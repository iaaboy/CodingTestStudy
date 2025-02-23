package acmicpc1644;

import java.io.*;
import java.util.*;

/* 소수의 연속합
 * https://www.acmicpc.net/problem/1644
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        // ArrayList<Integer> tNum = new ArrayList<>(List.of(1,7,8,9));
        // System.out.println(countSum(tNum, 8));

        int N = Integer.parseInt(bf.readLine());
        boolean[] eratos = new boolean[N + 1];
        for (int i = 2; i <= N / 2; i++) {
            for (int j = i * 2; j <= N; j += i) {
                if (!eratos[j]) {
                    eratos[j] = true;
                }
            }
        }
        ArrayList<Long> eratosNumbers = new ArrayList<>();

        for (int i = 2; i < eratos.length; i++) {
            if (!eratos[i]) {
                eratosNumbers.add((long)i);
            }
        }
        // System.out.println(eratosNumbers);

        int count = countSum(eratosNumbers, N);
        System.out.println(count);
    }

    static int countSum(ArrayList<Long> eratosNumbers , int N) {
        if (N == 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        long sum = eratosNumbers.get(0);
        while (left <= right) {
            if (sum == N) {
                count++;
                sum -= eratosNumbers.get(left);
                left++;
            } else if (sum < N) {
                right++;
                if (right >= eratosNumbers.size()) {
                    break;
                }
                sum += eratosNumbers.get(right);
            } else { // sum > N
                sum -= eratosNumbers.get(left);
                left++;
            }
        }
        return count;
    }
}
