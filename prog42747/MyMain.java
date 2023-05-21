package prog42747;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[] citations = { 2 };

        Solution mSol = new Solution();

        System.out.println(mSol.solution(citations));
    }
}

class Solution {
    public int solution(int[] citations) {
        Integer[] cRev = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            cRev[i] = citations[i];
        }
        Arrays.sort(cRev, (a, b) -> {
            return a < b ? 1 : -1;
        });

        System.out.println(Arrays.toString(cRev));

        for (int i = 0; i < cRev.length; i++) {
            if (cRev[i] < i + 1) {
                return i;
            }
        }

        return cRev.length;
    }
}