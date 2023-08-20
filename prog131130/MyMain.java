package prog131130;

import java.util.*;

/* 혼자 놀기의 달인
 * https://school.programmers.co.kr/learn/courses/30/lessons/131130
 */

public class MyMain {
    public static void main(String[] args) {
        int[] cards = { 8, 6, 3, 7, 2, 5, 1, 4 };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(cards));
    }
}

class Solution {
    public int solution(int[] cards) {
        int gNumber = 1;
        int[] group = new int[cards.length];
        ArrayList<Integer> countGSet = new ArrayList<>();

        int index;
        for (int i = 0; i < cards.length; i++) {
            index = i;
            boolean isHandled = false;
            int countOfG = 0;
            while (group[index] == 0) {
                group[index] = gNumber;
                index = cards[index] - 1;
                isHandled = true;
                countOfG++;
            }
            if (isHandled) {
                countGSet.add(countOfG);
                gNumber++;
            }
        }

        countGSet.sort(Comparator.reverseOrder());

        System.out.println(countGSet);

        if (countGSet.size() > 1) {
            return countGSet.get(0) * countGSet.get(1);
        } else {
            return 0;
        }
    }
}