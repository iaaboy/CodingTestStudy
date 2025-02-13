package acmicpc28116;

import java.io.*;
import java.util.*;

/* 선택 정렬의 이동 거리
 * https://www.acmicpc.net/problem/28116
 */

public class Main {
    static int arr[];
    static int index[];
    static int count[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N + 1];
        index = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            index[arr[i]] = i;
        }
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            swap(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < count.length; i++) {
            sb.append(count[i]).append(" ");
        }
        System.out.println(sb);
        // System.out.println(Arrays.toString(arr));
    }

    private static void swap(int me) {
        int tempVal = arr[me];
        if (me == tempVal) {
            return;
        }
        int tempIdx = index[me];
        count[me] += Math.abs(tempIdx - me);
        count[tempVal] += Math.abs(tempIdx - me);
        // value update
        arr[me] = me;
        index[me] = me;
        arr[tempIdx] = tempVal;
        index[tempVal] = tempIdx;
        // index update of temp
        // System.out.println(Arrays.toString(arr));
    }
}