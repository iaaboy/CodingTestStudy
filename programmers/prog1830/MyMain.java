package prog1830;

import java.util.*;

/* 브라이언의 고민
 * https://school.programmers.co.kr/learn/courses/30/lessons/1830
 */

public class MyMain {
    public static void main(String[] args) {
        String[] sentences = {
                "SpIpGpOpNpGJJqOqA", // "SIGONG JJ O A");
                "SpIpGpOpNpGJqOqA", // "SIGONG JOA");
                "aGbWbFbDakGnWnLk", // "GWFD GWL");  aGbWbFbDa   kGnWnLk
                "AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR", // "AAA B A BBBB C BBBB CBB GG G G G RRRRRR");
                "AaBaA", // ABA
                "AbAaAbAaCa", // INVALID
                "AaAaAbBbBbB", // A A ABBB
                // "XcXbXcX", //"X XX X"
                // "AababB", // " AB " ???,
                // "", // "");
                // "A", // "A");
                // "a", // INVALID);
                // "AA", // "AA");
                // "Aa", // INVALID);
                // "aA", // INVALID);
                // "aa", // INVALID);
                // "aAa", // "A");
                // "AaA", // "AA");
                // "aaA", // INVALID);
                // "Aaa", // INVALID);
                // "AAa", // INVALID);
                // "aaA", // INVALID);
                // "Aaa", // INVALID);
                // "AAaA", // "A AA");
                // "AbAaAbAaC", // INVALID);
                // "AbAaAbAaCa", // INVALID);
                // "abAba", // INVALID);
                // "aCaCa", // INVALID);
                // "aHbEbLbLbacWdOdRdLdDc", // INVALID);
                // "aHbEbLbLbOacWdOdRdLdDc", // "HELLO WORLD");
                // "aHELLOWORLDa", // "HELLOWORLD");
                // "aIaAM", // "I AM");
                // "AsAzAsA", // "A AA A");
                // "AxAxAxAoBoBoB", // INVALID);
                // "bAaOb", // "AO");
                // "baHELLOabWORLD", // INVALID);
                // "bTxTxTaTxTbkABaCDk", // INVALID);
                // "GgGGjGjGRvRvRvRvRvR", // "GG G G G RRRRRR");
                // "GjGjGRvRvRvRvRvR", // "G G G RRRRRR");
                // "HaEaLaLaObWORLDb", // "HELLO WORLD");
                // "HaEaLaLaOWaOaRaLaD", // INVALID);
                // "HaEaLaLObWORLDb", // "HELL O WORLD");
                // "HELLO WORLD", // INVALID);
                // "HELLOWbObRbLb", // INVALID);
                // "SpIpGpOpNpGJJqOqA", // "SIGONG JJ O A");
                // "TxTxTxbAb", // INVALID);
                // "xAaAbAaAx", // INVALID);
                // "XcXbXcX", // "X XX X");
        };

        Solution mSol = new Solution();

        for (String sentence : sentences)
            System.out.println("answer->" + mSol.solution(sentence));
    }
}

class Solution {
    static int SMALL_CH = 9;

