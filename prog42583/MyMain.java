package prog42583;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int brL = 2;
        int wt = 10;
        int[] trs = { 7, 4, 5, 6 };

        Solution mSol = new Solution();

        System.out.println("answer: " + mSol.solution(brL, wt, trs));
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int curW = 0;
        int curT = 0;

        Queue<Truck> trAtBridg = new LinkedList<>();
        int idx = 0;
        int handled = 0;
        while (handled < truck_weights.length) {
            // 다리 위 트럭을 핸들
            if (!trAtBridg.isEmpty() && curT >= trAtBridg.peek().startT + bridge_length) {
                while (!trAtBridg.isEmpty() && curT >= trAtBridg.peek().startT + bridge_length) {
                    handled++;
                    curW -= trAtBridg.peek().wgt;
                    System.out.println(trAtBridg.peek() + ", " + curT);
                    trAtBridg.poll();
                }
            }
            // 다리에 얹을 수 있으면 하나 얹는다.
            if (trAtBridg.size() < bridge_length && idx < truck_weights.length && curW + truck_weights[idx] <= weight) {
                curW += truck_weights[idx];
                trAtBridg.add(new Truck(truck_weights[idx++], curT));
                System.out.println("q:" + trAtBridg);
            }
            // tick을 증가
            curT++;
        }
        //지금 tick을 리턴
        return curT;
    }
}

class Truck {
    int wgt;
    int startT;

    public Truck(int wgt, int startT) {
        this.wgt = wgt;
        this.startT = startT;
    }

    @Override
    public String toString() {
        return "wgt: " + wgt + ",t: " + startT;
    }
}