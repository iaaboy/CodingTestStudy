package acmicpc15553;

import java.io.*;
import java.util.*;

/* 난로
 * https://www.acmicpc.net/problem/15553
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int on[] = new int[N];
        int off[] = new int[N];

        for (int i = 0; i < N; i++) {
            on[i] = Integer.parseInt(bf.readLine());
            off[i] = on[i] + 1;

        }

        int offTime[] = new int[N];
        offTime[0] = Integer.MAX_VALUE;
        Integer idx[] = new Integer[N];
        idx[0] = 0;
        for (int i = 1; i < N; i++) {
            offTime[i] = on[i] - off[i - 1];
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> offTime[a] - offTime[b]);

        for (int i = 0; i < N - K; i++) {
            on[idx[i]] = 0;
            off[idx[i] - 1] = 0;
        }
        int cOn = 0;
        int cOff = 0;
        int totalOn = 0;
        for (int i = 0; i < N; i++) {
            cOn = on[i] == 0 ? cOn : on[i];
            cOff = off[i] == 0 ? cOff : off[i];
            if (cOn != 0 && cOff != 0) {
                totalOn += cOff - cOn;
                cOn = 0;
                cOff = 0;
            }
        }
        // System.out.println(Arrays.toString(on));
        // System.out.println(Arrays.toString(off));
        // System.out.println(Arrays.toString(offTime));
        // System.out.println(Arrays.toString(idx));
        System.out.println(totalOn);
    }
}
