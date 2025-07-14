package acmicpc1949;

import java.io.*;
import java.util.*;

/* 우수 마을
 * https://www.acmicpc.net/problem/1949
 */

public class Main {
    static Town[] town;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        town = new Town[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            town[i] = new Town(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            town[s].neighbor.add(e);
            town[e].neighbor.add(s);
        }
        Populate total = getPopulate(1);
        System.out.println(Math.max(total.offCount, total.onCount));
    }

    private static Populate getPopulate(int t) {
        int offSum = 0;
        int onSum = 0;
        town[t].visit = true;
        for (Integer n : town[t].neighbor) {
            if (!town[n].visit) {
                Populate neighborPopulate = getPopulate(n);
                onSum += Math.max(neighborPopulate.onCount, neighborPopulate.offCount);
                offSum += neighborPopulate.offCount;
            }
        }
        Populate myPopulate = new Populate(town[t].populate + offSum, onSum);
        // System.out.println(t + " : " + myPopulate);
        return myPopulate;
    }

    static class Populate {
        int onCount;
        int offCount;

        public Populate(int onCount, int offCount) {
            this.onCount = onCount;
            this.offCount = offCount;
        }

        @Override
        public String toString() {
            return onCount + "/" + offCount;
        }
    }

    static class Town {
        int populate;
        boolean visit;
        ArrayList<Integer> neighbor = new ArrayList<>();

        public Town(int populate) {
            this.populate = populate;
        }

        @Override
        public String toString() {
            return populate + ".." + neighbor.toString();
        }
    }
}
