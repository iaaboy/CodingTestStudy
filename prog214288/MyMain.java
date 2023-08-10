package prog214288;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        // int k = 3;
        // int n = 5;
        // int[][] reqs = { { 10, 60, 1 }, { 15, 100, 3 }, { 20, 30, 1 }, { 30, 50, 3 },
        //         { 50, 40, 1 }, { 60, 30, 2 },
        //         { 65, 30, 1 }, { 70, 100, 2 } }; // 25
        // int k = 2;
        // int n = 3;
        // int[][] reqs = { { 5, 55, 2 }, { 10, 90, 2 }, { 20, 40, 2 }, { 50, 45, 2 }, {
        // 100, 50, 2 } }; // 90

        int k = 1;
        int n = 1;
        int[][] reqs = { { 10, 60, 1 }, { 15, 100, 1 }, { 20, 30, 1 }, { 30, 50, 1 },
                { 50, 40, 1 }, { 60, 30, 1 },
                { 65, 30, 1 }, { 70, 100, 1 } }; // 25

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
                for (int b = 0; b < cList.get(y).size(); b++) {
                    cList.get(y).get(b).delay = 0;
                }
            }
        }

        return delayList[y][x];
    }

    private void makeSelections(int countRemained, int[] assigned) {
        if (countRemained == 0) {
            int sum = 0;
            for (int i = 0; i < assigned.length; i++) {
                sum += getDelay(i, assigned[i] - 1);
            }

            // System.out.println("sum: " + sum + ", " + Arrays.toString(assigned));
            minAssigned = Math.min(sum, minAssigned);

            return;
        }
        for (int i = assigned.length - 1; i >= 0 ; i--) {
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


        while (index <= arrayList.size() || !mQ.isEmpty()) {

            // System.out.println("now: " + now + " , arrayList: " + arrayList);

            // 1 queue check
            while (!mQ.isEmpty() && now >= mQ.peek().ed) {
                // System.out.println(now + ": done" + mQ);
                mQ.poll();

                if (index == arrayList.size() && mQ.isEmpty()) {
                    break;
                }
            }

            // 2 list check
            while (index < arrayList.size()) {
                if (mQ.size() < max) {
                    arrayList.get(index).ed = arrayList.get(index).st + arrayList.get(index).delay
                            + arrayList.get(index).dur;
                    // System.out.println ("startWork : " + arrayList.get(index));
                    mQ.add(arrayList.get(index));
                    index++;
                } else { //대기를 늘려야함.
                    int start = arrayList.get(index).st + arrayList.get(index).delay;
                    if(start <= now) {
                        arrayList.get(index).delay += (mQ.peek().ed - arrayList.get(index).st);
                        delay += arrayList.get(index).delay;
                        // System.out.println("addDelay: " + arrayList.get(index).delay);
                    } else {
                        break;
                    }
                    // delayed
                }
            }

            // 3 시간 set
            if (!mQ.isEmpty()) {
                if (index >= arrayList.size()) {
                    now = mQ.peek().ed;
                } else
                    now = Math.min(mQ.peek().ed, arrayList.get(index).st + arrayList.get(index).delay);
            } else {
                if (index >= arrayList.size()) {
                    break;
                } else {
                    now = arrayList.get(index).st + arrayList.get(index).delay;
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

    @Override
    public String toString() {
        return "s:" + st + "|dur:" + dur + "|e:" + ed + "|del: " + delay;
    }
}