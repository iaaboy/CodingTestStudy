package prog136797;

public class MyMain {
    public static void main(String[] args) {
        // String myStr = "1756";
        String myStr = "10262626262626";
        Solution mSol = new Solution();
        System.out.println(mSol.solution(myStr));
    }
}

class Solution {
    int[][] preset = { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 }, { 2, 2 },
            };
    int map[][] = new int[10][10];

    public int solution(String numbers) {
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                int dist = calcDistance(i, j);
                map[j][i] = map[i][j] = dist;
            }
        }
        // for (int i = 0; i < 10; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }

        answer = caltDist(numbers, 0, 0, 4, 6);

        return answer;
    }

    int caltDist(String num, int curIdx, int curVal, int left, int right) {
        System.out.println("curIdx:" + curIdx + ",curVal:" + curVal + " ,l:" + left + " ,r:" + right);
        if (curIdx == num.length()) {
            return curVal;
        }

        int nextVal = num.charAt(curIdx) - '0';
        int lResult = caltDist(num, curIdx + 1, curVal + map[right][nextVal], left, nextVal);
        int rResult = caltDist(num, curIdx + 1, curVal + map[left][nextVal], nextVal, right);
        return Math.min(lResult, rResult);
    }

    int calcDistance(int from, int to) {

        int y = Math.abs(preset[from][0] - preset[to][0]);
        int x = Math.abs(preset[from][1] - preset[to][1]);

        int result = Math.min(y, x) * 3 + 2 * (Math.abs(y - x));
        if (from == to)
            result = 1;
        // System.out.println(from + "-> " + to + ": " + result);
        return result;
    }
}