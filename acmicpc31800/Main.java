package acmicpc31800;

import java.io.*;
import java.util.*;

/* Best Chance
 * https://www.acmicpc.net/problem/31800
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] iik = new int[N];
        int max1 = -1;
        int max2 = -1;
        for (int i = 0; i < N; i++) {
            iik[i] = Integer.parseInt(st.nextToken());
            if (iik[i] >= max1) {
                max2 = Math.max(max2, max1);
                max1 = iik[i];
            } else {
                max2 = Math.max(max2, iik[i]);
            }
        }
        // System.out.println(max1 + "," + max2);
        st = new StringTokenizer(bf.readLine());
        int[] origin = new int[N];
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            if (iik[i] == max1) {
                int ik = iik[i] - max2;
                iik[i] = ik;
            } else {
                int ik = iik[i] - max1;
                iik[i] = ik;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(iik[i] + " ");
        }
        System.out.println(sb);
    }
}
