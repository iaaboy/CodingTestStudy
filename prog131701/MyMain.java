package prog131701;

import java.util.HashSet;

/* 연속 부분 수열 합의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */

public class MyMain {
    public static void main(String[] args) {
        int[] elements = { 7, 9, 1, 1, 4 };

        Solution mSol = new Solution();
        System.out.println(mSol.solution(elements));
    }
}

class Solution {

    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> numSet = new HashSet<>();

        for (int count = 1; count <= elements.length; count++) {

            int sum = 0;
            for (int cur = 0; cur < count; cur++) {
                sum += elements[cur];
            }

            // System.out.println("Sum:" + sum + " , cur:" + 0 + ", count:" + count);
            numSet.add(sum);

            for (int cur = count; cur < elements.length + count - 1; cur++) {
                sum -= elements[cur - count];
                sum += elements[cur % elements.length];
                // System.out.println("Sum:" + sum + " , cur:" + cur + ", count:" + count);
                numSet.add(sum);
            }

            System.out.println();
        }

        System.out.println(numSet);

        answer = numSet.size();

        return answer;
    }
}