package prog42892;

import java.util.*;

/* 길 찾기 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/42892
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
                { 2, 2 } };
        Solution mSol = new Solution();
        int[][] answer = mSol.solution(nodeinfo);
        mSol.printList(answer);
    }
}

class Solution {
    int answerIdx;
    int[][] answer;

    public int[][] solution(int[][] nodeinfo) {
        HashMap<Integer, Integer> idMap = new HashMap<>();
        int index = 1;
        for (int[] nd : nodeinfo) {
            idMap.put(nd[0], index++);
        }
        Arrays.sort(nodeinfo, (a, b) -> b[1] - a[1]); // y가 작은 순서로 sort
        // printList(nodeinfo);

        Tree mTree = new Tree(new Node(nodeinfo[0][1], nodeinfo[0][0]));
        for (int i = 1; i < nodeinfo.length; i++) {
            mTree.add(nodeinfo[i][1], nodeinfo[i][0]);
        }

        answer = new int[2][nodeinfo.length];
        answerIdx = 0;
        tracePreOrder(mTree.roodNode, idMap);
        answerIdx = 0;
        tracePostOrder(mTree.roodNode, idMap);
        // System.out.println(Arrays.toString(answer[0]));
        // System.out.println(Arrays.toString(answer[1]));
        return answer;
    }

    private void tracePreOrder(Node node, HashMap<Integer, Integer> idMap) {
        // System.out.println(idMap.get(node.x));
        answer[0][answerIdx++] = idMap.get(node.x);
        if (node.leftSon != null) {
            tracePreOrder(node.leftSon, idMap);
        }
        if (node.rightSon != null) {
            tracePreOrder(node.rightSon, idMap);
        }
    }

    private void tracePostOrder(Node node, HashMap<Integer, Integer> idMap) {
        if (node.leftSon != null) {
            tracePostOrder(node.leftSon, idMap);
        }
        if (node.rightSon != null) {
            tracePostOrder(node.rightSon, idMap);
        }
        answer[1][answerIdx++] = idMap.get(node.x);
        // System.out.println(idMap.get(node.x));
    }

    void printList(int[][] nd) {
        for (int[] n : nd) {
            System.out.println(Arrays.toString(n));
        }
    }

    class Tree {
        Node roodNode;

        public Tree(Node roodNode) {
            this.roodNode = roodNode;
        }

        public void add(int y, int x) {
            Node curNode = roodNode;
            while (true) {
                if (curNode.x > x) {
                    if (curNode.leftSon == null) {
                        curNode.leftSon = new Node(y, x);
                        break;
                    } else {
                        curNode = curNode.leftSon;
                    }
                } else {
                    if (curNode.rightSon == null) {
                        curNode.rightSon = new Node(y, x);
                        break;
                    } else {
                        curNode = curNode.rightSon;
                    }
                }
            }
        }
    }

    class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        Node parent;
        Node leftSon;
        Node rightSon;
    }
}