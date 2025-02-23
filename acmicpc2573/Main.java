package acmicpc2573;

import java.io.*;
import java.util.*;

/* 빙산
 * https://www.acmicpc.net/problem/2573

Pseudo
0. 입력 받을 때에 전체 빙산 count
1. 1년 기준으로 빙산을 녹인다, 녹은 빙산 만큼 count빼준다.
  * 주의할 점) 녹일때 map을 바로 업데이트하면, 내 위치가 0으로 바뀔때 주위 값이 틀려질 수 있다.
  0 으로 바뀌는 지점은 나중에 한번에 처리 필요.
2. 남은 빙산의 첫번째 덩어리(land) 사이즈 잰다
  덩어리 사이즈 Q를 이용한 bfs
3. 첫번째 덩어리와 남은 count가 다르면 분리됨.
 */

public class Main {
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    count++;
                }
            }
        }
        int initialLandWidth = checkLands();
        if (count != initialLandWidth) {
            System.out.println(0);
            return;
        }

        int result = 0;
        for (int i = 1; i <= 10000; i++) {
            if (count == 0) {
                break;
            }

            ArrayList<Coord> cleanUpList = new ArrayList<>();
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[y][x] > 0) {
                        int neighborCount = 0;
                        for (int j = 0; j < 4; j++) {
                            int nX = x + dx[j];
                            int nY = y + dy[j];
                            if (nX < 0 || nY < 0 || nX >= M || nY >= N) {
                                continue;
                            }
                            if (map[nY][nX] == 0) {
                                neighborCount++;
                            }
                        }

                        // 주의) 업데이트를 나중에 별도 한번에 해야함.
                        if (map[y][x] > neighborCount) {
                            map[y][x] -= neighborCount;
                        } else {
                            cleanUpList.add(new Coord(y, x));
                        }
                    }
                }
            }
            count -= cleanUpList.size();
            for (Coord c : cleanUpList) {
                map[c.y][c.x] = 0;
            }

            int landWidth = checkLands();
            if (count != landWidth) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    private static int checkLands() {
        boolean[][] visited = new boolean[N][M];
        Queue<Coord> q = new ArrayDeque<>();
        int landCount = 0;
        loop: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    q.add(new Coord(i, j));
                    visited[i][j] = true;
                    landCount++;
                    break loop;
                }
            }
        }

        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nX = c.x + dx[i];
                int nY = c.y + dy[i];
                if (nX < 0 || nY < 0 || nX >= M || nY >= N) {
                    continue;
                }
                if (!visited[nY][nX] && map[nY][nX] > 0) {
                    visited[nY][nX] = true;
                    q.add(new Coord(nY, nX));
                    landCount++;
                }
            }
        }

        return landCount;
    }

    static int[] dx = { 1, 0, 0, -1 };
    static int[] dy = { 0, 1, -1, 0 };

    static class Coord {
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

/*
중요 반례
5 7
0 0 0 0 0 0 0
0 10 10 10 10 0 0
0 10 0
0 10 0 0 0 0
0 0 0 0 0 0 2
*/