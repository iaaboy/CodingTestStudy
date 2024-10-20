package prog138476;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[] tangerine = { 1, 1, 1, 1, 2, 2, 2, 3 };
        int k = 2;

        Solution mSol = new Solution();

        System.out.println(mSol.solution(k, tangerine));
    }
}

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i : tangerine) {
            if (myMap.containsKey(i)) {
                myMap.put(i, myMap.get(i) + 1);
            } else {
                myMap.put(i, 1);
            }
        }

        System.out.println(myMap);

        PriorityQueue<Integer> mykeyQ = new PriorityQueue<>((a, b) -> {
            return myMap.get(b) - myMap.get(a);
        });

        for (int key : myMap.keySet()) {
            mykeyQ.add(key);
        }

        while (!mykeyQ.isEmpty()) {
            answer++;
            k -= myMap.get(mykeyQ.poll());
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}