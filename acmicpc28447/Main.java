package acmicpc28447;

import java.io.*;
import java.util.*;

/* 마라탕 재료 고르기
 * https://www.acmicpc.net/problem/28447
 */

public class Main {
    static int N;
    static int[][] combi;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        combi = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                combi[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[N];
        combination(visited, 0, K);
        int max = Integer.MIN_VALUE;
        for (ArrayList<Integer> cl : cList) {
            int tasteVal = getTaste(cl);
            max = Math.max(tasteVal, max);
        }
        // System.out.println(cList);
        System.out.println(max);
    }

    private static int getTaste(ArrayList<Integer> cl) {
        int sum = 0;
        for (int i = 0; i < cl.size(); i++) {
            for (int j = i + 1; j < cl.size(); j++) {
                sum += combi[cl.get(i)][cl.get(j)];
            }
        }
        return sum;
    }

    static ArrayList<ArrayList<Integer>> cList = new ArrayList<>();

    static void combination(boolean[] visited, int m, int r) {
        ArrayList<Integer> mList = new ArrayList<>();
        if (r == 0) {
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    mList.add(i);
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
