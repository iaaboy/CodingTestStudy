package acmicpc5639;

import java.io.*;
import java.util.*;

/* 이진 검색 트리
 * https://www.acmicpc.net/problem/5639
입력을 받아 이진트리 구성하고, 
구성된 트리를 후위 순회해서 출력.
 */

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        while (true) {
            String line = bf.readLine();
            if (line == null || line.contentEquals("")) {
                break;
            }
            int num = Integer.parseInt(line);
            if (root == null) {
                root = new Node(num, null);
            } else {
                root.addSon(num);
            }
        }

        traversePost(root);
        System.out.println(sb);
    }

    private static void traversePost(Node current) {
        if (current.left != null) {
            traversePost(current.left);
        }
        if (current.right != null) {
            traversePost(current.right);
        }
        sb.append(current.num).append("\n");
    }

    static class Node {
        int num;
        Node parent, left, right;

        public Node(int num, Node parent) {
            this.num = num;
            this.parent = parent;
        }

        public void addSon(int son) {
            if (num > son) {
                if (left == null) {
                    left = new Node(son, this);
                } else {
                    left.addSon(son);
                }
            } else {
                if (right == null) {
                    right = new Node(son, this);
                } else {
                    right.addSon(son);
                }
            }
        }

        @Override
        public String toString() {
            return num + "L" + left + " , " + right + ")";
        }
    }
}
