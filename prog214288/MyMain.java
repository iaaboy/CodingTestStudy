package prog214288;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        // int k = 3;
        // int n = 5;
        // int[][] reqs = { { 10, 60, 1 }, { 15, 100, 3 }, { 20, 30, 1 }, { 30, 50, 3 },
        // { 50, 40, 1 }, { 60, 30, 2 },
        // { 65, 30, 1 }, { 70, 100, 2 } }; // 25
        // int k = 2;
        // int n = 4;
        // int[][] reqs = { { 5, 55, 2 }, { 10, 90, 2 }, { 20, 40, 2 }, { 50, 45, 2 }, {
        // 100, 50, 2 } }; // 90

        int k = 2;
        int n = 5;
        int[][] reqs = { { 10, 50, 1 }, { 20, 20, 1 }, { 39, 20, 1 } }; // 25

        Solution mSol = new Solution();
        System.out.println("answer: " + mSol.solution(k, n, reqs));
    }
}

class Solution {
    int[][] delayList;
    ArrayList<ArrayList<Consult>> cList;

    public int solution(int k, int n, int[][] reqs) {
        int[] assigned = new int[k];
        delayList = new int[k][n - k + 1];

        for (int i = 0; i < k; i++)
            for (int j = 0; j < n - k + 1; j++)
                delayList[i][j] = -1;

        cList = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            assigned[i] = 1;
            cList.add(new ArrayList<>());
        }

        for (int[] req : reqs) {
            cList.get(req[2] - 1).add(new Consult(req[0], req[1]));
        }

        makeSelections(n - k, assigned);

        return minAssigned;
    }

    int minAssigned = Integer.MAX_VALUE;

    int getDelay(int y, int x) {
        if (delayList[y][x] == -1) {
            if (cList.get(y).size() == 0) {
                delayList[y][x] = 0;
            } else {
                int delay = getDelayedTime(cList.get(y), x + 1);
                delayList[y][x] = delay;
            }
        }

        return delayList[y][x];
    }

    private void makeSelections(int countRemained, int[] assigned) {
        System.out.println("r:" + countRemained + " " + Arrays.toString(assigned));
        if (countRemained == 0) {
            int sum = 0;
            for (int i = 0; i < assigned.length; i++) {
                sum += getDelay(i, assigned[i] - 1);
            }

            // System.out.println("sum: " + sum + ", " + Arrays.toString(assigned));
            minAssigned = Math.min(sum, minAssigned);

            return;
        }
        // for (int i = assigned.length - 1; i >= 0 ; i--) {
        for (int i = 0; i < assigned.length; i++) {
            assigned[i]++;
            makeSelections(countRemained - 1, assigned);
            assigned[i]--;
        }
    }

    private int getDelayedTime(ArrayList<Consult> arrayList, int max) {
        int delay = 0;
        int index = 0;
        int now = arrayList.get(0).st;
        PriorityQueue<Consult> mQ = new PriorityQueue<>((a, b) -> {
            return a.ed - b.ed;
        });

        // System.out.println("max: " + max + ": " + arrayList);

        if (max > arrayList.size()) {
            return 0;
        }

        // max개 만큼 바로 시작
        for (int i = 0; i < max; i++) {
            // System.out.println ("now: " + now + " startWork : " + arrayList.get(index));
            mQ.add(new Consult(arrayList.get(index).st, 0, arrayList.get(index).st + arrayList.get(index++).dur));
        }

        while (index <= arrayList.size() || !mQ.isEmpty()) {

            // System.out.println("now:" + now + " , index:" + index + " , qSize:" +
            // mQ.size());

            // 1 queue check
            if (!mQ.isEmpty()) {
                // System.out.println(now + ": done" + mQ);
                now = mQ.poll().ed;
                if (index == arrayList.size() && mQ.isEmpty()) {
                    break;
                }
            }

            // 2 list check
            if (index < arrayList.size()) {
                if (mQ.size() < max) {
                    int currentDelay = now - arrayList.get(index).st;
                    if (currentDelay > 0) {
                        delay += currentDelay;
                    }
                    // System.out.println ("now: " + now + ", delay: " + currentDelay + "startWork :
                    // " + arrayList.get(index));
                    mQ.add(new Consult(now, 0, now + arrayList.get(index++).dur));
                }
            }
        }

        // System.out.println("delay: " + delay);
        return delay;
    }
}

class Consult {
    int st;
    int delay;
    int dur;
    int ed;

    public Consult(int st, int dur) {
        this.st = st;
        this.dur = dur;
    }

    public Consult(int st, int dur, int ed) {
        this.st = st;
        this.dur = dur;
        this.ed = ed;
    }

    @Override
    public String toString() {
        return "s:" + st + "|du:" + dur + "|e:" + ed;
    }
}