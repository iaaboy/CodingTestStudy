package acmicpc4386;

import java.io.*;
import java.util.*;

/* 별자리 만들기
 * https://www.acmicpc.net/problem/4386
최소 신장트리 문제
각 별자리로부터 다른 별자리까지 거리를 모두 저장하고,
거리자 짧은 노드부터
순환 안되는것 확인하고, setUnion 하면서 별들간의 거리를 합.
count다 되면 끝.
 */

public class Main {
    static int[] ids;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Star[] stars = new Star[N];
        ids = new int[N];
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(x, y);

            ids[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double diffX = stars[i].x - stars[j].x;
                double diffY = stars[i].y - stars[j].y;
                double distance = diffX * diffX + diffY * diffY;
                distance = Math.sqrt(distance);
                nodes.add(new Node(i, j, distance));
            }
        }
        nodes.sort(null);

        // System.out.println(nodes);

        N--;
        double totalDistance = 0;
        for (Node n : nodes) {
            if (getUnion(n.from) != getUnion(n.to)) {
                setUnion(n.from, n.to);
                totalDistance += n.distance;
                N--;
                if (N == 0) {
                    break;
                }
            }
        }

        System.out.println(totalDistance);
        // System.out.println(totalDistance + " : " + Arrays.toString(ids));

        // 작은 노드부터
        // 순환 안되는것 확인하고, setUnion
        // count다 되면 끝.

    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        double distance;

        public Node(int from, int to, double distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance > o.distance) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return from + "-" + to + "(" + distance + ")";
        }
    }

    private static int getUnion(int from) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }

        if (from != f) { // key !!! Union find 의 while loop를 줄임
            ids[from] = f;
        }

        return f;
    }

    private static void setUnion(int from, int to) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }
        int t = to;
        while (ids[t] != t) {
            t = ids[t];
        }
        if (f > t) {
            ids[f] = t;
        } else {
            ids[t] = f;
        }
    }

    static class Star {
        double x, y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}