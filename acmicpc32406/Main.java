package acmicpc32406;

import java.io.*;
import java.util.*;

/* 의좋은 형제
 * https://www.acmicpc.net/problem/32406
 */

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int diff1 = getDiff(A, B);
        int diff2 = getDiff(B, A);

        System.out.println(Math.max(diff1, diff2));
    }

    static int getDiff(int[] A, int[] B) {
        int[] aLast = Arrays.copyOfRange(A, N - 2, N);
        int[] bLast = Arrays.copyOfRange(B, N - 2, N);

        for (int i = 0; i < N - 2; i++) {
            if (A[i] > B[i]) {
                aLast[0] += B[i];
                bLast[0] += A[i];
            } else {
                aLast[1] += B[i];
                bLast[1] += A[i];
            }
        }

        aLast[1] += bLast[0];
        bLast[1] += aLast[0];

        return Math.abs(aLast[1] - bLast[1]);
    }
}

