package acmicpc2660;

import java.io.*;
import java.util.*;

/* 회장뽑기
 * https://www.acmicpc.net/problem/2660
각각을 시작 위치로 해서 가장 먼 노드를 계산 
 */

public class Main {
    static ArrayList <ArrayList<Integer>> candis = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int me = Integer.parseInt(st.nextToken());
        int you = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= N; i++) {
            candis.add(new ArrayList<>());
        }
        
        while (me != -1 && you != -1) {
            candis.get(me).add(you);
            candis.get(you).add(me);
            st = new StringTokenizer(bf.readLine());
            me = Integer.parseInt(st.nextToken());
            you = Integer.parseInt(st.nextToken());
        }
        int [] point = new int[N + 1];

        int min = Integer.MAX_VALUE;
        int maxCount = 0;
        for (int i = 1; i <= N; i++) {
            point[i] = getPoint(i);
            if (point[i] < min) {
                min = point[i];
                maxCount = 1;
            } else if (point[i] == min) {
                maxCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(maxCount).append("\n");
        for (int i = 1; i <= N; i++) {
            if (point[i] == min) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
        // System.out.println(Arrays.toString(point));
    }

    private static int getPoint(int start) {
        boolean [] visit = new boolean[N + 1];
        Queue<int []> q = new ArrayDeque<>();
        visit[start] = true;
        q.add(new int[]{start, 0});
        int [] c = null;
        while (!q.isEmpty()) {
            c = q.poll();
            for (Integer neighbor : candis.get(c[0])) {
                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    q.add(new int[]{neighbor, c[1] + 1});
                }
            }
        }

        return c[1];
    }
    
}
