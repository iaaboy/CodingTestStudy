package acmicpc30702;

import java.io.*;
import java.util.*;

/*
 3 3
AAA
BBB
AAA
CCC
DDD
FFF
yes

2 4
AAAA
BBBB
AAAA
AAAA
YES
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] inAchar = new char[N][];
        for (int i = 0; i < N; i++) {
            inAchar[i] = bf.readLine().toCharArray();
        }
        char[][] inBchar = new char[N][];
        for (int i = 0; i < N; i++) {
            inBchar[i] = bf.readLine().toCharArray();
        }

        // A를 B 색깔로 채운다
        char[][] newFlag = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newFlag[i][j] == 0) {
                    boolean result = fillColor(newFlag, inAchar, inBchar[i][j], i, j, 4);
                    if (result) {
                        System.out.println("NO");
                        // return;
                    }
                    printNewFlag(newFlag);
                } else {
                    if (newFlag[i][j] != inBchar[i][j]) {
                        System.out.println("NO");
                        // return;
                    }
                }
            }
        }

        System.out.println("YES");
    }

    private static void printNewFlag(char[][] newFlag) {
        for (int i = 0; i < newFlag.length; i++) {
            System.out.println();
            for (int j = 0; j < newFlag[0].length; j++) {
                System.out.print(newFlag[i][j] == 0 ? 0 : newFlag[i][j] + " ");
            }
        }
    }

    static int[] offsetY = { 0, -1, 0, 1 };
    static int[] offsetX = { -1, 0, 1, 0 };
    static int[] skipIdx = { 2, 3, 0, 1, 5 };

    private static boolean fillColor(char[][] newFlag, char[][] reference ,char refCh, char fillCh, int y, int x, int from) {
        // reference 영역의 모든 구역을 c로 채운다
        boolean result = true;
        if (newFlag[y][x] != 0 && newFlag[y][x] != fillCh) {
            return false;
        }
        if(newFlag[y][x] == fillCh) {
            return true;
        }
        newFlag[y][x] = fillCh;
        for (int i = 0; i < 4; i++) {
            int nX = x + offsetX[i];
            int nY = y + offsetY[i];
            if (nX < 0 || nY < 0 || nX >= newFlag[0].length || nY >= newFlag.length || i == skipIdx[from])
                continue;
            if (reference[nY][nX] == fillCh) {
                result &= fillColor(newFlag, reference, refCh , fillCh, nY, nX, from);
            }
        }
        return result;
    }
}
