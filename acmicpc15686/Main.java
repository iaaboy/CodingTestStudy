package acmicpc15686;

import java.io.*;
import java.util.*;

/* 치킨 배달
 * https://www.acmicpc.net/problem/15686
 */

public class Main {
    static int M;
    static ArrayList<Coor> house, chiken;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chiken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 1)
                    house.add(new Coor(i, j));
                if (number == 2) {
                    chiken.add(new Coor(i, j));
                }
            }
        }
        boolean[] visited = new boolean[chiken.size()];
        visitNext(visited, 0, 0);

        System.out.println(result);
    }

    private static void visitNext(boolean[] visited, int start, int depth) {
        if (depth == M) {
            ArrayList<Integer> cList = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    cList.add(i);
                }
            }
            result = Math.min(result, getSum(cList));
            return;
        }
        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                visitNext(visited, i, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int getSum(ArrayList<Integer> cList) {
        int totalSum = 0;
        for (Coor hs : house) {
            int s = Integer.MAX_VALUE;
            for (Integer c : cList) {
                Coor chickenHouse = chiken.get(c);
                s = Math.min(s, Math.abs(hs.x - chickenHouse.x) + Math.abs(hs.y - chickenHouse.y));
            }
            totalSum += s;
        }
        return totalSum;
    }

    static class Coor {
        int y, x;

        public Coor(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
