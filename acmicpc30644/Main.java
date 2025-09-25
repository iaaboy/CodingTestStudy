package acmicpc30644;

import java.io.*;
import java.util.*;

/* 띠 정렬하기
 * https://www.acmicpc.net/problem/30644
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        Integer[] aligned = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            aligned[i] = i;
        }
        Arrays.sort(aligned, (a, b) -> arr[a] - arr[b]);
        // System.out.println(Arrays.toString(aligned));
        int[] index = new int[N];
        for (int i = 0; i < N; i++) {
            index[aligned[i]] = i;
        }
        int groupId = 1;
        Arrays.fill(arr, 0);
        for (int i = 0; i < N - 1; i++) {
            if (index[i] == index[i + 1] + 1 || index[i] == index[i + 1] - 1) {
                if (arr[i] == 0) {
                    arr[i] = groupId++;
                    arr[i + 1] = arr[i];
                } else {
                    arr[i + 1] = arr[i];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                arr[i] = groupId++;
            }
        }
        // System.out.println(Arrays.toString(index));
        // System.out.println(Arrays.toString(arr));
        System.out.println(groupId - 2);
    }
}
