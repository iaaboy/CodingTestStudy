package prog214288;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int k = 3;
        int n = 5;
        int[][] reqs = { { 10, 60, 1 }, { 15, 100, 3 }, { 20, 30, 1 }, { 30, 50, 3 },
        { 50, 40, 1 }, { 60, 30, 2 },
        { 65, 30, 1 }, { 70, 100, 2 } }; // 25
        // int k = 2;
        // int n = 4;
        // int[][] reqs = { { 5, 55, 2 }, { 10, 90, 2 }, { 20, 40, 2 }, { 50, 45, 2 }, {
        // 100, 50, 2 } }; // 90

        // int k = 2;
        // int n = 5;
        // int[][] reqs = { { 10, 50, 1 }, { 20, 20, 1 }, { 39, 20, 1 } }; // 25

        Solution mSol = new Solution();
        System.out.println("answer: " + mSol.solution(k, n, reqs));
    }
}


//id별 사람수 List
//ididAssigned


class Solution {
    int[][] delayMemo;
    HashMap<Integer, ArrayList<Plan>> planTable = new HashMap<>();

    public int solution(int k, int n, int[][] reqs) {
        int[] idAssigned = new int[k];
        delayMemo = new int[k][n - k + 1];

        for (int i = 0; i < k; i++)
                Arrays.fill(delayMemo[i],-1);

        for (int[] req : reqs) {
            if (!planTable.containsKey(req[2])) {
                planTable.put(req[2], new ArrayList<>());
            }
            planTable.get(req[2]).add(new Plan(req[1], req[0]));
        }

        makeSelections(n - k, idAssigned);

        return minidAssigned;
    }

    int minidAssigned = Integer.MAX_VALUE;

    int getDelay(int y, int x) {
        return delayMemo[y][x];
    }

    private void makeSelections(int countRemained, int[] idAssigned) {
        System.out.println("r:" + countRemained + " " + Arrays.toString(idAssigned));
        if (countRemained == 0) {
            int sum = 0;
            for (int i = 0; i < idAssigned.length; i++) {
                sum += getDelay(i, idAssigned[i] - 1);
            }

            // System.out.println("sum: " + sum + ", " + Arrays.toString(idAssigned));
            minidAssigned = Math.min(sum, minidAssigned);

            return;
        }
        // for (int i = idAssigned.length - 1; i >= 0 ; i--) {
        for (int i = 0; i < idAssigned.length; i++) {
            idAssigned[i]++;
            makeSelections(countRemained - 1, idAssigned);
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