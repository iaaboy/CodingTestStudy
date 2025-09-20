package acmicpc25691;

import java.io.*;
import java.util.*;

/* k개 트리 노드에서 사과를 최대로 수확하기
 * https://www.acmicpc.net/problem/25691
 */

public class Main {
    static boolean[][] map;
    static int N;
    static int [] apple;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new boolean[N][N];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = true;
        }
        apple = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            apple[i] = Integer.parseInt(st.nextToken());
        }

        int loopCount = (int) Math.pow(2, N);
        int appleCount = 0;
        for (int i = 0; i < loopCount; i++) {
            if ((i & (1 << 0)) > 0 && Integer.bitCount(i) <= K) {
                appleCount = Math.max(travelTree(i), appleCount);
            }
        }
        System.out.println(appleCount);
    }

    private static int travelTree(int availableBit) {
        // System.out.println(Integer.toBinaryString(availableBit) + ":" );
        Queue<Integer> q = new ArrayDeque<>();
        int count = apple[0];
        q.add(0);
        boolean [] visited = new boolean[N];
        visited[0] = true;
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i = 0; i < N; i++) {
                if (!visited[i] && map[c][i] && ((availableBit & (1 << i)) > 0)) {
                    q.add(i);
                    visited[i] = true;
                    count += apple[i];
                }
            }
        }

        return count;
    }
}
