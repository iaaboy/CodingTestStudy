package prog42587;

import java.util.*;;

public class MyMain {
    public static void main(String[] args) {
        int[][] pri = { { 2, 1, 3, 2 }, { 1, 1, 9, 1, 1, 1 } };
        int[] location = { 2, 0 };

        Solution mSol = new Solution();

        for (int i = 0; i < 2; i++) {
            System.out.println(mSol.solution(pri[i], location[i]));
        }
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> {
            return a < b ? 1 : -1;
        });
        Queue<Process> processQ = new LinkedList<>();

        int index = 0;
        for (int p : priorities) {
            pQ.add(p);
            processQ.add(new Process(p, index++ == location ? true : false));
        }

        int ranCount = 0;
        while (!processQ.isEmpty()) {
            Process cPro = processQ.poll();

            // System.out.println(cPro + ": " + ranCount);

            if (cPro.priority == pQ.peek()) {
                // top priority이므로 실행
                ranCount++;
                pQ.remove();
                System.out.println("run: " + cPro.priority + ", " + cPro.isLocation + " ranCount: " + ranCount);

                if (cPro.isLocation) {
                    return ranCount;
                }
            } else {
                processQ.add(cPro);
            }
        }

        return answer;
    }
}

class Process {
    int priority;
    boolean isLocation;

    public Process(int priority, boolean isLocation) {
        this.priority = priority;
        this.isLocation = isLocation;
    }

    @Override
    public String toString() {
        return priority + "," + isLocation;
    }
}