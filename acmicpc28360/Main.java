package acmicpc28360;

import java.io.*;
import java.util.*;

/* 양동이 게임
 * https://www.acmicpc.net/problem/28360
 */

public class Main {
    static ArrayList<Vertex> v;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        v = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            v.add(new Vertex());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            v.get(start).next.add(end);
        }
        Queue<Integer> nq = new ArrayDeque<>();
        nq.add(1);
        v.get(1).water = 100;
        handleWater(nq);
        // System.out.println(v);
        double max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, v.get(i).water);
        }
        System.out.println(max);
    }

    private static void handleWater(Queue<Integer> nq) {
        Set<Integer> next = new HashSet<>();
        // System.out.println("handleWater:" + nq);
        while (!nq.isEmpty()) {
            Integer c = nq.poll();
            // System.out.println("handle: " + c + "," + v.get(c));
            if (v.get(c).next.size() == 0) {
                continue;
            }
            double waterParcel = v.get(c).water / (double) v.get(c).next.size();
            for (Integer n : v.get(c).next) {
                v.get(n).water += waterParcel;
                next.add(n);
            }
            v.get(c).water = 0;
        }
        if (!next.isEmpty()) {
            handleWater(new ArrayDeque<>(next));
        }
    }

    static class Vertex {
        ArrayList<Integer> next = new ArrayList<>();
        double water;

        @Override
        public String toString() {
            return water + ":" + next;
        }
    }
}
