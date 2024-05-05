package progLevel1;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */

public class MyMain {
    public static void main(String[] args) {
        String[] strings = {
                "abce", "abcd", "cdx"
        };
        Solution mSol = new Solution();

        System.out.println(Arrays.toString(mSol.solution(strings, 2)));
    }
}

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            if (a.charAt(n) == b.charAt(n)) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
                return 1;
            } else {
                return a.charAt(n) - b.charAt(n);
            }
        });
        return strings;
    }
}