package acmicpc17843;

import java.io.*;
import java.util.*;

/* 시계
 * https://www.acmicpc.net/problem/17843
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Double[] d = new Double[3];
            d[0] = Double.parseDouble(st.nextToken());
            d[1] = Double.parseDouble(st.nextToken());
            d[2] = Double.parseDouble(st.nextToken());

            d[0] = (360 * (d[0] * 60 * 60 + d[1] * 60 + d[2])) / (12 * 60 * 60);
            d[1] = (360 * (d[1] * 60 + d[2])) / (60 * 60);
            d[2] = (360 * (d[2])) / (60);

            Arrays.sort(d);

            Double minDegree = Math.min(d[2] - d[1], d[1] - d[0]);
            minDegree = Math.min(minDegree, d[0] + 360 - d[2]);
            System.out.printf("%.6f\n", minDegree);
        }
    }
}
