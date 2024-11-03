package acmicpc27879;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] aa, ab, ba, bb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        aa = new int[N][N];
        ab = new int[N][N];
        ba = new int[N][N];
        bb = new int[N][N];
        char[][] ch = new char[N][N];
        for (int i = 0; i < N; i++) {
            ch[i] = bf.readLine().replaceAll(" ", "").toCharArray();
        }

        updateSum(ch, true, 'a', 'a');
        updateSum(ch, false, 'a', 'a');

        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(aa[i]));
        }

        int Q = Integer.parseInt(bf.readLine());
        for (int q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int j2 = Integer.parseInt(st.nextToken());
        }
    }

    private static void updateSum(char[][] ch, boolean vertical, char first, char second) {
        for (int i = 0; i < N; i++) {
            int saa = 0, sab = 0, sba = 0, sbb = 0;
            for (int j = 1; j < N; j++) {
                if (vertical) {
                    if (ch[j - 1][i] == first) {
                        if (ch[j][i] == second) {
                            aa[j][i] = ++saa;
                        } else {
                            ab[j][i] = ++sab;
                        }
                    } else {
                        if (ch[j][i] == second) {
                            ba[j][i] = ++sba;
                        } else {
                            bb[j][i] = ++sbb;
                        }
                    }
                } else {
                    if (ch[i][j - 1] == 'a') {
                        if (ch[i][j] == 'a') {
                            aa[i][j] = ++saa;
                        } else {
                            ab[i][j] = ++sab;
                        }
                    } else {
                        if (ch[i][j] == 'a') {
                            ba[i][j] = ++sba;
                        } else {
                            bb[i][j] = ++sbb;
                        }
                    }
                }
            }
        }
    }
}
