package prog49993;

import java.util.HashMap;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/49993
 */

public class MyMain {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

        Solution mSol = new Solution();

        System.out.println(mSol.solution(skill, skill_trees));
    }
}

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        HashMap<Character, Integer> skMap = new HashMap<>();

        for (int i = 0; i < skill.length(); i++) {
            skMap.put(skill.charAt(i), i);
        }

        for (String st : skill_trees) {
            // System.out.println("handle: " + st);
            int idx = 0;
            for (int i = 0; i < st.length(); i++) {
                if (skMap.containsKey(st.charAt(i))) {
                    // System.out.println("check it: " + st.charAt(i));
                    if (skMap.get(st.charAt(i)) == idx) {
                        // System.out.println("hit");
                        idx++;
                    } else {
                        // System.out.println("fail");
                        idx = -1;
                        break;
                    }
                } else {
                    // System.out.println("Skip it: " + st.charAt(i));
                }
            }
            if (idx == -1) {
                // System.out.println("fail!!!");
            } else {
                // System.out.println("sucess: " + st);
                answer++;
            }
        }

        return answer;
    }
}