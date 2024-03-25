package prog77886;

import java.util.Arrays;

/* 110 옮기기
 * https://school.programmers.co.kr/learn/courses/30/lessons/77886
 */

public class MyMain {
    public static void main(String[] args) {
        String[] s = { "1110", "100111100", "0111111010" };
        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(s)));
    }
}

class Solution {
    public String[] solution(String[] s) {

        char[] comparer = { '1', '1', '0' };

        int matchCount = 0;
        for (int i = 0; i < s.length; i++) {
            char[] chArr = s[i].toCharArray();
            for (int j = 0; j < chArr.length - 2; j++) {

                int cmp = 0;
                int index = j;
                while (cmp < 3 && index < chArr.length) {
                    if (chArr[index] == comparer[cmp]) {
                        cmp++;
                        index++;
                    } else {
                        if(chArr[index] == '2') {
                            index ++;
                        } else {
                            break;
                        }
                    }
                }

                if (cmp == 3) {
                    matchCount++;
                    cmp = 3;
                    for (int k = j; k < chArr.length; k++) {
                        if (chArr[k] != '2') {
                            cmp--;
                            chArr[k] = '2';
                            if (cmp == 0)
                                break;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(chArr));
        }

        String[] answer = {};
        return answer;
    }
}