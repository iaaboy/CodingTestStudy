package acmicpc31673;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Integer[] v = new Integer[N];
        st = new StringTokenizer(bf.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
            sum += (long) v[i];
        }
        sum /= 2;
        Arrays.sort(v);
        int count = N - 1;
        for (; count >= 0; count--) {
            sum -= (long)v[count];
            if (sum <= 0) {
                break;
            }
        }
        // System.out.println(Arrays.toString(v));
        System.out.println(M / (count + 2));
    }
}