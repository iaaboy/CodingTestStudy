package acmicpc1706;

import java.io.*;
import java.util.*;

/* 크로스워드
 * https://www.acmicpc.net/problem/1706
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] puzzle = new char[R][C];
        for (int i = 0; i < R; i++) {
            puzzle[i] = bf.readLine().toCharArray();
        }

        ArrayList<Coord> q = new ArrayList<>();
        int[] dx = { 1, 0 };
        int[] dy = { 0, 1 };
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                for (int d = 0; d < 2; d++) {
                    int ny = y - dy[d];
                    int nx = x - dx[d];
                    // 위에 혹은 왼쪽이 바깥이거나, # 이면
                    if (nx < 0) {
                        q.add(new Coord(y, x, d));
                    }
                    if (ny < 0) {
                        q.add(new Coord(y, x, d));
                    }
                    if (nx < 0 || ny < 0) {
                        continue;
                    }
                    if (puzzle[ny][nx] == '#' && puzzle[y][x] != '#') {
                        q.add(new Coord(y, x, d));
                    }
                }
            }
        }
        TreeSet<String> dictionary = new TreeSet<>();
        for (Coord c : q) {
            List<Character> word = new ArrayList<>();
            while (c.x < C && c.y < R && puzzle[c.y][c.x] != '#') {
                word.add(puzzle[c.y][c.x]);
                c.x += dx[c.dir];
                c.y += dy[c.dir];
            }
            if (word.size() < 2) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (char cc : word) {
                sb.append(cc);
            }
            dictionary.add(sb.toString());
        }
        System.out.println(dictionary.first());
    }

    static class Coord {
        int y, x, dir;
        List<Character> word = new ArrayList<>();

        public Coord(int y, int x, int dir) {
            this.dir = dir;
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return y + "," + x + "(" + dir + ")";
        }
    }
}
