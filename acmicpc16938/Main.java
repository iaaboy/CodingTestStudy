package acmicpc16938;

import java.io.*;
import java.util.*;

/* 캠프 준비
 * https://www.acmicpc.net/problem/16938
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] issues = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            issues[i] = Integer.parseInt(st.nextToken());
        }

        int maxLoop = getMask(N) + 1;
        int count = 0;
        for (int i = 0; i < maxLoop; i++) {
            // 1. 문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다.
            // 2. 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다
            int sum = 0;
            int difficultyMin = Integer.MAX_VALUE;
            int difficultyMax = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += issues[j];
                    difficultyMax = Math.max(difficultyMax, issues[j]);
                    difficultyMin = Math.min(difficultyMin, issues[j]);
                }
            }
            if (sum >= L && sum <= R) {
                if (difficultyMax - difficultyMin >= X) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static int getMask(int M) {
        int mMask = 0;
        while (M > 0) {
            mMask |= 1 << M - 1;
            M--;
        }
        return mMask;
    }
}
