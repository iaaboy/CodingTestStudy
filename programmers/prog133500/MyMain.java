package prog133500;

import java.util.*;

/* 등대
 * https://school.programmers.co.kr/learn/courses/30/lessons/133500
 */

public class MyMain {
    public static void main(String[] args) {
        int n = 5;
        int[][] lighthouse = { { 1, 4 }, { 1, 3 }, { 1, 2 }, { 2, 3 }, { 5, 3 }, { 5, 2 } };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(n, lighthouse));
    }
}

class Solution {
    Vertex[] nodeList;

    public int solution(int n, int[][] lighthouse) {
        int lightCount = 0;
        nodeList = new Vertex[n + 1];
        PriorityQueue<Vertex> mQ = new PriorityQueue<>();

        for (int[] lh : lighthouse) {
            if (nodeList[lh[0]] == null) {
                nodeList[lh[0]] = new Vertex(lh[0]);
            }
            nodeList[lh[0]].node.add(lh[1]);

            if (nodeList[lh[1]] == null) {
                nodeList[lh[1]] = new Vertex(lh[1]);
            }
            nodeList[lh[1]].node.add(lh[0]);
        }

        for (Vertex vt : nodeList) {
            if (vt != null)
                mQ.add(vt);
        }

        // System.out.println(mQ);
        // System.out.println(Arrays.toString(nodeList));

        while (!mQ.isEmpty()) {
            Vertex curVtx = mQ.peek();
            Integer light;
            if (curVtx.isLighted || curVtx.node.size() == 0) {
                // System.out.println("poll: " + curVtx.id);
                mQ.poll();
                continue;
            }
            if (curVtx.node.size() == 1) {
                light = curVtx.node.get(0);
                nodeList[light].isLighted = true;
                lightCount++;
                for (int gd : nodeList[light].node) {
                    nodeList[gd].node.remove(light);
                }
                nodeList[light].node.clear();
            } else {
                light = 0;
                int maxNode = Integer.MIN_VALUE;
                for (int i = 0; i < curVtx.node.size(); i++) {
                    if (maxNode < nodeList[curVtx.node.get(i)].node.size()) {
                        maxNode = nodeList[curVtx.node.get(i)].node.size();
                        light = curVtx.node.get(i);
                    }

                }
                nodeList[light].isLighted = true;
                lightCount++;
                for (int gd : nodeList[light].node) {
                    nodeList[gd].node.remove(light);
                }
                nodeList[light].node.clear();
            }
            // System.out.println("light: " + light);
            // System.out.println("cur mQ: " + mQ);
        }

        return lightCount;
    }
}

class Vertex implements Comparable<Vertex> {
    int id;
    ArrayList<Integer> node;
    boolean isLighted = false;

    public Vertex(int id) {
        this.id = id;
        this.node = new ArrayList<Integer>();
    }

    @Override
    public int compareTo(Vertex o) {
        return node.size() - o.node.size();
    }

    @Override
    public String toString() {
        return id + ":" + isLighted + "|" + node.toString();
    }
}