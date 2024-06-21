package acmic30024;

import java.io.*;
import java.util.*;

/* 옥수수밭
 * https://www.acmicpc.net/problem/30024
 */

public class Main {
    static int[] offX = { 1, 0, -1, 0 };
    static int[] offY = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        Corn[][] arr = new Corn[Y][X];
        PriorityQueue<Corn> candiQ = new PriorityQueue<>((a, b) -> b.num - a.num);
        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(bf.readLine());
            for (int x = 0; x < X; x++) {
                arr[y][x] = new Corn(Integer.parseInt(st.nextToken()), false, y, x);
                if (x == 0 || y == 0 || x == X - 1 || y == Y - 1) {
                    candiQ.add(arr[y][x]);
                }
            }
        }
        int K = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (K > 0) {
            Corn c = candiQ.poll();
            while (c.isUsed) {
                c = candiQ.poll();
            }
            K--;
            c.isUsed = true;
            // sb.append(c.num + " " );
            sb.append((c.y + 1) + " " + (c.x + 1) + "\n");
            for (int i = 0; i < 4; i++) {
                int nX = c.x + offX[i];
                int nY = c.y + offY[i];
                if (nX < 0 | nY < 0 | nX >= X | nY >= Y)
                    continue;
                if (!arr[nY][nX].isUsed) {
                    candiQ.add(arr[nY][nX]);
                }
            }
        }
        System.out.println(sb);
    }

    static class Corn {
        int num;
        boolean isUsed;
        int y;
        int x;

        public Corn(int num, boolean isUsed, int y, int x) {
            this.num = num;
            this.isUsed = isUsed;
            this.y = y;
            this.x = x;
        }
    }
}
