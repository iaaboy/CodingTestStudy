package acmicpc30891;

import java.io.*;
import java.util.*;

/* 볶음밥 지키기
 * https://www.acmicpc.net/problem/30891
가능한 모든 좌표에 대해 계산한다.
각 좌표를 기준으로 밥알이 범위내에 있는지 count한다. 
최대인 좌표를 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] y = new int[N];
        int[] x = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int[][] count = new int[201][201];
        int maxCount = 0;
        int maxY = 0;
        int maxX = 0;
        for (int cy = -100; cy <= 100; cy++) {
            for (int cx = -100; cx <= 100; cx++) {
                for (int me = 0; me < N; me++) {
                    double sum = Math.pow(x[me] - cx, 2) + Math.pow(y[me] - cy, 2);
                    if (Math.sqrt(sum) <= R) {
                        count[cy + 100][cx + 100]++;
                        if (count[cy + 100][cx + 100] > maxCount) {
                            maxCount = count[cy + 100][cx + 100];
                            maxY = cy;
                            maxX = cx;
                        }
                    }
                }
            }
        }

        System.out.println((maxX) + " " + (maxY));
    }
}
