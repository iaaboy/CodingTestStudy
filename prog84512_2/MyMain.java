package prog84512_2;

import java.util.ArrayList;

/* 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */

public class MyMain {
    public static void main(String[] args) {
        // String word = "AAAE";
        String word = "EIO";

        Solution mSol = new Solution();
        System.out.println(mSol.solution(word));
    }
}

class Solution {
    String[] wordTable = { "A", "E", "I", "O", "U" };
    ArrayList<String> dict = new ArrayList<>();

    public int solution(String word) {
        String curWord = "";

        for (int i = 0; i < wordTable.length; i++) {
            curWord += wordTable[i];
            makeDict(curWord, 0);
            curWord = curWord.substring(0, curWord.length() - 1);
        }

        dict.sort(null);

        return dict.indexOf(word) + 1;
    }

    // int count = 0;
    void makeDict(String curWd, int depth) {
        dict.add(curWd);
        // if (count++ < 100)
        //     System.out.println(curWd);
        if (depth == 4) {
            return;
        }
        for (int i = 0; i < wordTable.length; i++) {
            curWd += wordTable[i];
            makeDict(curWd, depth + 1);
            curWd = curWd.substring(0, curWd.length() - 1);
        }
    }
}