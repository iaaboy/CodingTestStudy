package prog42627;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };

        Solution mSol = new Solution();
        System.out.println(mSol.solution(jobs));
    }
}

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> todo = new PriorityQueue<>((a, b) -> {
            if (a.start > b.start) {
                return 1;
            } else if (a.start == b.start) {
                return a.duration > b.duration ? 1 : -1;
            } else
                return -1;
        });

        for (int[] j : jobs) {
            todo.add(new Job(j[0], j[1], 0));
        }

        System.out.println(todo);

        int currT = 0;
        int durationTotal = 0;

        while (!todo.isEmpty()) {
            Job curJ = todo.poll();
            durationTotal += curJ.duration + curJ.wait;
            System.out.println("handle: " + curJ + " ," + durationTotal);
            currT = curJ.start + curJ.duration;

            while (!todo.isEmpty() && currT > todo.peek().start) {
                // 지난거 뽑아서 대기 udate
                Job nextTodo = todo.poll();
                // nextTodo.duration += currT - nextTodo.start;
                nextTodo.wait += currT - nextTodo.start;
                nextTodo.start = currT;
                System.out.println("currentT:" + currT + ", put: " + nextTodo);
                todo.add(nextTodo);
            }
        }

        System.out.println(todo);

        return durationTotal / jobs.length;
    }
}

class Job {
    int start;
    int duration;
    int wait;

    public Job(int start, int duration, int wait) {
        this.start = start;
        this.duration = duration;
        this.wait = wait;
    }

    @Override
    public String toString() {
        return start + "-" + duration + "-" + wait;
    }
}