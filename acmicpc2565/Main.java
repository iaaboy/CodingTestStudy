package acmicpc2565;

import java.io.*;
import java.util.*;

/* 전깃줄
 * https://www.acmicpc.net/problem/2565
왼쪽 기준으로 정렬하고, 오른쪽 기준으로 LIS를 구한다.
*아이디어를 떠올리지 않으면 매우 어려운 문제.
 */

public class Main {
    static boolean[] remove;
    static int N;
    static int[] a, b;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        a = new int[N];
        b = new int[N];
        Integer[] index = new Integer[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            index[i] = i;
        }
        Arrays.sort(index, (p, q) -> a[p] - a[q]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = b[index[i]];
        }
        // System.out.println(Arrays.toString(arr));

        int[] count = new int[N];
        for (int me = 1; me < N; me++) {
            for (int j = 0; j < me; j++) {
                // 나보다 작은 수중에 count 제일 큰수를 골라서 count + 1
                if (arr[me] > arr[j]) {
                    count[me] = Math.max(count[me], count[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        System.out.println(N - (max + 1));
    }

}
