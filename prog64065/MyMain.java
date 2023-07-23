package prog64065;

import java.util.*;

/* 
튜플
https://school.programmers.co.kr/learn/courses/30/lessons/64065
*/

public class MyMain {
    public static void main(String[] args) {
        // String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s = "{{123}}";

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(s)));
    }
}

class Solution {
    public int[] solution(String s) {
        String[] elementStr = s.split("}");
        PriorityQueue<ArrayList<Integer>> elementQ = new PriorityQueue<ArrayList<Integer>>(
                (a, b) -> {
                    return b.size() - a.size();
                });

        for (String sp : elementStr) {
            sp = sp.replaceAll("[{]", "");
            String[] numList = sp.split(",");
            ArrayList<Integer> mList = new ArrayList<>();
            for (String numStr : numList) {
                if (!numStr.isEmpty()) {
                    Integer number = Integer.parseInt(numStr);
                    mList.add(number);
                }
            }
            elementQ.add(mList);
        }

        // System.out.println(elementQ);

        int[] answer = new int[elementQ.size()];
        int index = elementQ.size() - 1;
        ArrayList<Integer> currArr = elementQ.poll();
        ArrayList<Integer> nexArr;

        while (!elementQ.isEmpty()) {
            nexArr = elementQ.poll();
            currArr.removeAll(nexArr);

            // System.out.println(currArr);
            answer[index--] = currArr.get(0);
            currArr = nexArr;
        }
        // System.out.println(currArr);
        answer[index] = currArr.get(0);

        return answer;
    }
}