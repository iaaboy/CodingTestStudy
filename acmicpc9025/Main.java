package acmicpc9025;

import java.io.*;
import java.util.*;

/* Widest Path
 * https://www.acmicpc.net/problem/9025
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        // StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Vertex[] c = new Vertex[N + 1];
            for (int i = 0; i <= N; i++) {
                c[i] = new Vertex();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                c[from].nds.add(new Node(to, cost));
                c[to].nds.add(new Node(from, cost));
            }
            int[] distance = new int[N + 1];
            PriorityQueue<Node> pQ = new PriorityQueue<>((a, b) -> b.cost - a.cost);
            distance[start] = Integer.MAX_VALUE;
            pQ.add(new Node(start, Integer.MAX_VALUE));
            while (!pQ.isEmpty()) {
                Node cRoad = pQ.poll();
                // System.out.println(cRoad + Arrays.toString(distance));
                Vertex cow = c[cRoad.target];
                if (cRoad.target == end) {
                    // System.out.println("out: " + cRoad);
                    break;
                }
                for (Node n : cow.nds) {
                    int minVal = Math.min(cRoad.cost, n.cost);
                    if (minVal > distance[n.target]) {
                        distance[n.target] = minVal;
                        pQ.add(new Node(n.target, minVal));
                    }

                }
            }
            pQ.clear();
            // sb.append(distance[end] + "\n");
            System.out.println(distance[end]);

            // System.out.println(Arrays.toString(distance));
        }
        // System.out.print(sb);
    }

    static class Vertex {
        ArrayList<Node> nds = new ArrayList<>();
    }

    static class Node {
        int target;
        int cost;
        public Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
        @Override
        public String toString() {
            return target + "," + cost;
        }
    }
}