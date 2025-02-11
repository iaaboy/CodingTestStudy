package acmicpc2911;

import java.io.*;
import java.util.*;

/* 전화 복구
 * https://www.acmicpc.net/problem/2911
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Station[] s = new Station[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            s[i] = new Station(p, c);
        }

        Arrays.sort(s);

        long ans = s[0].c;

        for (int i = 1; i < N; i++) {
            ans += (long)Math.max(0, s[i].c - s[i - 1].c);
        }
        System.out.println(ans);
    }
}

class Station implements Comparable<Station> {
    int p, c;

    Station(int p, int c) {
        this.p = p;
        this.c = c;
    }

    @Override
    public int compareTo(Station other) {
        return p - other.p;
    }
}

/*
10 9
1 7
2 3
3 2
4 5
5 4
6 6
7 8
8 3
9 4
10 9
20
 */