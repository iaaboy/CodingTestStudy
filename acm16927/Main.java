package acm16927;

import java.io.*;
import java.util.*;

/* 배열 돌리기 2
 * https://www.acmicpc.net/problem/16927
 */

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int listCount = Math.min(N, M) / 2; //조건에 제시됨.
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
        for (int i = 0; i < listCount; i++) {
            nums.add(new ArrayList<>());
        }

        //x증가 , y증가, x감소, y감소
        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, 1, 0, -1};
        boolean [][] visit = new boolean[N][M];
        for (int i = 0; i < listCount; i++) {
            int x = i;
            int y = i;
            ArrayList<Integer> current = nums.get(i);
            int nx = x;
            int ny = y;
            current.add(arr[ny][nx]);
            visit[ny][nx] = true;
            for (int j = 0; j < 4; j++) {
                ny += dy[j];
                nx += dx[j];
                while (isInbound(ny, nx) && !visit[ny][nx]) {
                    current.add(arr[ny][nx]);
                    visit[ny][nx] = true;
                    ny += dy[j];
                    nx += dx[j];
                }
                ny -= dy[j];
                nx -= dx[j];
            }
        }
        // for (ArrayList<Integer> n : nums) {
        //     System.out.println(n);
        // }
        for (int i = 0; i < visit.length; i++) {
            Arrays.fill(visit[i], false);
        }
        for (int i = 0; i < listCount; i++) {
            int x = i;
            int y = i;
            ArrayList<Integer> current = nums.get(i);
            int nx = x;
            int ny = y;
            int currentIndex = R;
            int mod = current.size();
            // current.add(arr[ny][nx]);
            arr[ny][nx] = current.get(currentIndex++ % mod);
            visit[ny][nx] = true;
            for (int j = 0; j < 4; j++) {
                ny += dy[j];
                nx += dx[j];
                while (isInbound(ny, nx) && !visit[ny][nx]) {
                    // current.add(arr[ny][nx]);
                    arr[ny][nx] = current.get(currentIndex++ % mod);
                    visit[ny][nx] = true;
                    ny += dy[j];
                    nx += dx[j];
                }
                ny -= dy[j];
                nx -= dx[j];
            }
        }
        StringBuilder sb = new StringBuilder();
       for (int[] a : arr) {
            for (int a2 : a) {
                sb.append(a2).append(" ");
            }
            sb.append("\n");
       }
       System.out.print(sb);
    }
    static boolean isInbound (int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}

/*
 *
5 4 7
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28

7 6
1 2 3 4 5 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

0 0, 0 1, 0 2 , 0 3, ....0,5
1 5, 2 5, 3 5, 4 5, 5 5

x증가 , y증가, x감소, y감소


*/