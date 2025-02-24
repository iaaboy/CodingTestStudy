package acmicpc16946;

import java.io.*;
import java.util.*;

/* 벽 부수고 이동하기 4
 * https://www.acmicpc.net/problem/16946
 */

/*
1. 1(벽) , 0(이동가능)
2. 전체 순회) 0을 기준으로 이동 가능한 주변 구역을 센다. 동일 구역에 속하면 동일 id를 부여
   각 id별로 이동 가능한 구역의 크기를 저장한다.
  idMap - key(id), value(구역의 크기)
  메모리 절약을 위해 id를 음수로 저장했다.
3. 전체 순회) 1인 구역의 상하좌우 id들을 listup,(중복 제거를 위해 set사용)
4. 나를 포함해서 주변 구역 크기 총합을 계산하고, map에 업데이트
5. 전체 순회) id(음수로 저장하였음)를 저장한 구역을 0으로 업데이트 
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

        for (int i = 0; i < N; i++) {
            char[] inStr = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = inStr[j] - '0';
            }
        }

        HashMap<Integer, Integer> idMap = new HashMap<>();
        int gIndex = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    int count = unionGroup(i, j, -gIndex);
                    idMap.put(-gIndex, count % 10);
                    gIndex++;
                }
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 1) {
                    Set<Integer> idSet = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int nX = x + dx[i];
                        int nY = y + dy[i];
                        if (nX < 0 || nY < 0 || nX >= M || nY >= N) {
                            continue;
                        }
                        if (map[nY][nX] < 0) {
                            idSet.add(map[nY][nX]);
                        }
                    }
                    int countSum = 0;
                    for (Integer id : idSet) {
                        countSum += idMap.get(id);
                    }
                    map[y][x] = (countSum + 1) % 10;
                }
            }
        }
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                map[y][x] = map[y][x] < 0 ? 0 : map[y][x];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int unionGroup(int y, int x, int id) {
        int count = 0;
        Queue<Coord> q = new ArrayDeque<>();
        q.add(new Coord(y, x));
        count++;
        map[y][x] = id;
        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nX = c.x + dx[i];
                int nY = c.y + dy[i];
                if (nX < 0 || nY < 0 || nX >= M || nY >= N) {
                    continue;
                }
                if (map[nY][nX] == 0) {
                    map[nY][nX] = id;
                    count++;
                    q.add(new Coord(nY, nX));
                }
            }
        }
        return count;
    }

    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { 1, -1, 0, 0 };

    static class Coord {
        int y;
        int x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
