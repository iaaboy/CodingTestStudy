package acmicpc32403;

import java.io.*;
import java.util.*;

/* 전구 주기 맞추기
 * https://www.acmicpc.net/problem/32403
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        Set <Integer> modNums = new HashSet<>();
        for (int i = 2; i <= T / 2; i++) {
            if (T % i == 0) {
                modNums.add(i);
            }
        }
        modNums.add(1);
        modNums.add(T);
        // System.out.println(modNums);
        st = new StringTokenizer(bf.readLine());
        long totalMod = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int minMod = Integer.MAX_VALUE;
            for (Integer n : modNums) {
                int mod = Math.min(Math.abs(num - n), Math.abs(n - num));
                minMod = Math.min(minMod, mod);
            }
            totalMod += minMod;
        }
        
        System.out.println(totalMod);
    }
}
