package acmicpc7795;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] arrA = new int[A + 2];
            arrA[A + 1] = 30000;
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < A; i++) {
                arrA[i + 1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            int aWin = 0;
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < B; i++) {
                int b = Integer.parseInt(st.nextToken());
                aWin = A - getLowerBound(arrA, b);
            }
            sb.append(aWin + "\n");
        }
        System.out.println(sb);
    }

    private static int getLowerBound(int[] arr, int b) {
        int left = 0;
        int right = arr.length - 1;
        int center = 0;
        while (true) {
            center = (left + right) / 2;
            if (arr[center] <= b) {
                left = center;
            } else {
                right = center;
            }
            if (arr[center] < b && arr[center + 1] >= b) {
                return center;
            }
        }
    }
}
