package acmicpc9335;

import java.io.*;
import java.util.*;

/* 소셜 광고
 * https://www.acmicpc.net/problem/9335
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<HashSet<Integer>> friendMap;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(bf.readLine());
            friendMap = new ArrayList<>();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i;
                friendMap.add(new HashSet<Integer>());
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int d = Integer.parseInt(st.nextToken());
                for (int j = 0; j < d; j++) {
                    int you = Integer.parseInt(st.nextToken()) - 1;
                    friendMap.get(i).add(you);
                    friendMap.get(you).add(i);
                }
            }

            // for (int i = 0; i < N; i++) {
            // System.out.println(friendMap.get(i));
            // }

            boolean[] visited = new boolean[N];
            count = -1;
            for (int i = 1; i <= N; i++) {
                combination(arr, visited, 0, i);
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void combination(int[] arr, boolean[] visited, int m, int r) {
        if (count != -1) {
            return;
        }
        if (r == 0) {
            boolean[] fCheck = new boolean[N];
            int tempCount = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    int index = arr[i];
                    if (!fCheck[i]) {
                        fCheck[i] = true;
                        tempCount++; 
                    }
                    for (Integer f : friendMap.get(index)) {
                        if (!fCheck[f]) {
                            fCheck[f] = true;
                            tempCount++;
                        }
                    }
                }
            }
            if (tempCount >= N) {
                count = 0;
                for (int i = 0; i < visited.length; i++) {
                    if (visited[i]) {
                        count++;
                    }
                }
                // System.out.println("Hit: " + Arrays.toString(visited));
            }
            return;
        }

        for (int i = m; i < arr.length; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }
}


