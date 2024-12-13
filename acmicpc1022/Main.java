package acmicpc1022;

import java.io.*;
import java.util.*;

/* 풀이중
 * 
 */

public class Main {
    static int N;
    

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());;
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        N = Math.max(Math.abs(x1), Math.abs(x2));
        N = Math.max(N, Math.max(Math.abs(y1), Math.abs(y2)));
        int[][] map = new int[N * 2 + 1][N * 2 + 1];
        System.out.println(g(0) + "," + g(0));

        map[g(0)][g(0)] = 1;
        int start = 2;
        for (int i = 1; i <= N; i++) {
            start = setSquare(map, start, i);
        }

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[g(i)][g(j)] > 9) {
                    System.out.print(map[g(i)][g(j)] + " ");
                } else {
                    System.out.print(map[g(i)][g(j)] + "  ");
                }
            }
            System.out.println();
        }
    }

    private static int setSquare(int[][] map, int index, int num) {
        // (num, 0) 시작
        int x = num;
        int y = num - 1;
        map[g(y)][g(x)] = index++;
        y--;
        // y감소 -num 만날때까지
        for (; y >= -num; y--) {
            if (map[g(y)][g(x)] == 0)
                map[g(y)][g(x)] = index++;
        }
        y++;
        // printMap(x + "," + y);

        // x감소 -num 만날때까지
        for (; x >= -num; x--) {
            if (map[g(y)][g(x)] == 0)
                map[g(y)][g(x)] = index++;
        }
        x++;
        // printMap(x + "," + y);

        // y증가 num 만날때까지
        for (; y <= num; y++) {
            if (map[g(y)][g(x)] == 0)
                map[g(y)][g(x)] = index++;
        }
        y--;
        // printMap(x + "," + y);

        // x증가 num 만날때까지
        for (; x <= num; x++) {
            if (map[g(y)][g(x)] == 0)
                map[g(y)][g(x)] = index++;
        }
        x--;
        // printMap(x + "," + y);

        // y 증가 0 만나기 전까지
        for (; y > 0; y--) {
            if (map[g(y)][g(x)] == 0)
                map[g(y)][g(x)] = index++;
        }

        // printMap(x + "," + y);

        return index;
    }

    private static void printMap(String s) {
        // System.out.println(s);
        // for (int i = -N; i <= N; i++) {
        //     for (int j = -N; j <= N; j++) {
        //         if (map[g(i)][g(j)] > 9) {
        //             System.out.print(" " + map[g(i)][g(j)]);
        //         } else {
        //             System.out.print("  " + map[g(i)][g(j)]);
        //         }

        //     }
        //     System.out.println();
        // }
    }

    static int g(int x) {
        return x + N;
    }
}
