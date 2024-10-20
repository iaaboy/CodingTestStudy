package prog86971;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[][][] wires = {
                { { 1, 2 }, { 2, 7 }, { 3, 4 }, { 3, 7 }, { 4, 5 }, { 6, 7 } }
                // {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}},
                // { { 1, 2 }, { 1, 3 }, { 4, 5 }, { 5, 6 }, { 6, 7 }, { 6, 8 }, { 1, 4 } },

        };
        int[] n = { 7, /* 9,8 */ };

        Solution mSol = new Solution();

        for (int i = 0; i < n.length; i++) {
            System.out.println("result: " + mSol.solution(n[i], wires[i]));
        }
    }
}

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;

        Tree myTree = new Tree(wires[0][0], n);

        boolean[] isHandled = new boolean[wires.length];
        boolean handled = false;
        int handledCount = 0;
        while (handledCount < wires.length) {
            for (int i = 0; i < wires.length; i++) {
                handled = false;
                if (!isHandled[i]) {
                    handled = myTree.addVt(myTree.root, wires[i][0], wires[i][1]);
                }

                if (handled) {
                    isHandled[i] = true;
                    handledCount++;
                } else {
                    // System.out.println("Not handled");
                }
            }
        }
        myTree.calcChild();
        int re = myTree.calcMid(n);
        answer = Math.abs(re);
        return answer;
    }
}

class Tree {
    Vt root;
    int vtCount;

    Tree(int rootVt, int count) {
        root = new Vt(rootVt);
        vtCount = count;
    }

    public int calcMid(int n) {
        int min = n + 1;
        // n과 차이가 가장 작은 값.

        Queue<Vt> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Vt currentVt = q.poll();
            // System.out.println("calcMid: " + currentVt);
            if (Math.abs(n - 2 * currentVt.childCount) < min) {
                min = Math.abs(n - 2 * currentVt.childCount);
                // System.out.println("calcMid update candidate : " + currentVt + ", min:" +
                // min);
            }
            for (Vt nextVt : currentVt.next) {
                q.add(nextVt);
            }
        }
        ;
        return min;
    }

    public void calcChild() {
        while (!dfs())
            ;
    }

    public boolean dfs() {
        boolean isCheckAllChild = true;
        int countChild = 0;
        Queue<Vt> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Vt currentVt = q.poll();
            // System.out.println(currentVt);
            countChild = 0;
            boolean isCheckCurrentChild = true;

            if (currentVt.childCount != -1) {
                continue;
            }
            for (Vt nextVt : currentVt.next) {
                q.add(nextVt);
                if (nextVt.childCount != -1) {
                    countChild += nextVt.childCount;
                } else {
                    isCheckAllChild = false;
                    isCheckCurrentChild = false;
                }
            }
            if (isCheckCurrentChild) {
                currentVt.childCount = countChild + 1;
            }
        }
        if (isCheckAllChild) {
            // root.childCount = countChild + 1;
        }
        return isCheckAllChild;
    }

    public boolean addVt(Vt currentV, int a, int b) {
        // id가 있음 연결,
        if (currentV.id == a) {
            System.out.println("cur: " + currentV.id + " addNext: " + b);
            currentV.next.add(new Vt(b));
            return true;
        } else if (currentV.id == b) {
            System.out.println("cur: " + currentV.id + " addNext: " + a);
            currentV.next.add(new Vt(a));
            return true;
        } else {
            for (Vt nextVt : currentV.next) {
                if (addVt(nextVt, a, b)) {
                    return true;
                }
            }
        }
        // System.out.println("Something wrong");

        // if(currentV.next.size() > 0) {
        // int[] ab = new int[1];
        // ab[10] = 0;
        // }

        return false;
    }
}

class Vt {
    int id;
    int childCount;
    ArrayList<Vt> next;

    Vt(int id) {
        this.id = id;
        childCount = -1;
        next = new ArrayList<Vt>();
    }

    @Override
    public String toString() {
        return id + ", " + next.size() + ", " + childCount;
    }
}