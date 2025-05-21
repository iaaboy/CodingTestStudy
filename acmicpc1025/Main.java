package acmicpc1025;

import java.io.*;
import java.util.*;

/* 제곱수 찾기
 * https://www.acmicpc.net/problem/1025
 * 완전탐색
 */

public class Main {
    static int[][] nums;
    static int N, M;
    static HashSet<Integer> numSet;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N][M];
        for (int i = 0; i < N; i++) {
            int j = 0;
            for (char c : bf.readLine().toCharArray()) {
                nums[i][j++] = c - '0';
            }
        }
        numSet = new HashSet<>();
        int[][] dir = {
                { 1, 1 },
                { 1, -1 },
                { -1, 1 },
                { -1, -1 },
        };
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int a = 0; a < N; a++) {
                    for (int b = 0; b < M; b++) {
                        if (a == 0 && b == 0) {
                            numSet.add(nums[i][j]);
                            continue;
                        }
                        for (int k = 0; k < dir.length; k++) {
                            setNum(i, j, a * dir[k][0], b * dir[k][1]);
                        }

                    }
                }
            }
        }
        int max = -1;
        for (Integer n : numSet) {
            if (Math.sqrt(n) % 1 == 0) {
                max = Math.max(max, n);
                // System.out.println(n);
            }
        }
        // System.out.println(numSet);
        System.out.println(max);
    }

    static void setNum(int y, int x, int a, int b) {
        int count = 1;
        int result = nums[y][x];
        numSet.add(result);
        
        // if (y == 1 && x == 2) {
        //     System.out.println(y + "," + x + " .. " + a + "," + b);
        // }
        while (true) {
            y += a;
            x += b;
            
            if (y < 0 || x < 0 || y >= N || x >= M) {
                break;
            }
            result *= 10;
            result += nums[y][x];
            numSet.add(result);
            count++;
        }
    }
}
