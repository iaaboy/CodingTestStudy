package acmicpc17073;

import java.util.*;
import java.io.*;

/* 나무 위의 빗물
 * https://www.acmicpc.net/problem/17073
 */

public class Main {
    static ArrayList<ArrayList<Integer>> v = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        double W = Double.parseDouble(st.nextToken());
        for (int i = 0; i <= N; i++) {
            v.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v.get(a).add(b);
            v.get(b).add(a);
        }
        traverse(0, 1);
        System.out.printf("%.7f", (W / count));
    }

    private static void traverse(int parent, int son) {
        boolean hasSon = false;
        // System.out.println("visit: " + parent + "," + son);
        for (Integer s : v.get(son)) {
            if (s == parent)
                continue;
            hasSon = true;
            traverse(son, s);
        }
        if (!hasSon) {
            count++;
        }
    }
}