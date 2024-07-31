package acmicpc11123;

import java.io.*;
import java.util.*;

/* 양 한마리... 양 두마리...
 * https://www.acmicpc.net/problem/11123
 */

public class Main {
    static int H,W;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            int [][] map = new int[H][W];
            for (int j = 0; j < H; j++) {
                char [] chr = bf.readLine().toCharArray();
                for (int k = 0; k < chr.length; k++) {
                    map[j][k] = chr[k] == '#' ? 0 : -1;
                }
            }

            // printArr(map, "test");

            int id = 1;
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    if (map[j][k] == 0) {
                        navigate(map, id++, j, k);
                    }
                }
            }
            // printArr(map, "test2");
            // System.out.println(id - 1);
            sb.append((id-1) + "\n");
        }
        System.out.print(sb);
    }

    private static void printArr(int[][] map, String msg) {
        System.out.println(msg);
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    static int[] offX = { 1, 0, -1, 0 };
    static int[] offY = { 0, -1, 0, 1 };

    static void navigate(int[][] arr, int id, int y, int x) {
        // System.out.println("navigate: " + id + "-" + y + "," + x);
        Queue<Coor> mQ = new LinkedList<>();
        mQ.add(new Coor(y, x));
        arr[y][x] = id;
        while (!mQ.isEmpty()) {
            Coor cur = mQ.poll();
            for (int i = 0; i < 4; i++) {
                    int nX = cur.x + offX[i];
                    int nY = cur.y + offY[i];
                    if (nX < 0 || nY < 0 || nY >= H || nX >= W)
                        continue;
                    if (arr[nY][nX] == 0) {
                        arr[nY][nX] = id;
                        mQ.add(new Coor(nY, nX));
                    }
            }
        }
    }

    static class Coor {
        int y;
        int x;

        public Coor(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
