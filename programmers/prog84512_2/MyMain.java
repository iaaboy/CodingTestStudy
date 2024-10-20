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
    ArrayList<String> dict = makeMine(new ArrayList<>());

    public int solution(String word) {
        return dict.indexOf(word) + 1;
    }

    ArrayList<String> makeMine (ArrayList<String> mDict) {
        String curWord = "";
        for(int i = 0; i< 10000 ; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < wordTable.length; i++) {
            curWord += wordTable[i];
            makeDict(mDict, curWord, 0);
            curWord = curWord.substring(0, curWord.length() - 1);
        }

        mDict.sort(null);
        return mDict;
    }

    // int count = 0;
    void makeDict(ArrayList<String> mDict, String curWd, int depth) {
        mDict.add(curWd);
        // if (count++ < 100)
        //     System.out.println(curWd);
        if (depth == 4) {
            return;
        }
        for (int i = 0; i < wordTable.length; i++) {
            curWd += wordTable[i];
            makeDict(mDict, curWd, depth + 1);
            curWd = curWd.substring(0, curWd.length() - 1);
        }
    }
}