package prog42746;

import java.util.Arrays;


public class MyMain {
    public static void main(String[] args) {
        int [][] inArr = {
        {104, 1}
        };

        Solution mSol = new Solution();
        for(int [] inA : inArr) {
            System.out.println("answer : " + mSol.solution(inA));
        }
    } 
}

class Solution {
    public String solution(int[] num) {
        String answer = "";
        char[][] nString = new char[num.length][];
        int idx = 0;
        int count = 0;
        for(int n : num) {
            nString[idx++] = Integer.toString(n).toCharArray();
            if(n == 0) {
                count ++;
            }
        }
        if(count == num.length) {
            return "0";
        }

        Arrays.sort(nString, (a,b) -> {
            int len = a.length >= b.length ? a.length:b.length;

            //첫자리가 제일 큰  순서
            for(int i = 0; i< len ; i++) {
                if(a[i % a.length] < b[i % b.length]) {
                    return 1;
                } else if (a[i % a.length] > b[i % b.length]) {
                    return -1;
                }
            }
            return 1;
            //첫자리가 같다면 둘째자리...            
        });

        for(char[] aa : nString) {
            System.out.println(Arrays.toString(aa));
            for (char a : aa) {
                answer +=a;
            }
        }

        return answer;
    }
}