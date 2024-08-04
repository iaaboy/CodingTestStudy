package acmicpc10837;

import java.io.*;
import java.util.*;

/* 동전 게임
 * https://www.acmicpc.net/problem/10837
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        int C = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int M /* 영희, 먼저함 */ = Integer.parseInt(st.nextToken());
            int N /* 동수 */ = Integer.parseInt(st.nextToken());
            int result = 0;
            if (M == N) {
                result = 1;
            } else if (M > N) {
                int gap = M - N;
                int roundLeft = K - M + 2 /* 동수가 한 번 가능, 이전에 영희가 한 경우 */;
                if (gap > roundLeft) {
                    result = 0;
                } else {
                    result = 1;
                }
            } else {
                int gap = N - M - 1;
                int roundLeft = K - N;
                if (gap > roundLeft) {
                    result = 0;
                } else {
                    result = 1;
                }
            }
            sb.append(result + "\n");
        }
        System.out.print(sb);
    }
}
