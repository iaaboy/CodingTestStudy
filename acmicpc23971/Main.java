package acmicpc23971;

import java.io.*;
import java.util.*;

/* ZOAC 4
 * https://www.acmicpc.net/problem/23971
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sero = H / (1 + N) + (H % (1 + N) > 0 ? 1 : 0);
        int garo = W / (1 + M) + (W % (1 + M) > 0 ? 1 : 0);
        System.out.println(sero * garo);
    }
}
