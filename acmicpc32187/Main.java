package acmicpc32187;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] remained = new int[N + 1];
        long sum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int count = Integer.parseInt(st.nextToken());
            int[] remaineNext = new int[N + 1];
            for (int j = 0; j < count; j++) {
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                if (remained[index] == 0) { // 값을 취하고 저장
                    sum += value;
                    remaineNext[index] = value;
                } else if (remained[index] >= value) { // 이번 값을 버림

                } else {
                    sum += value - remained[index];
                    remaineNext[index] = value - remained[index];
                }
            }
            remained = remaineNext;
        }
        System.out.println(sum);
    }
}