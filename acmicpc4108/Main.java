package acmicpc4108;

import java.io.*;
import java.util.*;

/* 지뢰찾기
 * https://www.acmicpc.net/problem/4108
각 포인트를 순회하여 여덟 방향을 체크 별 숫자 카운트하고, arr에 업데이트
출력. 
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
        StringBuilder sb = new StringBuilder();
        while (C != 0 && R != 0) {
            char[][] arr = new char[C][R];
            for (int i = 0; i < C; i++) {
                arr[i] = bf.readLine().toCharArray();
            }

            for (int i = 0; i < C; i++) {
                for (int j = 0; j < R; j++) {
                    if (arr[i][j] == '.') {
                        char count = '0';
                        for (int d = 0; d < 8; d++) {
                            int nx = j + dx[d];
                            int ny = i + dy[d];
                            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                                continue;
                            }
                            if (arr[ny][nx] == '*') {
                                count++;
                            }
                        }
                        arr[i][j] = count;
                    }
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }

            st = new StringTokenizer(bf.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }
}
