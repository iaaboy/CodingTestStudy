package prog154538;

public class MyMain {
    public static void main(String[] args) {
        int[][] numbers = { { 3,3, 1} };

        Solution mSol = new Solution();

        for (int[] num : numbers) {
            System.out.println(mSol.solution(num[0], num[1], num[2]));
            System.out.println();
        }
    }
}

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }
        int rN = checkAdd(x, y, n);
        int r2 = (int) log2(y, x);
        int r3 = (int) log3(y, x);

         System.out.println("addN:" + rN);
         System.out.println("log2: " + r2);
         System.out.println("log3:" + r3);

        return getMin(rN, r2, r3);
    }

    private int getMin(int n1, int n2, int n3) {
        int result = Math.min(Math.min(n1, n2), n3);
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else
            return result;
    }

    private int checkAdd(int x, int y, int n) {
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
