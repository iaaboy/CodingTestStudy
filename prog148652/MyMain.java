package prog148652;

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        int n = 2;
        int l = 4;
        int r = 26;
        System.out.println(mSol.solution(n, l, r));
    }
}

class Solution {
    long sum;

    public int solution(int n, long l, long r) {
        int answer = 0;
        answer = calc(r, n) - calc(l - 1, n);
        return answer;
    }

    int[] rstTable = { 0, 1, 2, 2, 3, 4 };

    int calc(long num, long n) {
        long result = 0;
        long base = (long) Math.pow(5, n);
        long index = (long) Math.pow(4, n);
        // System.out.println("base : " + base + ", num: " + num);
        for (int i = 0; i <= n; i++) {
            long count = (long) Math.floor(num / base);
            // System.out.println("num : " + num + ", count: " + count + ", rest: " + num %
            // base + ", base: " + base);
            num = num % base;
            if (count > 0) {
                int idx = (int) count;
                if (idx < 6)
                    result += index * rstTable[idx];
            }
            if (count == 2)
                break;
            base = base / 5;
            index = index / 4;
        }
        System.out.println("num : " + result);
        return (int) result;
    }
}