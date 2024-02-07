package prog12980;

import java.util.*;
/* 점프와 순간 이동
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */

public class MyMain {
    public static void main(String[] args) {
        int[] N = { 6, 5, 5000 };
        Solution mSol = new Solution();
        for (int n : N) {
            System.out.println(mSol.solution(n));
        }
    }
}

class Solution {
    HashMap<Integer, Integer> visited;

    public int solution(int n) {
        visited = new HashMap<>();
        PriorityQueue<InterState> pQ = new PriorityQueue<>((a, b) -> {
            return a.e - b.e;
        });

        pQ.add(new InterState(1, 1));
        visited.put(1, 1);

        int minEnergy = Integer.MAX_VALUE;
        while (!pQ.isEmpty()) {
            int curP = pQ.peek().p;
            int curE = pQ.poll().e;
            // System.out.println(curP + "," + curE);
            if (curP == n) {
                if (curE < minEnergy) {
                    minEnergy = curE;
                }
            } else if (curP > n) {
                continue;
            }
            if (curE > minEnergy) {
                return minEnergy;
            }

            if (curP + curP <= n && (!visited.containsKey(curP + curP) || visited.get(curP + curP) > curE)) {
                visited.put(curP + curP, curE);
                pQ.add(new InterState(curP + curP, curE));
            }
            if (curP + 1 <= n && (!visited.containsKey(curP + 1) || visited.get(curP + 1) > curE + 1)) {
                visited.put(curP + 1, curE + 1);
                pQ.add(new InterState(curP + 1, curE + 1));
            }
        }

        return minEnergy;
    }

    class InterState {
        int p;
        int e;

        public InterState(int p, int e) {
            this.p = p;
            this.e = e;
        }
    }
}