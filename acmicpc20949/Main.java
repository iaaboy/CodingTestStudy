package acmicpc20949;

import java.io.*;
import java.util.*;

/* 효정과 새 모니터
 * https://www.acmicpc.net/problem/20949
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        double[] res = new double[N];
        Integer[] index = new Integer[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            res[i] = Math.pow(H, 2) + Math.pow(W, 2);
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> {
            if (res[a] > res[b]) {
                return -1;
            } else if (res[a] == res[b]) {
                return a - b;
            } else {
                return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            sb.append(index[i] + 1 + "\n");
        }
        System.out.print(sb);
    }
}
