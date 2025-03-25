package acmicpc14725;

import java.io.*;
import java.util.*;

/* 개미굴
 * https://www.acmicpc.net/problem/14725
depth에 맞게 각각의 이름을 tree로 구성하되, 
노드에 중복이 없게 하기 위해 HashMap으로 노드를 구성.
프린트는 각 노드를 재귀 호출.
 */

public class Main {
    static StringBuilder treeSb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Cave root = new Cave("");
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            Cave curC = root;
            for (int j = 0; j < n; j++) {
                curC = curC.add(st.nextToken());
            }
        }

        printTree(root, 0);

        // System.out.println(root);
        System.out.println(treeSb);

    }

    private static void printTree(Cave cave, int depth) {
        String depthString = "";
        for (int i = 0; i < depth; i++) {
            depthString += "--";
        }
        List<String> keyList = new ArrayList<>(cave.downStairs.keySet());
        keyList.sort(null);
        for (String key : keyList) {
            treeSb.append(depthString).append(key).append("\n");
            printTree(cave.downStairs.get(key), depth + 1);
        }
    }

    static class Cave {
        String name;

        public Cave(String name) {
            this.name = name;
        }

        public Cave add(String nextC) {
            if (!downStairs.containsKey(nextC)) {
                downStairs.put(nextC, new Cave(nextC));
            }
            return downStairs.get(nextC);
        }

        HashMap<String, Cave> downStairs = new HashMap<>();

        @Override
        public String toString() {
            return name + ":" + downStairs;
        }
    }
}
