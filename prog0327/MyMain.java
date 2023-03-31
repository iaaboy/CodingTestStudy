package prog0327;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MyMain {
    public static void main(String[] args) {
        int[] pics = { 1, 3, 2 };
        String[] minerals = { "diamond", "diamond", "stone", "stone", "stone", "diamond", "diamond", "iron" };
        System.out.println(new Solution().solution(pics, minerals));
    }
}

class Solution {
    int[] pMap;
    PriorityQueue<Packed> pQ;

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        pMap = new int[minerals.length];
        pQ = new PriorityQueue<>();

        HashMap<String, Integer> priorityMap = new HashMap<>();
        priorityMap.put("diamond", 100);
        priorityMap.put("iron", 10);
        priorityMap.put("stone", 1);

        int sumPriority = 0;
        int i;
        for (i = 0; i < minerals.length; i++) {
            pMap[i] = priorityMap.get(minerals[i]);
            sumPriority += priorityMap.get(minerals[i]);

            if (i % 5 + 1 == 5) {
                System.out.println("i: " + i + ", " + sumPriority);
                pQ.add(new Packed(sumPriority, i-4, 5));
                sumPriority = 0;
            }
        }
        if (sumPriority > 0) {
            System.out.println("i: " + i + ", " + sumPriority);
            pQ.add(new Packed(sumPriority, minerals.length-minerals.length%5, minerals.length%5));
            sumPriority = 0;            
            pQ.add(new Packed(30,1,2));
        }

        while(pQ.size() > 0) {
            System.out.println(pQ.peek().priority);
            pQ.remove();
        }

        return answer;
    }

    class Packed implements Comparable<Packed> {
        int priority;
        int start;
        int count;

        Packed(int priority, int start, int count) {
            this.priority = priority;
            this.count = count;
            this.start = start;
        }

        @Override
        public int compareTo(Packed o) {
            if(this.priority < o.priority) {
                return 1;
            }
            return 0;
        }

    }
}
