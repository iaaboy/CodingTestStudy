package prog68646_2;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        int[][] as = {
                { 9, -1, -5 },
                { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 }
        };
        Solution mSol = new Solution();
        for (int i = 0; i < as.length; i++) {
            System.out.println(mSol.solution(as[i]));
        }
    }
}

class Solution {
    public int solution(int[] a) {

        // 1, 2, 3
        // (1,2) (3) / (1) (2,3)
        // 1, 3 / 1, 2

        // 1, 3, 2 ==> 큰 수가 가운데 있으면 남길 수가 없음.
        // (1,3) (2) / (1) (3,2)
        // 1, 2 / 1, 2

        // 2, 1, 3
        // (2,1) (3) / (2) (1,3)
        // 1, 3 / 2, 1

        // 나 기준으로 양쪽에 나보다 작은게 있으면 불가능.
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        if (a.length < 3) {
            return a.length;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            leftMin[i] = Math.min(min, a[i]);
            min = leftMin[i];
        }
        min = Integer.MAX_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            rightMin[i] = Math.min(min, a[i]);
            min = rightMin[i];
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(leftMin));
        System.out.println(Arrays.toString(rightMin));

        int answer = 0;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < leftMin[i - 1] || a[i] < rightMin[i + 1]) {
                answer++;
            }
        }

        return answer + 2;
    }
}