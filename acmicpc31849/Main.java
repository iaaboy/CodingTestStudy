package acmicpc31849;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] cost = new int[R];
        int[][] map = new int[N][M];
        PriorityQueue<State> pQ = new PriorityQueue<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            cost[i] = Integer.parseInt(st.nextToken());
            map[y][x] = 1; // room 1
            pQ.add(new State(y, x, 0, i));
        }
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 2; // store
        }

        int[] offX = { 1, 0, -1, 0 };
        int[] offY = { 0, 1, 0, -1 };

        // for (int i = 0; i < map.length; i++) {
        // System.out.println(Arrays.toString(map[i]));
        // }
        // System.out.println(pQ);

        while (!pQ.isEmpty()) {
            State currState = pQ.poll();
            // System.out.println(pQ);
            // if(currState.roomId == 1)
            // System.out.println(currState);
            for (int i = 0; i < 4; i++) {
                int nextX = currState.x + offX[i];
                int nextY = currState.y + offY[i];
                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
                    continue;
                if (map[nextY][nextX] == 0) {
                    pQ.add(new State(nextY, nextX, currState.cost + cost[currState.roomId], currState.roomId));
                } else if (map[nextY][nextX] == 2) {
                    System.out.println(currState.cost + cost[currState.roomId]);
                    return;
                }
            }
        }
    }

    static class State implements Comparable<State> {
        int y;
        int x;
        int cost;
        int roomId;

        public State(int y, int x, int cost, int roomId) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.roomId = roomId;
        }

        @Override
        public int compareTo(State o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return y + "," + x + ":" + roomId + "/" + cost;
        }
    }
}
