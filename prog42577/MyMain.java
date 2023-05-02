package prog42577;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[] inStr = {"119", "97674223", "1195524421"};
        Solution mSol = new Solution();
        System.out.println("result:" + mSol.solution(inStr));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, (str1, str2) -> {
            if (str1.length() > str2.length()) {
                return 1;
            } else 
            return -1;
        });

        System.out.println(Arrays.toString(phone_book));

        for(int i = 0; i< phone_book.length; i++) {
            for(int j = i+1; j< phone_book.length; j++) {
                if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}