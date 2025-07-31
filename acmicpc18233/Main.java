package acmicpc18233;

import java.io.*;
import java.util.*;

/* 러버덕을 사랑하는 모임
 * https://www.acmicpc.net/problem/18233
 * 완전탐색  N과 P개수가 힌트
 */

public class Main {
    static int N, P, E;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        a = new int[N];
        b = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int aa = Integer.parseInt(st.nextToken());
            int bb = Integer.parseInt(st.nextToken());
            a[i] = Math.min(aa, bb);
            b[i] = Math.max(aa, bb);
        }

        int[] index = new int[N];
        if (P <= N) {
            permutation(index, 0, 0);
        }
        if (!found) {
            System.out.println(-1);
        }
    }

    static void permutation(int[] arr, int depth, int start) {
        if (depth == P) {

            int min = 0, max = 0;
            for (int i = 0; i < depth; ++i) {
                min += a[arr[i]];
                max += b[arr[i]];
            }

            if (E < min || max < E) {
                return;
            }

            makeResult(arr);
            return;
        }

        
        for (int i = start; i < N; i++) {
            if (found) {
                return;
            }
            arr[depth] = i;
            permutation(arr, depth + 1,  i + 1);
            
        }
    }

    private static void makeResult(int[] arr) {
        int[] result = new int[N];
        int e = E;
        for (int i = 0; i < P; i++) {
            int index = arr[i];
            result[index] += a[index];
            b[index] -= a[index];
            e -= a[index];
        }
        for (int i = 0; i < P; i++) {
            int index = arr[i];
            if (e <= b[index]) {
                result[index] += e;
                break;
            } else {
                result[index] += b[index];
                e -= b[index];
            }

        }
        found = true;
        // System.out.println(curMin + " " + curMax);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    static boolean found = false;
}
