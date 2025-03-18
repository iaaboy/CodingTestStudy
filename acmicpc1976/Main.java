package acmicpc1976;

import java.io.*;
import java.util.*;

/* 여행 가자
 * https://www.acmicpc.net/problem/1976
제공된 경유지에 대해 노드로 연결되었는지 판단하는 문제이므로,
주어진 경로를 기준으로 Unionfind 를 통해 인접한 도시를 grouping하고, 
제공된 여행 경우지가 같은 groupID가 아니면 No. 같은 그룹이면 Yes.
Unionfind 주의할 점. 성능을 높이기 위해 Union되었을 경우 같은 그룹으로 id를 업데이트함(updatePath 함수)
 */

public class Main {
    static int[] cities;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        cities = new int[N];
        for (int i = 0; i < N; i++) {
            cities[i] = i;
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    setUnion(i, j);
                }
            }
        }
        // System.out.println(Arrays.toString(cities));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean connected = true;
        int prevUId = findRoot(Integer.parseInt(st.nextToken()) - 1);
        for (int i = 1; i < M; i++) {
            if (findRoot(Integer.parseInt(st.nextToken()) - 1) != prevUId) {
                connected = false;
            }
        }
        System.out.println(connected ? "YES" : "NO");
    }

    private static void setUnion(int a, int b) {
        int aRoot = findRoot(a);
        updatePath(a, aRoot);
        int bRoot = findRoot(b);
        updatePath(b, bRoot);
        if (aRoot < bRoot) {
            cities[bRoot] = aRoot;
        } else if (aRoot > bRoot) {
            cities[aRoot] = bRoot;
        }
    }

    private static int findRoot(int c) {
        while (cities[c] != c) {
            c = cities[c];
        }
        return c;
    }

    private static void updatePath(int from, int rootId) {
        while (cities[from] != rootId) {
            int temp = cities[from];
            cities[from] = rootId;
            from = cities[temp];
        }
    }
}