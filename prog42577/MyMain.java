package prog42577;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[] inStr = {"12","123","1235","567","88"};
        Solution mSol = new Solution();
        System.out.println("result:" + mSol.solution(inStr));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<Integer> sizeSet = new HashSet<>();

        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));

        System.out.println(sizeSet);

        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        return answer;
    }
}