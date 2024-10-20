package prog17684;

import java.util.*;

/* [3차] 압축
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684
 */

public class MyMain {
    public static void main(String[] args) {
        String[] msgs = {
                "KAKAKA",
                "KAKAO",
                "TOBEORNOTTOBEORTOBEORNOT",
                "ABABABABABABABAB"
        };
        Solution mSol = new Solution();
        for (int i = 0; i < msgs.length; i++) {
            System.out.println(Arrays.toString(mSol.solution(msgs[i])));
        }
    }
}

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dict = new HashMap<>();
        ArrayList<Integer> mList = new ArrayList<>();
        int index = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(Character.toString(c), index++);
        }
        Integer valuePrev = 0;
        int startIndex = 0;
        while (startIndex < msg.length()) {
            int current = startIndex + 1;
            Integer value = null;
            valuePrev = 0;
            for (; current <= msg.length(); current++) {
                String sliced = msg.substring(startIndex, current);
                value = dict.get(sliced);
                if (value != null) {
                    // System.out.println("exist: " + sliced);
                    valuePrev = value;
                } else {
                    // System.out.println("no exist: " + sliced + " pr *** " + valuePrev);
                    mList.add(valuePrev);
                    dict.put(sliced, index++);
                    break;
                }
            }
            startIndex = current - 1;
        }
        // System.out.println(" pr *** " + valuePrev);
        mList.add(valuePrev);

        int[] answer = new int[mList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = mList.get(i);
        }
        return answer;
    }
}