package prog60057;

/* 문자열 압축
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */
public class MyMain {
    public static void main(String[] args) {
        String[] sentences = {
                "ababcdcdababcdcd", // 9
                "abcabcdede", // 8
                "abcabcabcabcdededededede", // 14
                "xababcdcdababcdcd",// 17
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++) {
            System.out.println("answer: " + mSol.solution(sentences[i]));
        }
    }
}

class Solution {
    public int solution(String s) {
        char[] sCh = s.toCharArray();
        int answer = 0;
        for (int wdCount = 1; wdCount <= sCh.length / 2; wdCount++) {
            int count = 0;
            int reduce = 0;
            for (int start = 0; start < sCh.length; start += wdCount) {
                if (compareWd(sCh, start, wdCount)) {
                    count++;
                } else {
                    if (count > 0) {
                        reduce += wdCount * (count);
                        if (count >= 99) {
                            reduce -= 3;
                        } else if (count >= 9) {
                            reduce -= 2;
                        } else {
                            reduce--;
                        }
                        count = 0;
                    }
                }
            }
            if (reduce > 0)
                System.out.println(wdCount + ":" + reduce);
            answer = Math.max(answer, reduce);
        }
        return s.length() - answer;
    }

    private boolean compareWd(char[] sCh, int start, int wdCount) {
        int matchCount = 0;
        for (int i = 0; i < wdCount; i++) {
            if (start + i + wdCount < sCh.length && sCh[start + i] == sCh[start + i + wdCount]) {
                matchCount++;
            } else {
                return false;
            }
        }
        return matchCount == wdCount;
    }
}