package acmicpc11066;

import java.io.*;
import java.util.*;

/* 파일 합치기
 * https://www.acmicpc.net/problem/11066
 */

public class Main {
    static int[] arr;
    static Num[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            arr = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            memo = new Num[K][K];
            Num sum = getTotalCost(0,K - 1, 0);
            sb.append(sum.cost).append("\n");
        }
        System.out.print(sb);
    }
    private static Num getTotalCost(int start, int end , int depth) {
        Num min;
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        if (end - start == 1) {
            min = new Num(arr[start] + arr[end], arr[start] + arr[end]);
        } else if (end == start) {
            min = new Num(arr[start], 0);
        } else {
            min = new Num(0, Integer.MAX_VALUE);
            for (int mid = start; mid < end; mid++) {
                Num a = getTotalCost(start, mid, depth + 1);
                Num b = getTotalCost(mid + 1, end, depth + 1);
                
                if (a.cost + b.cost + a.sum + b.sum < min.cost) {
                    min.cost = a.cost + b.cost + a.sum + b.sum;
                    min.sum = a.sum + b.sum;
                }
                // if (depth == 0) {
                //     System.out.println(start + " " + mid + " " + end + ": " + a + " , " + b);
                // }
            }
        }
        // if (depth == 0) {
        //     System.out.println(start + " " + end + " : " + min);
        // }
        
        if (memo[start][end] == null) {
            memo[start][end] = min;
        }

        return min;
    }
    static class Num {
        int sum;
        int cost;
        public Num(int sum, int cost) {
            this.sum = sum;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return sum + "(" + cost + ")";
        }
    }
}

/*
1
4
40 30 30 50
 */