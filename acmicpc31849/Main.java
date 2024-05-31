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
        CStore[] listCS = new CStore[R];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            listCS[i] = new CStore(y, x, r);
        }
        int minCRate = Integer.MAX_VALUE;
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            minCRate = Math.min(minCRate, getCrate(listCS, y, x));
        }
        System.out.println(minCRate);
    }

    private static int getCrate(CStore[] listCS, int y, int x) {
        int rate = Integer.MAX_VALUE;
        for (CStore cs : listCS) {
            if (cs.r > rate)
                continue;
            rate = Math.min(rate, cs.r * (Math.abs(y - cs.y) + Math.abs(x - cs.x)));
        }
        return rate;
    }

    static class CStore {
        int y;
        int x;
        int r;

        public CStore(int y, int x, int r) {
            this.y = y;
            this.x = x;
            this.r = r;
        }
    }
}
