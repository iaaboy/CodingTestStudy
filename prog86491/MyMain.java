package prog86491;

public class MyMain {
    public static void main(String[] args) {
        int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };

        Solution mSol = new Solution();

        System.out.println(mSol.solution(sizes));
    }
}

class Solution {
    public int solution(int[][] sizes) {

        // 가장 큰 index 및 값을 구한다.

        int maxIdx = 0;
        int maxVal = -1;
        int mm = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > maxVal) {
                maxIdx = i;
                maxVal = sizes[i][0];
                mm = sizes[i][1];

            }
            if (sizes[i][1] > maxVal) {
                maxIdx = i;
                maxVal = sizes[i][1];
                mm = sizes[i][0];
            }
        }

        System.out.println(maxIdx);
        System.out.println(maxVal);

        // 남은 값으로 둘중 작은 값의 max를 구한다.
        int minMax = -1;
        for (int i = 0; i < sizes.length; i++) {
            if (i == maxIdx) {
                continue;
            }
            int curCmp = Math.min(sizes[i][0], sizes[i][1]);
            if (curCmp > minMax)
                minMax = curCmp;
        }
        minMax = Math.max(minMax, mm);
        System.out.println(minMax);
        return minMax * maxVal;
    }
}