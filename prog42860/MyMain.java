package prog42860;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        String [] inStr = {"JEROEN","AABBABABBBCA"};
        Solution mSol = new Solution();

        for(String s : inStr) {
            mSol.solution(s);
        }
    }
}

class Solution {

    int [] transTable = new int['Z' - 'A' + 1];

    public int solution(String name) {
        int answer = 0;
        int reversNum = 26;//alphabet숫자
        for(int i = 0; i < transTable.length ; i++) {
            transTable[i] = i < reversNum ? i:reversNum ;
            reversNum--;
        }

        int [] inTable = new int [name.length()];

        int index = 0;
        for(char c : name.toCharArray()) {
            inTable[index++] = transTable[c - 'A'];
        }

        System.out.println(Arrays.toString(transTable));
        System.out.println(Arrays.toString(inTable));
        return answer;
    }
}
