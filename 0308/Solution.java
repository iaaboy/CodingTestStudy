//문제  https://school.programmers.co.kr/learn/courses/30/lessons/43105
class Solution {
    int[] curMax = {};

    public int solution(int[][] triangle) {
        int answer = 0;

        // sample
        // [[7],
        // [3, 8],
        // [8, 1, 0],
        // [2, 7, 4, 4],
        // [4, 5, 2, 6, 5]]

        for (int[] is2 : triangle) { // triangle[]

            calcMax(is2);

        }

        for (int val : curMax) {
            if (answer <= val) {
                answer = val;
            }
        }

        return answer;
    }

    public void calcMax(int[] curArray) {
        int[] nextMax = new int[curMax.length + 1];
        if (curMax.length == 0) {
            nextMax[0] = curArray[0];
        } else {
            int index = 0;
            for (int currValue : curArray) {
                if (index == 0) {
                    nextMax[index] = currValue + curMax[index];
                } else if (index == curArray.length - 1) {
                    nextMax[index] = currValue + curMax[index - 1];
                } else {
                    if (curMax[index - 1] > curMax[index]) {
                        nextMax[index] = currValue + curMax[index - 1];
                    } else {
                        nextMax[index] = currValue + curMax[index];
                    }
                }
                index++;
            }
        }

        // max값 업데이트
        curMax = nextMax;
    }
}