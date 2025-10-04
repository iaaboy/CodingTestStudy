package acmicpc1944;

import java.io.*;
import java.util.*;

/* 복제 로봇
 * https://www.acmicpc.net/problem/1944
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][N];
        Coord[] spots = new Coord[M + 1];
        int[][] indexMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(indexMap[i], -1);
        }
        int index = 0;
        groupId = new int[M + 1];
        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'S' || map[i][j] == 'K') {
                    indexMap[i][j] = index;
                    groupId[index] = index;
                    spots[index++] = new Coord(i, j);
                }
            }
        }

        ArrayList<Node> nodes = new ArrayList<>();
        int[] dx = { 1, 0, 0, -1 };
        int[] dy = { 0, 1, -1, 0 };
        for (int i = 0; i <= M; i++) {
            boolean[][] visit = new boolean[N][N];
            visit[spots[i].y][spots[i].x] = true;
            Queue<Coord> q = new ArrayDeque<>();
            q.add(new Coord(spots[i].y, spots[i].x, 0));
            while (!q.isEmpty()) {
                Coord c = q.poll();
                // System.out.println("visit: " + c);
                for (int j = 0; j < 4; j++) {
                    int nx = c.x + dx[j];
                    int ny = c.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }
                    if (!visit[ny][nx]) {
                        if (map[ny][nx] == '0') {
                            visit[ny][nx] = true;
                            q.add(new Coord(ny, nx, c.cost + 1));
                        } else if (map[ny][nx] == 'K' || map[ny][nx] == 'S') {
                            visit[ny][nx] = true;
                            nodes.add(
                                    new Node(indexMap[spots[i].y][spots[i].x],
                                            indexMap[ny][nx], c.cost + 1));
                        }
                    }
                }
            }
        }

        // System.out.println(nodes);

        nodes.sort(null);
        long totalCost = 0;
        for (Node node : nodes) {
            if (find(node.from) != find(node.to)) {
                totalCost += node.cost;
                // System.out.println("merge: " + node.from + " <-- " + node.to);
                union(node.from, node.to);
            }
        }
        int groupCount = 0;
        for (int i = 0; i <= M; i++) {
            if (groupId[i] == i) {
                groupCount++;
            }
        }
        if (groupCount == 1) {
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
        }

    }

    static int[] groupId;

    static int find(int x) {
        if (groupId[x] == x)
            return x;
        return groupId[x] = find(groupId[x]);
    }

    // Union-Find: union
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB)
            return false;
        groupId[rootB] = rootA;
        return true;
    }

    static class Coord {
        int y, x;
        int cost;

        public Coord(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return y + "," + x + "(" + cost + ")";
        }
    }

    static class Node implements Comparable<Node> {
        int from, to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }

        @Override
        public String toString() {
            return from + "->" + to + "(" + cost + ")";
        }
    }
}
