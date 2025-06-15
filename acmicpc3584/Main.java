package acmicpc3584;

import java.io.*;
import java.util.*;

/* 가장 가까운 공통 조상
 * https://www.acmicpc.net/problem/3584
 */

public class Main {
    static Vertex[] v;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(bf.readLine());
            v = new Vertex[N + 1];
            for (int i = 0; i <= N; i++) {
                v[i] = new Vertex();
            }
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int son = Integer.parseInt(st.nextToken());
                v[son].parent.add(parent);
            }
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int me = Integer.parseInt(st.nextToken());
            int you = Integer.parseInt(st.nextToken());
            setVisit(me);
            int common = checkVisit(you);
            sb.append(common).append("\n");
        }
        System.out.print(sb);
    }

    private static int checkVisit(int n) {
        if (v[n].visit) {
            return n;
        } else {
            for (Integer parent : v[n].parent) {
                return checkVisit(parent);
            }
        }
        return -1;
    }

    private static void setVisit(int n) {
        v[n].visit = true;
        for (Integer parent : v[n].parent) {
            setVisit(parent);
        }
    }

    static class Vertex {
        boolean visit = false;
        ArrayList<Integer> parent = new ArrayList<>();
    }
}
