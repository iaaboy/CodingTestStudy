package acmicpc27879;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] aa, vaa;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        aa = new int[N][N];
        vaa = new int[N][N];
        char[][] ch = new char[N][N];
        for (int i = 0; i < N; i++) {
            ch[i] = bf.readLine().replaceAll(" ", "").toCharArray();
        }

        updateSum(ch, false, 'a', 'a');
        // updateSum(ch, true, 'a', 'a');

        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(aa[i]));
        }
        System.out.println("---");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(vaa[i]));
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
            int saa = 0;
            for (int j = 1; j < N; j++) {
                if (ch[i][j - 1] == first) {
                    if (ch[i][j] == second) {
                        aa[i][j] = ++saa;
                    }
                }
                if (i > 0) {
                    aa[i][j] += aa[i - 1][j];
                }
            }
        }
    }
}
