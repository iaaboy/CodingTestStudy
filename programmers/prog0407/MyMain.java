package prog0407;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        int[][] inputArr = {
            { 1, 2, 3, 4, 5 },
            { 1, 1, 1, 2, 3, 4, 5 },

                { 2, 2, 2, 2, 2 }
        };
        int[] k = { 7, 5, 6 };

        Solution sol = new Solution();
        int[] result = {};

        for (int i = 0; i < inputArr.length; i++) {
            result = sol.solution(inputArr[i], k[i]);
            System.out.println("result : " + Arrays.toString(result));
        }

    }
}

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] prefix = new int[sequence.length + 1];// sequence의 합을 나타낸 배열

        for (int i = 1; i <= sequence.length; i++) {
            prefix[i] = prefix[i - 1] + sequence[i - 1];
        }

        //{ 1, 1, 1, 2, 3, 4, 5 },

        int ln = 999999999;
        int sdx = 1;
        int edx = 1;
        int asdx = 1;
        int aedx = -1;
        int check = 0;
        while (sdx <= edx && edx <= sequence.length) {
            check = prefix[edx] - prefix[sdx - 1];
            if (check < k) {
                edx += 1;
            } else if (check == k) {
                if (ln > edx - sdx) {
                    ln = edx - sdx;
                    asdx = sdx;
                    aedx = edx;
                    answer[0] = asdx-1;
                    answer[1] = aedx-1;
                    //System.out.println((asdx - 1) + "," +  (aedx - 1));
                }
                edx += 1;
            } else {
                sdx += 1;
            }
        }

        return answer;
    }
}