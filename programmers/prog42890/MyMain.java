package prog42890;

import java.util.*;

/* 후보키
 * https://school.programmers.co.kr/learn/courses/30/lessons/42890
 */

public class MyMain {
    public static void main(String[] args) {
        String[][] relation = { { "a", "1", "aaa", "c", "ng" },
                { "a", "1", "bbb", "e", "g" },
                { "c", "1", "aaa", "d", "ng" },
                { "d", "2", "bbb", "d", "ng" } };
        Solution mSol = new Solution();
        System.out.println("answer: " + mSol.solution(relation));
    };
}

class Solution {
    int keys, items;
    String[][] relation;
    ArrayList<Integer> uniqsKeys;
    int answer = 0;
    List<TreeSet<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        this.relation = relation;
        keys = relation[0].length;
        items = relation.length;
        PriorityQueue<TreeSet<Integer>> mQ = new PriorityQueue<>((a, b) -> {
            return a.size() - b.size();
        });

        for (int i = 0; i < keys; i++) {
            TreeSet<Integer> aa = new TreeSet<>();
            aa.add(i);
            mQ.add(aa);
        }

        while (!mQ.isEmpty()) {
            TreeSet<Integer> curArr = mQ.poll();
            // System.out.println(curArr);

            if (!isUniq(curArr)) {
                for (int i = curArr.last(); i < keys; i++) {
                    if (!curArr.contains(i)) {
                        TreeSet<Integer> aa = new TreeSet<>(curArr);
                        aa.add(i);
                        mQ.add(aa);
                    }
                }
            } else {
                if (isMinimal(curArr)) {
                    answer++;
                    candidateKeys.add(curArr);
                }
                // System.out.println("uniq: " + curArr);
            }
        }

        return answer == 0 ? 1 : answer;
    }

    boolean isUniq(TreeSet<Integer> curArr) {
        Set<String> myStringSet = new HashSet<>();

        for (int i = 0; i < items; i++) {
            String combined = "";
            for (int idx : curArr) {
                combined += (relation[i][idx]);
            }
            if (myStringSet.contains(combined)) {
                return false;
            } else {
                myStringSet.add(combined);
            }
        }
        return true;
    }

    boolean isMinimal(Set<Integer> key) {
        for (Set<Integer> candidateKey : candidateKeys) {
            if (key.containsAll(candidateKey))
                return false;
        }
        return true;
    }
}