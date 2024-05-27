package acmicpc31881;

import java.io.*;
import java.util.*;

/* K512에 바이러스 퍼뜨리기
 * https://www.acmicpc.net/problem/31881
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] isInfected = new boolean[N + 1];
        int infedtedCount = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            int query = Integer.parseInt(st.nextToken());
            if (query == 1) {
                int pcNum = Integer.parseInt(st.nextToken());
                if (!isInfected[pcNum]) {
                    isInfected[pcNum] = true;
                    infedtedCount++;
                }
            } else if (query == 2) {
                int pcNum = Integer.parseInt(st.nextToken());
                if (isInfected[pcNum]) {
                    isInfected[pcNum] = false;
                    infedtedCount--;
                }
            } else if (query == 3) {
                sb.append(N - infedtedCount + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
