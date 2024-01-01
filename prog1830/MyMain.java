package prog1830;

import java.util.HashMap;

public class MyMain {
    public static void main(String[] args) {
        String[] sentences = {
                "HELLOAaWORLD",
                "HaEaLaLaObWORLDb",
                "SpIpGpOpNpGJqOqA",
                "AxAxAxAoBoBoB",
                "cHaEaLaLaObWORLDbc",
        };

        Solution mSol = new Solution();

        for (String sentence : sentences)
            System.out.println(mSol.solution(sentence));
    }
}

class Solution {
    public String solution(String sentence) {

        HashMap <Character, SpamCh> chMap = new HashMap<>();
        for(int i = 0; i < sentence.length() ; i++) {
            char ch = sentence.charAt(i);
            if(ch == ' ') {
                return "invalid";
            }
            if( ch >= 'a' && ch <= 'z') {
                if(!chMap.containsKey(ch)) {
                    chMap.put(ch, new SpamCh(i, i, 1));
                } else {
                    SpamCh sCh = chMap.get(ch);
                    if(sCh.count > 1 && sCh.end != i - 2) {
                        return "invalid";
                    }
                    sCh.end = i;
                    sCh.count++;
                    chMap.put(ch, sCh);
                }
            }
        }

        for(Character spKey : chMap.keySet()) {
            SpamCh sP = chMap.get(spKey);
            if(sP.count == 2) {
                int subWordCount = 0;
                for(SpamCh spam : chMap.values()) {
                    if(spam.start < sP.start && spam.end < sP.end) {
                        subWordCount ++;
                    }
                    if(subWordCount >=2) {
                        return "invalid";
                    }
                }
            }
        }

        System.out.println(sentence);
        System.out.println(chMap);

        String answer = "";
        return answer;
    }

    class SpamCh {
        int start;
        int end;
        int count;
        boolean isMainWord = true;
        public SpamCh(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }

        @Override
        public String toString() {
            return "<" + start + "-" + end + "|" + count + ">";
        }
    }
}