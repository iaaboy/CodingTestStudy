package acmicpc32372;

import java.io.*;
import java.util.*;

/* 마법의 나침반
 * https://www.acmicpc.net/problem/32372
 */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minX = 1;
        int minY = 1;
        int maxX = N - 1;
        int maxY = N - 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            switch (K) {
                case 1:// 1번 방향: 보물은 x 좌표가 작고, y 좌표가 같은 곳에 있습니다.
                    maxX = Math.min(maxX, X - 1);
                    minY = Y;
                    maxY = Y;
                    break;
                case 2:// 2번 방향: 보 물은 x 좌표가 작고, y 좌표가 큰 곳에 있습니다.
                    maxX = Math.min(maxX, X);
                    minY = Math.max(Y + 1, minY);
                    break;
                case 3:// 3번 방향: 보물은 x 좌표가 같고, y 좌표가 큰 곳에 있습니다.
                    minX = X;
                    maxX = X;
                    minY = Math.max(Y + 1, minY);
                    break;
                case 4:// 4번 방향: 보물은 x 좌표가 크고, y 좌표가 큰 곳에 있습니다.
                    minX = Math.max(X + 1, minX);
                    minY = Math.max(Y + 1, minY);
                    break;
                case 5:// 5번 방향: 보물은 x 좌표가 크고, y 좌표가 같은 곳에 있습니다.
                    minX = Math.max(X + 1, minX);
                    minY = Y;
                    maxY = Y;
                    break;
                case 6:// 6번 방향: 보물은 x 좌표가 크고, y 좌표가 작은 곳에 있습니다.
                    minX = Math.max(X + 1, minX);
                    maxY = Math.min(maxY, Y - 1);
                    break;
                case 7:// 7번 방향: 보물은 x 좌표가 같고, y 좌표가 작은 곳에 있습니다.
                    minX = X;
                    maxX = X;
                    maxY = Math.min(maxY, Y - 1);
                    break;
                case 8:// 8번 방향: 보물은 x 좌표가 작고, y 좌표가 작은 곳에 있습니다.
                    maxX = Math.min(maxX, X - 1);
                    maxY = Math.min(maxY, Y - 1);
                    break;
                default:
                    break;
            }
        }
        System.out.println(minX + " " + minY);
        // System.out.println(minY + "," + maxX);
    }
}
