package acmicpc20040;

import java.io.*;
import java.util.*;

/* 사이클 게임
 * https://www.acmicpc.net/problem/20040
주어진 정점들을 union으로 만들고, 최초로 같은 rootid 를 가진 입력이 들어오면 답.
 */

public class Main {
    static int[] ids;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
        int unionNum = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(bf.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            if (unionNum == 0) {
                if (getUnion(p1) == getUnion(p2)) {
                    unionNum = i;
                } else {
                    setUnion(p1, p2);
                }
            }
        }
        System.out.println(unionNum);
        System.out.println(Arrays.toString(ids));
    }

    private static int getUnion(int from) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }

        if (from != f) { // key !!! Union find 의 while loop를 줄임
            ids[from] = f;
        }

        return f;
    }

    private static void setUnion(int from, int to) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }
        int t = to;
        while (ids[t] != t) {
            t = ids[t];
        }
        if (f > t) {
            ids[f] = t;
        } else {
            ids[t] = f;
        }
    }
}
