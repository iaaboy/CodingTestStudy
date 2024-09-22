package acmicpc1003;

import java.io.*;

/* 피보나치 함수
 * https://www.acmicpc.net/problem/1003
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            max = Math.max(max, arr[i]);
        }
        FiboCount[] fCount = new FiboCount[max + 1 + 1];
        fCount[0] = new FiboCount(1, 0);
        fCount[1] = new FiboCount(0, 1);
        for (int i = 2; i <= max; i++) {
            fCount[i] = new FiboCount(fCount[i - 1].zero + fCount[i - 2].zero, fCount[i - 1].one + fCount[i - 2].one);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < N; j++) {
            sb.append(fCount[arr[j]].zero + " " + fCount[arr[j]].one + "\n");
        }
        System.out.print(sb);
    }

    static class FiboCount {
        int zero;
        int one;

        public FiboCount(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }
}
