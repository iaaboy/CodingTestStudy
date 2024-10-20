package prog132266;

import java.util.*;

/*
부대복귀
 * https://school.programmers.co.kr/learn/courses/30/lessons/132266
 */

public class MyMain {
    public static void main(String[] args) {
        int n = 3;
        int[][] roads = { { 1, 2 }, { 2, 3 } };
        int[] sources = { 2, 3 };
        int destination = 1;

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(n, roads, sources, destination)));
    }
}

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        HashMap<Integer, ArrayList<Integer>> vertex = new HashMap<>();
        PriorityQueue<Node> mNodes = new PriorityQueue<>();
        boolean[] isVisit = new boolean[n + 1];
        int[] minCost = new int[n + 1];

        for (int i = 0; i < minCost.length; i++)
            minCost[i] = -1;

        for (int[] r : roads) {
            if (!vertex.containsKey(r[0])) {
                vertex.put(r[0], new ArrayList<>());
            }
            if (!vertex.containsKey(r[1])) {
                vertex.put(r[1], new ArrayList<>());
            }
            vertex.get(r[0]).add(r[1]);
            vertex.get(r[1]).add(r[0]);
        }

        // System.out.println(vertex);

        int currCost = 0;
        mNodes.add(new Node(currCost, destination));
        isVisit[destination] = true;

        while (!mNodes.isEmpty()) {
            Node currNode = mNodes.poll();
            minCost[currNode.vId] = currNode.accumlCost;
            currCost = currNode.accumlCost;
            // System.out.println("curr: " + currNode.vId + " , currAccu: " +
            // currNode.accumlCost);
            for (int a : vertex.get(currNode.vId)) {
                if (!isVisit[a]) {
                    isVisit[a] = true;
                    mNodes.add(new Node(currCost + 1, a));
                }
            }
        }

        // System.out.println(Arrays.toString(minCost));

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = minCost[sources[i]];
        }

        return answer;
    }
}

class Node implements Comparable<Node> {
    int accumlCost;
    int vId;

    public Node(int accumlCost, int vId) {
        this.accumlCost = accumlCost;
        this.vId = vId;
    }

    @Override
    public int compareTo(Node o) {
        return accumlCost - o.accumlCost;
    }
}