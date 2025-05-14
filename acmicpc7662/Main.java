package acmicpc7662;

import java.io.*;
import java.util.*;

/* 이중 우선순위 큐
 * https://www.acmicpc.net/problem/7662
 */

public class Main {
    static TreeMap<Long, Long> tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            tree = new TreeMap<>();
            int N = Integer.parseInt(bf.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String cmd = st.nextToken();
                long num = Long.parseLong(st.nextToken());
                char c = cmd.charAt(0);
                if (c == 'I') {
                    tree.put(num, tree.getOrDefault(num, 0L) + 1L);
                } else {
                    // D
                    if (tree.isEmpty()) {
                        continue;
                    }
                    Long key = num == -1 ? tree.firstKey() : tree.lastKey();
                    if (key != null) {
                        if (tree.get(key) == 1) {
                            tree.remove(key);
                        } else {
                            tree.put(key, tree.get(key) - 1);
                        }
                    }
                }
            }
            if (tree.size() == 0) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(tree.lastKey()).append(" ").append(tree.firstKey()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
