package prog131129;

import java.util.*;

/* 카운트 다운
 * https://school.programmers.co.kr/learn/courses/30/lessons/131129
 */

public class MyMain {
    public static void main(String[] args) {
        int[] targets = { 100 };
        Solution mSol = new Solution();
        for (int t : targets)
            System.out.print(t + "-" + Arrays.toString(mSol.solution(t)) + ", ");
    }
}

class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int preCalclulatedBullet = 0;
        int preCalclulatedDart = 0;
        // if(target > 310) {
        // preCalclulatedBullet = 5 * (target / 300) ;
        // preCalclulatedDart = 5 * (target / 300) ;
        // target = target % 300;
        // }
        HashMap<Integer, Integer> ScoreSet = new HashMap<>();
        for (int i = 1; i <= 20; i++) {
            ScoreSet.put(i * 2, 0);
            ScoreSet.put(i * 3, 0);
        }
        for (int i = 1; i <= 20; i++) {
            ScoreSet.put(i, 1);
        }
        ScoreSet.put(50, 1);

        // System.out.println(ScoreSet);

        HashSet<Score> cur = new HashSet<>();
        HashSet<Score> next;

        cur.add(new Score(target, 0, 0));

        boolean hasResult = false;
        answer[0] = 0;
        answer[1] = 0;
        while (!cur.isEmpty()) {
            next = new HashSet<>();
            // System.out.println("cur: " + cur);
            for (Score sc : cur) {
                if (sc.remained == 0) {
                    // System.out.println("temp result: " + sc);
                    hasResult = true;
                    answer[1] = sc.bulls;
                    answer[0] = sc.darts;
                    continue;
                }
                for (int s : ScoreSet.keySet()) {
                    if (sc.remained >= s) {
                        Score newSC = new Score(sc.remained - s, sc.darts + 1, sc.bulls + ScoreSet.get(s));
                        // System.out.println(newSC);
                        if (!next.contains(newSC)) {
                            // System.out.println("put" + newSC);
                            next.add(newSC);
                        } else {
                        }
                    } else {
                        break;
                    }
                }
            }
            if (hasResult)
                break;
            cur = next;
        }

        // next.clear();
        answer[0] += preCalclulatedDart;
        answer[1] += preCalclulatedBullet;

        return answer;
    }

    class Score {
        int remained;
        int darts;
        int bulls;

        public Score(int remained, int dart, int bulls) {
            this.remained = remained;
            this.bulls = bulls;
            this.darts = dart;
        }

        @Override
        public String toString() {
            return remained + "," + bulls + "," + darts;
        }

        @Override
        public boolean equals(Object obj) {
            Score that = (Score) obj;
            return remained == that.remained && darts == that.darts && bulls == that.bulls;
        }

        @Override
        public int hashCode() {
            int result = remained * 31;
            result += darts * 31;
            result += bulls * 31;
            return result;
        }
    }
}
