package acmicpc13333;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> b - a);
        int qIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            qIdx = Math.max(Math.min(i + 1, arr[i]), qIdx);
        }
        System.out.println(qIdx);
    }
}
