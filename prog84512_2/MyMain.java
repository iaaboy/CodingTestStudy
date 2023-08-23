package prog84512_2;

/* 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */

public class MyMain {
    public static void main(String[] args) {
        String word = "AAAAE";
        // String word = "EIO";

        Solution mSol = new Solution();
        System.out.println(mSol.solution(word));
    }
}

class Solution {
    String[] wordTable = { "A", "E", "I", "O", "U" };
    String word;

    public int solution(String word) {
        String curWord = "";
        this.word = word;
        int result = 0;

        for (int i = 0; i < wordTable.length; i++) {
            curWord += wordTable[i];
            result = searchDict(curWord, 0);
            if (result > 0)
                return result;
            curWord = curWord.substring(0, curWord.length() - 1);
        }

        return result;
    }

    int count = 0;

    int searchDict(String curWd, int depth) {
        int result = -1;
        if (word.equals(curWd)) {
            return count + 1;
        }
        count++;
        if (depth >= 4) {
            return result;
        }
        for (int i = 0; i < wordTable.length; i++) {
            curWd += wordTable[i];
            result = searchDict(curWd, depth + 1);
            curWd = curWd.substring(0, curWd.length() - 1);

            if (result > 0)
                break;
        }
        return result;
    }
}