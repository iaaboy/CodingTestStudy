package acmicpc9466;

import java.io.*;
import java.util.*;

/* 텀 프로젝트
 * https://www.acmicpc.net/problem/9466

 find root >> CIRCULAR인지 파악한다.
 visited에 현재 번호를 기록하고, 이번에 방문한적이 있으면 root탐색을 멈추고,
 이 과정에서 거쳐간 array에 CIRCULAR인것 (-1), CIRCULAR아닌것(-2)을 기록한다.
 CIRCULAR인것 counting해서 출력
 */

public class Main {
    static int[] arr;
    static int N;
    static int[] visit;
    static int CIRCULAR = -1;
    static int NON_CIRCULAR = -2;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr = new int[N + 1];
            visit = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if (visit[i] > 0) {
                    continue;
                }
                findRoot(i);
            }
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (arr[i] == CIRCULAR) {
                    count++;
                }
            }
            // System.out.println(Arrays.toString(visit));
            // System.out.println(Arrays.toString(arr));
            sb.append(N - count).append("\n");
        }
        System.out.print(sb);
    }

    static void findRoot(int num) {
        int current = num;
        if (arr[num] == num) {
            arr[num] = CIRCULAR;
        }
        while (true) {
            if (visit[current] == num) {
                setRoot(current);
                setRoot(num, current);
                return;
            }
            if (arr[current] < 0) {
                setRoot(num, current);
                return;
            }
            visit[current] = num;
            current = arr[current];
        }
    }

    private static void setRoot(int start, int end) {
        int current = start;
        while (current > 0 && (arr[current] > 0 && current != end)) {
            int temp = arr[current];
            arr[current] = NON_CIRCULAR;
            current = temp;
        }
    }

    private static void setRoot(int start) {
        int current = start;
        while (arr[current] != CIRCULAR) {
            int temp = arr[current];
            arr[current] = CIRCULAR;
            current = temp;
        }
    }
}
