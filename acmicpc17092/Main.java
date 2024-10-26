package acmicpc17092;

import java.io.*;
import java.util.*;

/* 색칠 공부
 * https://www.acmicpc.net/problem/17092
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        // h , w, count
        HashMap<Integer, HashMap<Integer, Integer>> m = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int h = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken()) - 1;
            for (int hh = h - 2; hh <= h ; hh++) {
                if (hh < 0 || hh > H - 3) {
                    continue;
                }
                for (int ww = w - 2; ww <= w; ww++) {
                    if (ww < 0 || ww > W - 3) {
                        continue;
                    }
                    if (m.containsKey(hh)) {
                        if (m.get(hh).containsKey(ww)) {
                            m.get(hh).put(ww, m.get(hh).get(ww) + 1);
                        } else {
                            m.get(hh).put(ww, 1);
                        }
                    } else {
                        m.put(hh, new HashMap<Integer,Integer>());
                        m.get(hh).put(ww, 1);
                    }
                }
            }
            // sb.append(h +"," + w + ": " +m + "\n");
        }

        long [] count = new long[10];
        long totalCount = 0;
        for (HashMap<Integer,Integer> h : m.values()) {
            for (Integer c : h.values()) {
                count[c]++;
            }            
        }
        for (int i = 0; i < count.length; i++) {
            totalCount+=count[i];
        }
        count[0] = ((long)W-2) * ((long)H-2) - totalCount;

        for (int i = 0; i < count.length; i++) {
            sb.append(count[i] + "\n");
        }
        System.out.print(sb);

    }
    static class Coord {
        int x,y;

        @Override
        public boolean equals(Object obj) {
            Coord that = (Coord)obj;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y * 31;
        }

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
