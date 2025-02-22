package aa_baseFrom;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        N *= 3;
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = 0;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            map[0][0] = nCh[i];
            if(draw(0, 0))
                break;
        }
        

        if (complete) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    sb.append(map[j][i]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        } else {
            System.out.println(-1);
        }
    }

    static boolean complete = false;

    private static boolean draw(int y, int x) {
        if (complete == true) {
            return true;
        }
        if (x == N - 1 && y == N - 1) {
            complete = true;
            return true;
        }

        for (int k = 0; k < 3; k++) {
            if (checkLeft(y, x) || checkUpper(y, x) || checkVertical(y, x)) {
                if (x == N - 1) {
                    if (y + 1 >= N)
                        continue;
                    map[y + 1][0] = nCh[k];
                    if(draw(y + 1, 0)) {
                        return true;
                    };
                    map[y + 1][0] = 0;
                } else {
                    if (x + 1 >= N)
                        continue;
                    map[y][x + 1] = nCh[k];
                    if(draw(y, x + 1))
                        return true;
                    map[y][x + 1] = 0;
                }
            }
        }
        return false;
    }

    static boolean checkLeft(int y, int x) {
        if (x < 2) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (map[y][x - i] != nCh[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean checkUpper(int y, int x) {
        if (y < 2) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (map[y - i][x] != nCh[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean checkVertical(int y, int x) {
        if (x < 2 || y < 2) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (map[y - i][x - i] != nCh[i]) {
                return false;
            }
        }
        return true;
    }

    static char[] nCh = { 'A', 'N', 'Z' };
}
