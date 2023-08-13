package prog131127;

import java.util.*;
/* 할인 행사
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
public class MyMain {
    public static void main(String[] args) {
        // String[] want = { "banana", "apple", "rice", "pork", "pot" };
        // int[] number = { 3, 2, 2, 2, 1 };
        // String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
        //         "pot", "banana", "apple", "banana" };
        // f , t, t, t, t, t, t, t, t, t, t, t, t,

        String [] want = {"apple"};
        int [] number = {10};
        String [] discount = {"banana", "banana", "banana", "banana", "banana",
        "banana", "banana", "banana", "banana", "banana"};

        Solution mSol = new Solution();
        System.out.println(mSol.solution(want, number, discount));
    }
}

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> pCount = new HashMap<>();

        int index = 0;
        for (String d : discount) {
            if (!pCount.containsKey(d)) {
                pCount.put(d, 0);
            }
            if (index >= 10) {
                pCount.put(d, pCount.get(d) + 1);
                pCount.put(discount[index - 10], pCount.get(discount[index - 10]) - 1);
            } else {
                pCount.put(d, pCount.get(d) + 1);
            }

            // System.out.println(index + ": " + pCount);
            index++;

            if (index >= 9) {
                boolean isOK = true;
                for (int i = 0; i < want.length; i++) {
                    if ( !pCount.containsKey(want[i]) || pCount.get(want[i]) < number[i]) {
                        isOK = false;
                        break;
                    }
                }
                if (isOK) {
                    answer++;
                }
            }

        }

        return answer;
    }
}