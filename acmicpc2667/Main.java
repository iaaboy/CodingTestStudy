package acmicpc2667;

import java.io.*;
import java.util.*;

/* 단지번호붙이기
 * https://www.acmicpc.net/problem/2667
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        ArrayList<Integer> counts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '1') {
                    counts.add(getNeighborCount(arr, i, j));
                }
            }
        }
        counts.sort(null);
        StringBuilder sb = new StringBuilder();
        sb.append(counts.size()).append("\n");
        for (Integer counts2 : counts) {
            sb.append(counts2).append("\n");
        }
        System.out.print(sb);
    }
    static int[] dx = { 1, 0, 0, -1 };
    static int[] dy = { 0, 1, -1, 0 };
    private static int getNeighborCount(char[][] arr, int y, int x) {
        int count = 1;
        arr[y][x] = '2';
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { y, x });
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = c[0] + dy[i];
                int nx = c[1] + dx[i];
                if (ny < 0 || ny >= arr.length || nx < 0 || nx >= arr[0].length) {
                    continue;
                }
                if (arr[ny][nx] == '1') {
                    count++;
                    arr[ny][nx] = '2';
                    q.add(new int[] { ny, nx });
                }
            }
        }
        return count;
    }
}