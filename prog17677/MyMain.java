package prog17677;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        // str1 str2 answer
        // FRANCE french 16384
        // handshake shake hands 65536
        // aa1+aa2 AAAA12 43690
        // E=M*C^2 e=m*c^2 65536

        String[] str1 = { "FRANCE", "handshake", "aa1+aa2", "E=M*C^2" };
        String[] str2 = { "french", "shake hands", "AAAA12", "e=m*c^2" };
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

        System.out.println(str1List);
        System.out.println(str2List);
        str1List.retainAll(str2List);
        System.out.println(str1List);

        return 65536 * str1List.size() / strUnion.size();
    }

    private boolean isLetter(char c) {
        return (c <= 'z' && c >= 'a');
    }
}