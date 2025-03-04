package acmicpc1022;

import java.io.*;
import java.util.*;

/* 풀이중
 * 
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(bf.readLine());;
        // int x1 = Integer.parseInt(st.nextToken());
        // int y1 = Integer.parseInt(st.nextToken());
        // int x2 = Integer.parseInt(st.nextToken());
        // int y2 = Integer.parseInt(st.nextToken());

        printMap(4, "Test");

    }

    private static int getValue(int y, int x) {
        int layer = Math.max(Math.abs(y), Math.abs(x));
        // System.out.print(layer + " ");
        int N = layer * 2 + 1;
        int start = N * N - (N - 2 * layer) * (N - 2 * layer) + 1;
        int index = start;
        // System.out.print(start + " ");
        int dir = 3;
        int lineLength = 1 + 2 * layer;
        int[] startInSqare = { 0, lineLength, lineLength + lineLength - 1,
                lineLength + lineLength - 1 + lineLength - 1 };
        int option = 0;
        if (y - layer == 0) { // 하단(← 방향)
            // option = x - N / 2;
            // index += option;
            dir = 0;
        } else if (x + layer == 0) { // 왼쪽(↓ 방향)
            // option = y - N / 2 + 1;
            // index += option;
            dir = 1;
        } else if (y + layer <= 0) { // 상단(→ 방향)
            // option = x - N / 2 + 1;
            // index -= option;
            dir = 2;
        } else { //오른쪽(↑ 방향)
            // option = y - N / 2;
            // index -= option;
            dir = 3;

        }
        // System.out.print(startInSqare[dir] + " ");
        index -= startInSqare[dir];

        // System.out.print(dir + " ");

        System.out.printf("%2d ", index);

        return -1;
    }

    private static void printMap(int N, String s) {
        System.out.println(s);
        for (int y = -N; y <= N; y++) {
            for (int x = -N; x <= N; x++) {
                getValue(y, x);
            }
            System.out.println();
        }
    }
}
