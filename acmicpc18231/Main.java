package acmicpc18231;

import java.io.*;
import java.util.*;

/* 틀림!!!
 *  https://www.acmicpc.net/problem/18231
 */

 //푸는중

public class Main {
    static City[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        cities = new City[C + 1];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int me = Integer.parseInt(st.nextToken());
            int you = Integer.parseInt(st.nextToken());
            cities[me].neighbor.add(you);
            cities[you].neighbor.add(me);
        }

        int T = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        ArrayList<Integer> bCandidate = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int d = Integer.parseInt(st.nextToken());
            cities[d].isDestroyed = true;
            bCandidate.add(d);
        }

        // System.out.println();
        // for (int i = 1; i <= C; i++) {
        //     System.out.println("city: " + i + " - " + cities[i]);
        // }

        ///////////// check
        //나만 터졌을 때 고려 필요!!!
        ArrayList<Integer> bombs = new ArrayList<>();
        for (Integer bomb : bCandidate) {
            // checkNeighbors
            boolean allDestoyed = cities[bomb].isDestroyed;
            for (Integer n : cities[bomb].neighbor) {
                if (!cities[n].isDestroyed) {
                    allDestoyed = false;
                    break;
                }
            }
            if (allDestoyed) {
                cities[bomb].bomb = true;
                // System.out.println("its bomb: " + bomb);
                bombs.add(bomb);
            } else {
                // System.out.println("its not bomb: " + bomb);
            }
        }

        int handleCount = T;
        StringBuilder sb = new StringBuilder();
        for (Integer b : bombs) {
            // if (!cities[b].isDestroyed) {
            //     continue;
            // }
            sb.append(b).append(" ");
            if (cities[b].isDestroyed) {
                handleCount--;
                cities[b].isDestroyed = false;
            }
            for (Integer n : cities[b].neighbor) {
                if (cities[n].isDestroyed) {
                    handleCount--;
                    cities[n].isDestroyed = false;
                }
            }
            if (handleCount == 0) {
                break;
            }
        }
        if (handleCount > 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static class City {
        boolean isDestroyed = false;
        boolean bomb = false; // 0 unknown, 1 bomb
        ArrayList<Integer> neighbor = new ArrayList<>();

        @Override
        public String toString() {
            return bomb + "," + isDestroyed + ":" + neighbor;
        }
    }
}