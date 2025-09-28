package acmicpc17469;

import java.io.*;
import java.util.*;

/* 트리의 색깔과 쿼리 
 * https://www.acmicpc.net/problem/17469
 */

public class Main {
    static int[] groupId;
    static Vertex[] v;
    static HashSet<Integer>[] groupColors;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        v = new Vertex[N + 1];
        for (int i = 0; i <= N; i++) {
            v[i] = new Vertex();
            v[i].parent = i;
        }
        for (int i = 2; i <= N; i++) {
            int parent = Integer.parseInt(bf.readLine());
            v[parent].node.add(i);
            v[i].parent = parent;
            v[i].oldParent = parent;
        }
        for (int i = 1; i <= N; i++) {
            v[i].color = Integer.parseInt(bf.readLine());
        }

        groupColors = new HashSet[N + 1];
        for (int i = 0; i <= N; i++) {
            groupColors[i] = new HashSet<>();
        }

        int[][] q = new int[N - 1 + Q][2];
        for (int i = 0; i < N + Q - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if (cmd == 1) { // cut
                int parent = v[number].parent;
                v[parent].node.remove((Integer) number);
                v[number].parent = number;
            }
            q[i][0] = cmd;
            q[i][1] = number;
        }

        groupId = new int[N + 1];
        int gIndex = 1;
        for (int i = 1; i <= N; i++) {
            if (groupId[i] == 0) {
                groupId[i] = gIndex;
                setGroup(i, gIndex);
                gIndex++;
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = N + Q - 2; i >= 0; i--) {
            if (q[i][0] == 1) { // 연결
                joinGroup(q[i][1]);
            } else { // query
                int root = getUnion(groupId[q[i][1]]);
                result.add(groupColors[root].size()); // distinct 색상 개수
            }
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.print(sb);
    }

    private static void setGroup(int node, int gId) {
        groupColors[gId].add(v[node].color);

        if (groupId[v[node].parent] == 0) {
            groupId[v[node].parent] = gId;
            setGroup(v[node].parent, gId);
        }

        for (int child : v[node].node) {
            if (groupId[child] == 0) {
                groupId[child] = gId;
                setGroup(child, gId);
            }
        }
    }

    private static void joinGroup(int node) {
        int groupA = getUnion(groupId[v[node].oldParent]);
        int groupB = getUnion(groupId[node]);
        if (groupA == groupB)
            return;

        // 작은 그룹을 큰 그룹에 합치기
        if (groupColors[groupA].size() < groupColors[groupB].size()) {
            int tmp = groupA;
            groupA = groupB;
            groupB = tmp;
        }

        setUnion(groupA, groupB);

        groupColors[groupA].addAll(groupColors[groupB]);
        groupColors[groupB].clear();
    }

    static class Vertex {
        int color;
        int parent;
        int oldParent;
        HashSet<Integer> node = new HashSet<>();
    }

    private static int getUnion(int x) {
        if (groupId[x] != x) {
            groupId[x] = getUnion(groupId[x]);
        }
        return groupId[x];
    }

    private static void setUnion(int from, int to) {
        int rootA = getUnion(from);
        int rootB = getUnion(to);
        if (rootA == rootB)
            return;
        groupId[rootB] = rootA;
    }
}
