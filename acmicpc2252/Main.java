import java.io.*;
import java.util.*;

/* 줄 세우기
 * https://www.acmicpc.net/problem/2252
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Vertex[] v = new Vertex[N];
        for (int i = 0; i < N; i++) {
            v[i] = new Vertex();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int prio = Integer.parseInt(st.nextToken()) - 1;
            int rear = Integer.parseInt(st.nextToken()) - 1;

            v[rear].pCount++;
            v[prio].son.add(rear);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v.length; i++) {
            if (v[i].pCount <= 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int handleCount = q.size();
            for (int i = 0; i < handleCount; i++) {
                int cur = q.poll();
                sb.append(cur + 1).append(" ");
                for (Integer son : v[cur].son) {
                    v[son].pCount--;
                    if (v[son].pCount == 0) {
                        q.add(son);
                    }
                }
                v[cur].pCount = Integer.MAX_VALUE;
            }
        }
        System.out.println(sb);
    }

    static class Vertex {
        int pCount;

        ArrayList<Integer> son = new ArrayList<>();

        @Override
        public String toString() {
            return pCount + "," + son;
        }
    }
}
