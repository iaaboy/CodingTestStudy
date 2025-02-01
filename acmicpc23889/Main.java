package acmicpc23889;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] stone;
    static int[] town;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        town = new int[N + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            town[i] = Integer.parseInt(st.nextToken());
        }
        stone = new boolean[N + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            stone[Integer.parseInt(st.nextToken())] = true;
        }
        boolean[] wall = new boolean[N + 1];
        dfs(wall, 1, M, false, 0);
        for (Integer i : minList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int minSum = Integer.MAX_VALUE;
    static ArrayList<Integer> minList = new ArrayList<>();

    private static void dfs(boolean[] wall, int at, int m, boolean isRunning, int curSum) {
        if (m == 0) {
            // System.out.println(Arrays.toString(wall));

            boolean run = isRunning;
            int tempSum = 0;
            for (int j = at; j < wall.length; j++) {
                // wall false, isRunning true || stone true
                if (!wall[j] && (run || stone[j])) {
                    run = true;
                } else if (!wall[j] && (!run && !stone[j])) {
                    run = false;
                }
                if (wall[j]) {
                    run = false;
                }
                if (run) {
                    tempSum += town[j];
                    if (minSum <= tempSum + curSum) {
                        return;
                    }
                }
            }

            // System.out.println(tempSum + curSum);
            if (minSum > tempSum + curSum) {
                minSum = tempSum + curSum;
                minList.clear();;
                for (int i = 1; i < wall.length; i++) {
                    if (wall[i]) {
                        minList.add(i);
                    }
                }
            }

            return;
        }

        for (int i = at; i < wall.length; i++) {
            if (!wall[i]) {
                wall[i] = true;
                // i까지 curSum을 계산한다
                // System.out.println(at + "~" + i + ".." + (2 - m));
                boolean run = isRunning;
                int tempSum = 0;
                for (int j = at; j <= i; j++) {
                    // wall false, isRunning true || stone true
                    if (!wall[j] && (run || stone[j])) {
                        run = true;
                    } else if (!wall[j] && (!run && !stone[j])) {
                        run = false;
                    }
                    if (wall[j]) {
                        run = false;
                    }
                    if (run) {
                        tempSum += town[j];
                        if (curSum + tempSum >= minSum) {
                            wall[i] = false; 
                            return;
                        }
                    }
                }

                if (curSum + tempSum < minSum) {
                    dfs(wall, i + 1, m - 1, run, curSum + tempSum);
                } else {
                    
                }
                wall[i] = false;
            }
        }
    }
}
