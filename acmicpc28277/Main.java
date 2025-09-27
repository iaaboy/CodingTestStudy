package acmicpc28277;

import java.io.*;
import java.util.*;

/* 뭉쳐야 산다
 * https://www.acmicpc.net/problem/28277
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        HashSet<Integer>[] numSets = new HashSet[N + 1];
        for (int i = 0; i <= N; i++) {
            numSets[i] = new HashSet<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            int c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c; j++) {
                numSets[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        StringBuilder sb = new StringBuilder();
        int id, from, to;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                to = Integer.parseInt(st.nextToken());
                from = Integer.parseInt(st.nextToken());

                if (numSets[from].isEmpty()) {
                    continue;
                }

                if (numSets[to].size() < numSets[from].size()) {
                    HashSet<Integer> tmp = numSets[to];
                    numSets[to] = numSets[from];
                    numSets[from] = tmp;
                }

                numSets[to].addAll(numSets[from]);
                numSets[from].clear();

            } else {
                id = Integer.parseInt(st.nextToken());
                sb.append(numSets[id].size()).append("\n");
            }
        }

        System.out.print(sb);
    }
}