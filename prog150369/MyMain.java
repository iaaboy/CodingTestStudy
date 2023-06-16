package prog150369;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[] deli = { 1, 0, 3, 1, 2 };
        int[] pick = { 0, 3, 0, 4, 0 };
        int cap = 4;
        int n = 5;
        Solution mSol = new Solution();
        System.out.println(mSol.solution(
                cap, n,
                deli, pick));
    }
}

class Solution {
    PriorityQueue<Work> deliverQ = new PriorityQueue<>();
    PriorityQueue<Work> pickupQ = new PriorityQueue<>();

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;

        for (int i = 0; i < deliveries.length; i++) {
            if (deliveries[i] > 0)
                deliverQ.add(new Work(deliveries[i], i + 1));
        }
        for (int i = 0; i < pickups.length; i++) {
            if (pickups[i] > 0)
                pickupQ.add(new Work(pickups[i], i + 1));
        }

        long sumDist = 0;

        // System.out.println(deliverQ);
        // System.out.println(pickupQ);

        while (!deliverQ.isEmpty() || !pickupQ.isEmpty()) {
            int dCap = cap;
            int pCap = cap;
            // cap이 0 될때까지 뽑는다.

            sumDist += Math.max(deliverQ.isEmpty() == true ? 0 : deliverQ.peek().dist, pickupQ.isEmpty() == true ? 0 : pickupQ.peek().dist);
            while (!deliverQ.isEmpty()) {
                int load = deliverQ.peek().load;
                if (dCap >= load) {
                    dCap -= load;
                    deliverQ.poll();
                } else if (dCap == load) {
                    dCap -= load;
                    deliverQ.poll();
                    break;
                } else {
                    deliverQ.peek().load -= dCap;
                    dCap = 0;
                    break;
                }
            }
            while (!pickupQ.isEmpty()) {
                int load = pickupQ.peek().load;
                if (pCap >= load) {
                    pCap -= load;
                    pickupQ.poll();
                } else if (pCap == load) {
                    pCap -= load;
                    pickupQ.poll();
                    break;
                } else {
                    pickupQ.peek().load -= pCap;
                    pCap = 0;
                    break;
                }
            }

            // System.out.println("sum : " + sumDist);
            // System.out.println(deliverQ);
            // System.out.println(pickupQ);
        }

        answer = sumDist * 2;

        return answer;
    }
}

class Work implements Comparable<Work> {
    int load;
    int dist;

    public Work(int load, int dist) {
        this.load = load;
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "l:" + load + " ,d:" + dist;
    }

    @Override
    public int compareTo(Work o) {
        return o.dist - dist;
    }
}