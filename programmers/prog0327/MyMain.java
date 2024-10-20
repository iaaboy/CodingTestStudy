package prog0327;

import java.util.*;

//int[] picks = {1,1,0} ,String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone","iron", "iron", "diamond","diamond"}

public class MyMain {
    public static void main(String[] args) {
        int[] pics = { 1,1, 0 };
        String[] minerals = { "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone","iron", "iron", "diamond","diamond" };
        System.out.println(new Solution().solution(pics, minerals));
    }
}

class Solution {
    int[] pMap;
    PriorityQueue<Packed> pQ;
    int[][] toolMap = {{1,1,1}, {5,1,1}, {25,5,1}};

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int sumPriority = 0;
        int i;
        int count = 0;

        pMap = new int[minerals.length];
        pQ = new PriorityQueue<>(Collections.reverseOrder());

        HashMap<String, Integer> priorityMap = new HashMap<>();
        priorityMap.put("diamond", 100);
        priorityMap.put("iron", 10);
        priorityMap.put("stone", 1);

        int toolCount = 0;
        for(int a : picks) {
            toolCount  += a;
        }

        for (i = 0; i < minerals.length; i++) {
            pMap[i] = priorityMap.get(minerals[i]);
            sumPriority += priorityMap.get(minerals[i]);
            count++;

            if (i % 5 + 1 == 5) {
                //System.out.println("i: " + i + ", " + sumPriority);
                pQ.add(new Packed(sumPriority, i-4, count));
                count = 0;
                sumPriority = 0;

                if(pQ.size() == toolCount)
                    break;
            }
        }
        if (sumPriority > 0) {
            //System.out.println("i: " + i + ", " + sumPriority);
            pQ.add(new Packed(sumPriority, minerals.length-minerals.length%5, count));
        }



        while(pQ.size() > 0) {
            System.out.println(pQ.peek().priority);
            if(toolCount == 0)
                break;
            Packed mins = pQ.peek();
            pQ.remove();
            toolCount --;

            //한번에 5개
            for(int p = 0; p < picks.length; p++) {
                if(picks[p] > 0) {
                    //툴 사용
                    for(int t = mins.start ; t< mins.start + mins.count ; t++) {
                        if(minerals[t].equals("diamond")) {
                            answer += toolMap[p][0];
                        } else if(minerals[t].equals("iron")) {
                            answer += toolMap[p][1];
                        } else if(minerals[t].equals("stone")) {
                            answer += toolMap[p][2];
                        }
                    }
                    //툴 사용 완료
                    picks[p]--;
                    break;
                }
            }
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
            if(this.priority > o.priority) {
                return 1;
            }
            return -1;/* 중요 -1이 아니면 결과가 제대로 안 나올 수 있음 */
        }

    }
}
