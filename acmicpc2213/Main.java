package acmicpc2213;

import java.io.*;
import java.util.*;

/* 트리의 독립집합
 * https://www.acmicpc.net/problem/2213
 */

public class Main {
    static Vertex[] v;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        v = new Vertex[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            v[i] = new Vertex(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            v[from].node.add(to);
            v[to].node.add(from);
        }
        updateDp(1, 0);
        // for (int i = 0; i <= N; i++) {
        // System.out.println(i + " : " + v[i]);
        // }

        travel(1, 0);

        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(v[1].dpYes, v[1].dpNo)).append("\n");
        for (int i = 1; i <= N; i++) {
            if (v[i].iAmUsed == 1) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
        // System.out.println(Arrays.toString(v));
    }

    private static void travel(int current, int parentsChoise) {
        if (parentsChoise == 1) {
            v[current].iAmUsed = 0;
        } else {
            v[current].iAmUsed = v[current].dpYes > v[current].dpNo ? 1 : 0;
        }
        for (Integer node : v[current].node) {
            if (v[node].iAmUsed == 2) {
                travel(node, v[current].iAmUsed);
            }
        }
    }

    private static void updateDp(int current, int parrent) {
        int yesSum = 0;
        int noSum = 0;
        for (Integer node : v[current].node) {
            if (node == parrent) {
                continue;
            }
            if (v[node].dpYes == -1) {
                updateDp(node, current);
            }
            yesSum += Math.max(v[node].dpNo, v[node].dpYes);
            noSum += v[node].dpNo;
        }
        v[current].dpYes = noSum + v[current].weight;
        v[current].dpNo = yesSum;
    }

    static class Vertex {
        int weight;
        int iAmUsed = 2; // 2 not decided, 1 used , 0 not used

        public Vertex(int weight) {
            this.weight = weight;
        }

        ArrayList<Integer> node = new ArrayList<>();
        int dpYes = -1;
        int dpNo = -1;

        @Override
        public String toString() {
            return weight + ", <" + iAmUsed + "> (" + dpYes + "/" + dpNo + ")" + node.toString();
        }
    }
}
