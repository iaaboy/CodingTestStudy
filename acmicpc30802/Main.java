package acmicpc30802;

import java.io.*;
import java.util.StringTokenizer;

/* 웰컴 키트
 * https://www.acmicpc.net/problem/30802
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int [] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        int tBundle = 0;
        for (int i = 0; i < arr.length; i++) {
            tBundle += (arr[i] / T);
            tBundle += arr[i] % T == 0 ? 0 : 1;
        }
        int P = Integer.parseInt(st.nextToken());
        int penBundle = (N / P);
        int penRest = N % P;
        System.out.println(tBundle);
        System.out.println(penBundle +" " + penRest);
    }
}
