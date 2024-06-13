package acmicpc31924;

import java.io.*;

/* 현대모비스 특별상의 주인공은? 2 풀이
 * https://www.acmicpc.net/problem/31924
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] inArr = bf.readLine().toCharArray();
            arr[i] = inArr;
        }

        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr.length; x++) {
                if (arr[y][x] == 'M') {
                    for (int i = 0; i < 8; i++)
                        checkMobis(arr, y, x, 1, i);
                }
            }
        }
        System.out.println(count);
    }

    static int count = 0;
    static char[] mobis = { 'M', 'O', 'B', 'I', 'S' };
    static int[] offX = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static int[] offY = { 0, -1, -1, -1, 0, 1, 1, 1 };

    private static void checkMobis(char[][] arr, int y, int x, int index, int i) {
        if (index == 5) {
            // System.out.print(x + "," + y + " / ");
            count++;
            return;
        }

        int nextX = offX[i] + x;
        int nextY = offY[i] + y;
        if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr.length)
            return;
        if (arr[nextY][nextX] == mobis[index]) {
            checkMobis(arr, nextY, nextX, index + 1, i);
        }
    }
}
