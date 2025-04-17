package acmicpc31246;

import java.io.*;
import java.util.*;

/* 모바일 광고 입찰
 * https://www.acmicpc.net/problem/31246
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] diff = new Integer[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            diff[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
        }
        Arrays.sort(diff, Collections.reverseOrder());
        int price = (diff[K - 1] > 0)? 0 : -diff[K - 1];
        System.out.println(price);
    }
}
