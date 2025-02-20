package acmicpc1359;

import java.io.*;
import java.util.*;

/* 복권
 * https://www.acmicpc.net/problem/1359
 */

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> cList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        combination(visited, 0, M);

        int matchCount = 0;
        for (int i = 0; i < cList.size(); i++) {
            ArrayList<Integer> me = cList.get(i);
            for (int j = 0; j < cList.size(); j++) {
                if (i == j) {
                    matchCount++;
                    continue;
                }
                ArrayList<Integer> you = cList.get(j);
                boolean cmp = compareEach(me, you, K);
                if (cmp) {
                    matchCount++;
                }
            }
        }
        double mCount = (double) matchCount;

        // System.out.println(matchCount + " : " + cList.size() * cList.size());
        double result = (double) mCount / ((double) cList.size() * (double) cList.size());
        System.out.println(result);
    }

    private static boolean compareEach(ArrayList<Integer> me, ArrayList<Integer> you, int k) {
        for (Integer n : me) {
            if (you.contains(n)) {
                k--;
                if (k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static void combination(boolean[] visited, int m, int r) {
        ArrayList<Integer> mList = new ArrayList<>();
        if (r == 0) {
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    mList.add(i + 1);
                }
            }
            // System.out.println(mList);
            cList.add(mList);
            return;
        }

        for (int i = m; i < N; i++) {
            visited[i] = true;
            combination(visited, i + 1, r - 1);
            visited[i] = false;
        }
    }
}
