package prog17677;

import java.util.*;

/* [1차] 뉴스 클러스터링
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */

public class MyMain {
    public static void main(String[] args) {
        String[] str1 = { "aaabbcc", "FRANCE", "handshake", "aa1+aa2", "E=M*C^2" };
        String[] str2 = { "aabbcc", "french", "shake hands", "AAAA12", "e=m*c^2" };
        Solution mSol = new Solution();
        for (int i = 0; i < 4; i++) {
            System.out.println(mSol.solution(str1[i], str2[i]));
        }
    }
}

class Solution {
    public int solution(String str1, String str2) {
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        str1 = str1.toLowerCase();
        char[] st1Arr = str1.toCharArray();
        str2 = str2.toLowerCase();
        char[] st2Arr = str2.toCharArray();
        List<String> strUnion = new ArrayList<>();
        List<String> strRetain = new ArrayList<>();

        for (int i = 0; i < st1Arr.length - 1; i++) {
            if (isLetter(st1Arr[i]) && isLetter(st1Arr[i + 1])) {
                str1List.add(str1.substring(i, i + 2));
            }
        }
        for (int i = 0; i < st2Arr.length - 1; i++) {
            if (isLetter(st2Arr[i]) && isLetter(st2Arr[i + 1])) {
                str2List.add(str2.substring(i, i + 2));
            }
        }
        for (String st : str1List) {
            strUnion.add(st);
        }
        strUnion.addAll(str2List);

        for (String st : str1List) {
            if (str2List.contains(st)) {
                strRetain.add(st);
                str2List.remove(st);
            }
        }

        // System.out.println(strUnion);
        // System.out.println(strRetain);

        if (strUnion.size() - strRetain.size() == 0) {
            return 65536;
        }

        return 65536 * strRetain.size() / (strUnion.size() - strRetain.size());
    }

    private boolean isLetter(char c) {
        return (c <= 'z' && c >= 'a');
    }
}