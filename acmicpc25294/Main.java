package acmicpc25294;

import java.io.*;
import java.util.*;

/* 달팽이와 쿼리
 * https://www.acmicpc.net/problem/25294
 */

 /*
1. layer 계산
2. 시작 숫자 계산
3. 방향 계산
4. 좌표 계산
값 -> 좌료 계산
같은 방식으로 좌표 -> 값 계산.
  */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int n = 0;
            if (cmd == 1) {
                n = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int result = getSnailValue(n, y, x);
                sb.append(result).append("\n");
            } else {
                n = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                int[] result = getSnailCoordinates(n, z);
                sb.append(result[1] + 1).append(" ").append(result[0] + 1).append("\n");
            }
        }
        System.out.print(sb);
    }

    static int getSnailValue(int N, int y, int x) {
        // 현재 좌표가 속한 layer 계산
        int layer = Math.min(Math.min(x, y), Math.min(N - 1 - x, N - 1 - y));
        //System.out.print(layer + " "); //ok
        // 시작숫자 바깥쪽부터 안쪽으로 1, 9, 25, 49, 81, 121, 169
        int start = N * N - (N - 2 * layer) * (N - 2 * layer);
        int num = start;
        // System.out.print(start + " ");// ok
        // 방향 1: →, 2: ↓, 3: ←, 4: 향
        int dir = 0;
        int lineLength = N - 2 * layer;
        int[] startInSqare = { 0, lineLength, lineLength + lineLength - 1,
                lineLength + lineLength - 1 + lineLength - 1 };
        int option = 0;
        if (N - 1 - y == N - 1 - layer) { // 상단(→ 방향)
            option = x + 1 - layer;
            dir = 0;
        } else if (x == N - 1 - layer) { // 오른쪽(↓ 방향)
            option = y - layer;
            dir = 1;
        } else if (N - 1 - y == layer) { // 하단(← 방향)
            option = N - 1 - x - layer;
            dir = 2;
        } else { // 왼쪽(↑ 방향)
            option = N - 1 - y - layer;
            dir = 3;
        }
        // System.out.print(dir + " ");//ok
        // System.out.print(startInSqare[dir] + " ");
        // System.out.print(option + " ");//ok
        num += option;
        num += startInSqare[dir];
        // System.out.print(num + " ");// ng
        // System.out.print(option + " ");

        return num;
    }

    static int[] getSnailCoordinates(int N, int num) {
        int layer = N - 1;
        int layersLastNum = 0;
        for (; layer > 0; layer -= 2) {
            layersLastNum += layer * 4;
            if (num <= layersLastNum) {
                break;
            }
        }
        layer /= 2;
        layer = N / 2 - layer;
        int lineLength = N - 2 * layer;
        int[] startInSqare = { 0, lineLength, lineLength + lineLength - 1,
                lineLength + lineLength - 1 + lineLength - 1 };
        int dir = 0;
        int start = N * N - (N - 2 * layer) * (N - 2 * layer);
        for (; dir < startInSqare.length; dir++) {
            if (num <= start + startInSqare[dir]) {
                break;
            }
        }
        dir--;

        int x = 0, y = 0;
        int diff = num - start;
        int option = diff - startInSqare[dir];
        if (dir == 0) { // 상단(→)
            x = layer + option - 1;
            y = layer;
        } else if (dir == 1) { // 오른쪽(↓)
            x = N - 1 - layer;
            y = layer + option;
        } else if (dir == 2) { // 하단(←)
            x = N - 1 - layer - option;
            y = N - 1 - layer;
        } else { // 왼쪽(↑)
            x = layer;
            y = N - 1 - layer - option;
        }

        // System.out.print(y + " ");

        return new int[] { x, y };
    }
}
