package acmicpc17943;

import java.io.*;
import java.util.*;

/* 도미노 예측
 * https://www.acmicpc.net/problem/17943

x번째 도미노의 수와 y번째 도미노의 수를 XOR한 값을 답하라.
 >> 결국 x ~ y까지 xor 한 것과 같음.
 >> 시간을 줄이기 위해 누적합 원리를 이용
   (0~x 누적합) ^ (0~y 누적합)
x번째 도미노의 수가 d일 때, y번째 도미노의 수를 답하라.
    d ^ (0~x 누적합) ^ (0~y 누적합)

위 쿼리에 맞는 답을 출력한다.
 */

public class Main {
    static int[] xOrArr;
    static int[] xOrArrAccumul;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        xOrArr = new int[N];
        xOrArrAccumul = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < N; i++) {
            xOrArr[i] = Integer.parseInt(st.nextToken());
            xOrArrAccumul[i] = xOrArrAccumul[i - 1] ^ xOrArr[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(bf.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (cmd == 0) {
                sb.append(getXor(x, y)).append("\n");
            } else {
                int d = Integer.parseInt(st.nextToken());
                sb.append(getXor(x, y) ^ d).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static int getXor(int x, int y) {
        if (x == y) {
            return 0;
        }
        // int result = xOrArr[x];
        // for (int i = x + 1; i <= y - 1; i++) {
        // result ^= xOrArr[i];
        // }
        x--;
        y--;
        int result2 = 0;
        if (x - 1 < 0) {
            result2 = xOrArrAccumul[0] ^ xOrArrAccumul[y];
        } else {
            result2 = xOrArrAccumul[x] ^ xOrArrAccumul[y];
        }
        // System.out.println(result + ", " + result2);
        return result2;
    }
}