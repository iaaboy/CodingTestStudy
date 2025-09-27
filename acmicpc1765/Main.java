package acmicpc1765;

import java.io.*;
import java.util.*;

/* 닭싸움 팀 정하기
 * https://www.acmicpc.net/problem/1765
 */

public class Main {
    static Student[] s;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        s = new Student[N];
        for (int i = 0; i < N; i++) {
            s[i] = new Student(i);
        }
        int K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String relation = st.nextToken();
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            if (relation.contentEquals("E")) {
                s[from].e.add(to);
                s[to].e.add(from);
            } else {
                s[from].f.add(to);
                s[to].f.add(from);
            }
        }
        for (int i = 0; i < N; i++) {
            for (Integer friend : s[i].f) {
                if (getUnion(s[i].gId) != getUnion(s[friend].gId)) {
                    setUnion(i, friend);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (Integer ene : s[i].e) {
                for (Integer enemy : s[ene].e) {
                    if (getUnion(s[i].gId) != getUnion(s[enemy].gId)) {
                        setUnion(i, enemy);
                    }
                }
            }
        }

        HashSet<Integer> ids = new HashSet<>();
        for (int i = 0; i < N; i++) {
            ids.add(getUnion(s[i].gId));
        }
        System.out.println(ids.size());
    }

    static class Student {
        int gId;

        public Student(int gId) {
            this.gId = gId;
        }

        ArrayList<Integer> f = new ArrayList<>();
        ArrayList<Integer> e = new ArrayList<>();
    }

    private static int getUnion(int from) {
        int f = from;
        while (s[f].gId != f) {
            f = s[f].gId;
        }

        if (from != f) { // key !!! Union find 의 while loop를 줄임
            s[from].gId = f;
        }

        return f;
    }

    private static void setUnion(int from, int to) {
        int f = from;
        while (s[f].gId != f) {
            f = s[f].gId;
        }
        int t = to;
        while (s[t].gId != t) {
            t = s[t].gId;
        }
        if (f > t) {
            s[f].gId = t;
        } else {
            s[t].gId = f;
        }
    }
}
