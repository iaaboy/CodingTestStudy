package acmicpc14889;

import java.io.*;
import java.util.*;
/* 스타트와 링크
 * https://www.acmicpc.net/problem/14889
백트래킹
 */

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] team = new boolean[N];
        makeTeam(team, 0, 0);
        System.out.println(maxDiff);
    }

    static int maxDiff = Integer.MAX_VALUE;

    private static void makeTeam(boolean[] team, int at, int depth) {
        if (depth == N / 2) {
            // System.out.println(Arrays.toString(team));
            int ta = Math.abs(getAbility(team));
            maxDiff = Math.min(maxDiff, ta);
            return;
        }
        for (int i = at; i < N; i++) {
            team[i] = true;
            makeTeam(team, i + 1, depth + 1);
            team[i] = false;
        }
    }

    private static int getAbility(boolean[] team) {
        ArrayList<Integer> teamA = new ArrayList<>();
        ArrayList<Integer> teamB = new ArrayList<>();
        for (int i = 0; i < team.length; i++) {
            if (team[i]) {
                teamA.add(i);
            } else {
                teamB.add(i);
            }
        }
        int sumA = 0, sumB = 0;
        for (Integer a : teamA) {
            for (Integer a2 : teamA) {
                if (a == a2) {
                    continue;
                }
                sumA += arr[a][a2];
            }
        }
        for (Integer b : teamB) {
            for (Integer b2 : teamB) {
                if (b == b2) {
                    continue;
                }
                sumB += arr[b][b2];
            }
        }
        return sumA - sumB;
    }
}