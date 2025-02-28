package acmicpc20166;

import java.io.*;
import java.util.*;

public class Main {
    static char[][] map ;
    static Queue<Coord> q = new LinkedList<>();
    static HashMap<String, Integer> countMap;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
        
        }
        countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                q = new LinkedList<>();
                q.add(new Coord(i, j, "" + (map[i][j])));
                while (!q.isEmpty()) {
                    Coord c = q.poll();
                    // if (c.word.length() == K) {
                    //     countMap.put(c.word, countMap.getOrDefault(c.word, 1) + 1);
                    //     // System.out.println(countMap);
                    //     continue;
                    // }
                    for (int d = 0; d < 8; d++) {
                        int nx = (M + c.x + dx[d]) % M;
                        int ny = (N + c.y + dy[d]) % N;
                        if (c.word.length() + 1 == K) {
                            String s = c.word + map[ny][nx];
                            countMap.put(s, countMap.getOrDefault(s, 1) + 1);
                            // System.out.println(countMap);
                            // continue;
                        } else {
                            q.add(new Coord(ny, nx, c.word + map[ny][nx]));
                        }
                        
                    }
                }
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            String inWord = bf.readLine();
            sb.append(countMap.getOrDefault(inWord, 0)).append("\n");
        }
        System.out.print(sb);
    }
    static int[] dx = { 1, 0, 0, -1, 1, 1, -1, -1 };
    static int[] dy = { 0, 1, -1, 0, -1, 1, -1, 1 };
    static class Coord {
        int y, x;
        String word;
        public Coord(int y, int x, String word) {
            this.y = y;
            this.x = x;
            this.word = word;
        }
    }
}