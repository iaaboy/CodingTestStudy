package prog154538;

public class MyMain {
    public static void main(String[] args) {
        int[][] numbers = { { 30, 30*8*9, 11 }, { 2, 64*2, 20 }, { 2, 5, 4 } };

        Solution mSol = new Solution();

        for (int[] num : numbers) {
            System.out.println(mSol.solution(num[0], num[1], num[2]));
        }
    }
}

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) {
            return -1;
        }
        int rN = checkN(x, y, n);
        int r2 = (int) log2(y, x);
        int r3 = (int) log3(y, x);

        // System.out.println(rN);
        // System.out.println(r2);
        // System.out.println(r3);

        return getMin(rN, r2, r3);
    }

    private int getMin(int n1, int n2, int n3) {
        int result = Math.min(Math.min(n1, n2), n3);
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else
            return result;
    }

    private int checkN(int x, int y, int n) {
        if (((y - x) % n != 0)) {
            return Integer.MAX_VALUE;
        } else {
            return (y - x) / n;
        }
    }

    private double log2(int y, int x) {
        if (y % x != 0) {
            return Integer.MAX_VALUE;
        } else {
            double res = Math.log(y / x) / Math.log(2);
            if (res % 1 == 0) {
                return res;
            } else
                return Integer.MAX_VALUE;
        }
    }

    private double log3(int y, int x) {
        if (y % x != 0) {
            return Integer.MAX_VALUE;
        } else {
            double res = Math.log(y / x) / Math.log(3);
            if (res % 1 == 0) {
                return res;
            } else
                return Integer.MAX_VALUE;
        }
    }
}