    public String solution(String sentence) {
        HashMap<Character, Signature> sigMap = new HashMap<>();
        int[] occupy = new int[sentence.length()];
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ') { // 공백조사
                return "invalid";
            }
            if (ch >= 'a' && ch <= 'z') { // 소문자이면,
                occupy[i] = SMALL_CH;
                if (!sigMap.containsKey(ch)) {
                    sigMap.put(ch, new Signature(ch, i, i, 1));
                } else {
                    Signature sCh = sigMap.get(ch);
                    if ((sCh.count > 1 && (sCh.end != i - 2) || sCh.end == i - 1)) {
                        return "invalid"; // 중복키 조사
                    }
                    if (sCh.count == 2 && sentence.charAt(i - 4) != ch) {
                        return "invalid"; // 2개 전 key 조사
                    }
                    sCh.end = i;
                    sCh.count++;
                    sigMap.put(ch, sCh);
                }
            }
        }

        ArrayList<Signature> sigList = new ArrayList<>(sigMap.values());
        sigList.sort((a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            } else {
                return a.start - b.start;
            }
        });

        for (Signature sP : sigList) {
            if (sP.isInner)
                continue;
            // System.out.println(sP);
            if (sP.count == 2) {
                int subWordCount = 0;
                for (Signature spam : sigMap.values()) {
                    if (spam.start > sP.start && spam.end < sP.end) {
                        // System.out.println("subSet exist: " + spam);
                        spam.isInner = true;
                        sP.isOuter = true;
                        subWordCount++;
                    }
                    if (subWordCount >= 2) {
                        // System.out.print("Invalid by word count : ");
                        // System.out.println(sentence);
                        // System.out.println(sigMap);
                        return "invalid";// word사이 2개 들어있는지
                    }
                }
            }
        }

        int wordIdx = 1;
        boolean isRule2 = false;
        for (Signature sP : sigList) {
            // System.out.println(sP);
            if (sP.isOuter) {
                // todo 처리 필요.
                continue;
            }
            isRule2 = false;
            if (sP.count == 2) {
                if (sP.end - sP.start == 2) { // "SpIpGpOpNpG JJqOqA", // "SIGONG JJ O A");
                    int start = Math.max(sP.start - 1, 0);
                    int end = Math.min(sP.end + 1, sentence.length());
                    start = Math.max(sP.start + 1, 0);
                    end = Math.min(sP.end - 1, sentence.length());
                    // rule 2 외곽
                    for (int i = start; i <= end; i++) {
                        if (occupy[i] != 0) {
                            // System.out.println("occupied 2, 12");
                            return "invalid";
                        } else {
                            occupy[i] = wordIdx;
                        }
                    }
                    wordIdx++;
                    isRule2 = true;
                } else {
                    // rule 2 외곽
                    sP.start++;
                    sP.end--;
                    for (int i = sP.start; i <= Math.min(sP.end, sentence.length() - 1); i++) {
                        if (occupy[i] != 0) {
                            // System.out.println("occupied 2, 2");
                            return "invalid";
                        } else {
                            occupy[i] = wordIdx;
                        }
                    }
                    wordIdx++;
                    isRule2 = true;
                }
            } else { // rule 1 사이
                sP.start--;
                sP.end++;
                if (sP.start < 0 || sP.end >= sentence.length()) {
                    return "invalid";
                }
                for (int i = sP.start; i <= Math.min(sP.end, sentence.length() - 1); i += 2) {
                    if (occupy[i] != 0) {
                        // System.out.println("occupied 1: " + i);
                        return "invalid";
                    } else {
                        occupy[i] = wordIdx;
                    }
                }
                wordIdx++;
            }
            if (sP.isInner && isRule2) {
                // System.out.println("broken rule");
                // return "invalid";
            }
        }

        int prevId = 0;
        StringBuilder answerCandi = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            if (occupy[i] == SMALL_CH) {
                continue;
            }
            if (prevId != occupy[i] && answerCandi.length() != 0) {
                answerCandi.append(" ");
            }
            answerCandi.append(sentence.charAt(i));
            prevId = occupy[i];
        }

        // DEBUG field
        // StringBuilder number = new StringBuilder();
        // StringBuilder occ = new StringBuilder();
        // for (int i = 0; i < sentence.length(); i++) {
        // number.append(i % 10);
        // occ.append(occupy[i]);
        // }
        // System.out.println(sentence);
        // System.out.println(number);
        // System.out.println(occ);
        // System.out.println(sigMap);

        return answerCandi.toString();
    }

    class Signature {
        char ch;
        int start;
        int end;
        int count;
        boolean isInner = false;
        boolean isOuter = false;

        public Signature(char ch, int start, int end, int count) {
            this.ch = ch;
            this.start = start;
            this.end = end;
            this.count = count;
        }

        @Override
        public String toString() {
            return "<" + ch + ":" + start + "-" + end + "|" + count + (isOuter ? ",outer" : "")
                    + (isInner ? ",inner" : "") + ">";
        }
    }
}