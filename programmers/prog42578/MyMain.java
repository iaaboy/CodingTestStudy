package prog42578;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[][] inStr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution mSol = new Solution();
        System.out.println("result:" + mSol.solution(inStr));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap <String, HashSet <String> > clothSet = new HashMap<>();

        for(String[] cl : clothes) {
            if(clothSet.containsKey(cl[1])) {
                if(clothSet.get(cl[1]).contains(cl[0])) {
                    System.out.println("do nothing");
                } else {
                }
            } else {
                clothSet.put(cl[1], new HashSet<String>());
            }
            clothSet.get(cl[1]).add(cl[0]);
        }

        return answer;
    }
}