package prog12981;

import java.util.*;

/* 영어 끝말 잇기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */

public class MyMain {
    public static void main(String[] args) {
        // int n = 3;
        // String[] words = { "tank", "kick", "know", "wheel", "land", "dream",
        // "mother", "robot", "tank" };
        int n = 2;
        String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(n, words)));
    }
}

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = { 0, 0 };
        Set<String> wordMap = new HashSet<>();

        // 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
        // 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
        // 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
        // 이전에 등장했던 단어는 사용할 수 없습니다.
        // 한 글자인 단어는 인정되지 않습니다.

        int count = 0;
        String prevWord = "";
        boolean isbroken = false;
        for (String word : words) {
            if (count > 0) {
                // 첫말 끝말 비교
                if (word.charAt(0) != prevWord.charAt(prevWord.length() - 1)) {
                    isbroken = true;
                    break;
                }
                if (wordMap.contains(word)) {
                    isbroken = true;
                    break;
                } else {
                    wordMap.add(word);
                }
            } else {
                wordMap.add(word);
            }
            prevWord = word;
            count++;
        }

        // System.out.println("Count: " + count + ", broken: " + isbroken);

        if (isbroken) {
            // System.out.println("num: " + ((count % n) + 1));
            // System.out.println("count: " + (count / n + 1));

            answer[0] = ((count % n) + 1);
            answer[1] = (count / n + 1);
        }

        return answer;
    }
}