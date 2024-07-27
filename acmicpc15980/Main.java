package acmicpc15980;

import java.io.*;
import java.util.*;

/* 명상 방해꾼
 * https://www.acmicpc.net/problem/15980
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[] totalSing = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            boolean isLeft = st.nextToken().charAt(0) == 'L';
            char[] sing = st.nextToken().toCharArray();
            for (int j = 0; j < sing.length; j++) {
                if (sing[j] == '1') {
                    arr[i][j] = isLeft ? 1 : -1;
                }
                totalSing[j] += arr[i][j];
            }
        }
        for (int i = 1; i < M; i++) {
            totalSing[i] += totalSing[i - 1];
        }
        // System.out.println(Arrays.toString(totalSing));

        int minSing = Integer.MAX_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            int acc = 0;
            int maxSing = 0;
            for (int j = 0; j < M; j++) {
                acc += arr[i][j];
                int curSing = totalSing[j] - acc;
                // System.out.print(curSing + " ");
                maxSing = Math.max(maxSing, Math.abs(curSing));
            }
            // System.out.println();
            if (minSing > maxSing) {
                minSing = maxSing;
                maxIdx = i;
            }
        }
        System.out.println((maxIdx + 1) + "\n" + minSing);
    }
}
