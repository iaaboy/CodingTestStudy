package prog67258;

import java.util.*;

/* 보석 쇼핑
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258
 */

public class MyMain {
    public static void main(String[] args) {
        String[][] gemArr = {
                { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" }, // {3, 7}
                { "AA", "AB", "AC", "AA", "AC" }, // {1, 3}
                { "XYZ", "XYZ", "XYZ" }, // {1, 1}
                { "ZZZ", "YYY", "NNNN", "YYY", "BBB" }// {1, 5}
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 4; i++)
            System.out.println("Sol result: " + Arrays.toString(mSol.solution(gemArr[i])));
    }
}

class Solution {
    HashMap<String, ArrayList<Integer>> gemMap;
    String[] gems;

    public int[] solution(String[] gems) {
        gemMap = new HashMap<>();
        this.gems = gems;

        int index = 0;
        for (String gem : gems) {
            if (gemMap.containsKey(gem)) {
                gemMap.get(gem).add(index);
            } else {
                ArrayList<Integer> mList = new ArrayList<>();
                mList.add(index);
                gemMap.put(gem, mList);
            }
            index++;
        }

        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        Set<String> sequence = new HashSet<>();
        int sequenceLength = gemMap.keySet().size();
        int left = 0;
        for (int right = 0; right < gems.length; right++) {
            sequence.add(gems[right]);
            if (sequenceLength <= sequence.size()) {
                for (; left <= right; left++) {
                    if (!checkItemExist(left, right)) {
                        // System.out.println("cur sequence: " + left + "," + right);
                        if (right - left < minLength) {
                            answer[0] = left + 1;
                            answer[1] = right + 1;
                            minLength = right - left;
                        }
                        break;
                    } else {
                        // System.out.println("Item exist: " + left + "," + right);
                    }
                }
                right = left + 1;
                left = right;
                sequence.clear();
            }
        }

        return answer;
    }

    private boolean checkItemExist(int current, int right) {
        ArrayList<Integer> mList = gemMap.get(gems[current]);
        int nextIndex = mList.indexOf(current) + 1;
        if (nextIndex < mList.size()) {
            if (mList.get(nextIndex) <= right) {
                return true;
            }
        }
        return false;
    }
}