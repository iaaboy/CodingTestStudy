package acmicpc2212;

import java.io.*;
import java.util.*;

/* 센서
 * https://www.acmicpc.net/problem/2212
 */

 /*
구간을 나눈다 > 구간 사이 갭을 제거한다.
1. 센서들이 직선위에 있게 되므로 우선 센서 위치값들을 정렬
2. 정렬한 각 센서 사이 gap을 구한다.
3. gap을 높 -> 낮 순서로 정렬한다.
3. 높은것부터 K-1개를 제거한다 ( == 구간을 분리한다.)
  */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Integer[] gap = new Integer[N - 1];
        for (int i = 1; i < N; i++) {
            gap[i - 1] = arr[i] - arr[i - 1];
        }
        Arrays.sort(gap, (a, b) -> b - a);
        // System.out.println(Arrays.toString(gap));
        long sum = 0;
        for (int i = K - 1; i < N - 1; i++) {
            sum += (long) gap[i];
        }
        System.out.println(sum);
    }
}
