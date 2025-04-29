package acmicpc21771;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int gR = Integer.parseInt(st.nextToken());
        int gC = Integer.parseInt(st.nextToken());
        int bR = Integer.parseInt(st.nextToken());
        int bC = Integer.parseInt(st.nextToken());

        char [][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        int rmin = Integer.MAX_VALUE,rmax = Integer.MIN_VALUE;
        int cmin = Integer.MAX_VALUE,cmax = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'P') {
                    rmin = Math.min(rmin, i);
                    rmax = Math.max(rmax, i);
                    cmin = Math.min(cmin, j);
                    cmax = Math.max(cmax, j);
                }
            }
        }

        int sleepOverPillow = 0;
        for (int i = rmin; i <= rmax; i++) {
            for (int j = cmin; j <= cmax; j++) {
                if (arr[i][j] == 'G') {
                    sleepOverPillow = 1;
                    break;
                }
            }
        }
        System.out.println(sleepOverPillow);
    }
}