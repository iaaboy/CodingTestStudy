package prog214288;

import java.util.*;

/* 상담원 인원
 * https://school.programmers.co.kr/learn/courses/30/lessons/214288
 */
public class MyMain {
    public static void main(String[] args) {
        // int k = 3;
        // int n = 5;
        // int[][] reqs = { { 10, 60, 1 }, { 15, 100, 3 }, { 20, 30, 1 }, { 30, 50, 3 },
        // { 50, 40, 1 }, { 60, 30, 2 },
        // { 65, 30, 1 }, { 70, 100, 2 } }; // 25
        int k = 2;
        int n = 3;
        int[][] reqs = { { 5, 55, 2 }, { 10, 90, 2 }, { 20, 40, 2 }, { 50, 45, 2 }, {
                100, 50, 2 } }; // 90

        Solution mSol = new Solution();
        System.out.println("answer: " + mSol.solution(k, n, reqs));
    }
}

// id별 사람수 List
// ididAssigned

class Solution {
    int[][] delayMemo;
    HashMap<Integer, ArrayList<Plan>> planTable = new HashMap<>();

    static int[] arr;
    static int[] output;
    boolean isVisited[][][][][];

    public int solution(int k, int n, int[][] reqs) {
        int[] idAssigned = new int[k];
        delayMemo = new int[k][n - k + 1];

        Arrays.fill(idAssigned, 1);
        arr = new int[k];

        isVisited = new boolean[20][20][20][20][20];

        for (int i = 0; i < k; i++) {
            Arrays.fill(delayMemo[i], -1);
            arr[i] = i;
        }

        for (int[] req : reqs) {
            if (!planTable.containsKey(req[2])) {
                planTable.put(req[2], new ArrayList<>());
            }
            planTable.get(req[2]).add(new Plan(req[0], req[1]));
        }

        // System.out.println(planTable);

        makeSelections(n - k, idAssigned);

        return minidAssigned;
    }

    int minidAssigned = Integer.MAX_VALUE;

    int getDelay(int id, int maxAmend) {
        if (delayMemo[id][maxAmend] == -1) {
            delayMemo[id][maxAmend] = calcDelay(id + 1, maxAmend + 1);
        }

        return delayMemo[id][maxAmend];
    }

    private int calcDelay(int id, int maxAmend) {
        ArrayList<Plan> plan = planTable.get(id);
        PriorityQueue<Integer> mQ = new PriorityQueue<>();
        int index = 0;
        int now = 0;
        int delay = 0;

        if (plan == null)
            return 0;

        maxAmend = maxAmend > plan.size() ? plan.size() : maxAmend;

        for (; (index < maxAmend) && (index < plan.size()); index++) {
            Plan mP = plan.get(index);
            mQ.add(mP.st + mP.du);
        }
        now = mQ.peek();

        while (index < plan.size()) {
            now = mQ.poll();
            Plan cP = plan.get(index++);
            if (cP.st < now) {
                delay += now - cP.st;
                mQ.add(now + cP.du);
            } else {
                mQ.add(cP.st + cP.du);
            }
        }

        // System.out.println(id + "," + maxAmend + ":" + delay + ":" + plan);

        return delay;
    }

    private void makeSelections(int countRemained, int[] idAssigned) {
        if (countRemained == 0) {
            int sum = 0;
            for (int i = 0; i < idAssigned.length; i++) {
                sum += getDelay(i, idAssigned[i] - 1);
            }

            minidAssigned = Math.min(sum, minidAssigned);

            return;
        }
        int[] a = new int[5];

        for (int i = 0; i < idAssigned.length; i++) {
            idAssigned[i]++;
            for (int j = 0; j < i; j++) {
                a[i] = idAssigned[j];
            }
            if (!isVisited[a[4]][a[3]][a[2]][a[1]][a[0]]) {
                makeSelections(countRemained - 1, idAssigned);
                isVisited[a[4]][a[3]][a[2]][a[1]][a[0]] = true;
            }
            idAssigned[i]--;
        }
    }

}

class Plan {
    int st;
    int du;

    public Plan(int st, int du) {
        this.st = st;
        this.du = du;
    }

    @Override
    public String toString() {
        return "s:" + st + "|du:" + du;
    }
}