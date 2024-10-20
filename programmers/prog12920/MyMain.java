package prog12920;

/* 선입 선출 스케줄링
 * https://school.programmers.co.kr/learn/courses/30/lessons/12920
 */

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        for (int i = 1; i < 16; i++)
            System.out.println("answer: " + mSol.solution(i, new int[] { 1, 2, 3 }));
    }
}

class Solution {
    public int solution(int n, int[] cores) {
        int left = 0;
        int right = 100000000;
        int center;
        if (n < cores.length) {
            return n;
        }

        while (true) {
            center = (left + right) / 2;
            int count = getCount(center, cores);
            // System.out.println("<" + left + "," + right + ">: " + center + "->" + count);
            if (count == n) {
                for (int i = cores.length - 1; i >= 0; i--) {
                    if (center % cores[i] == 0) {
                        return i + 1;
                    }
                }
                break;
            }
            if (right - left == 1) {
                int countLeft = n - getCount(left, cores);
                for (int i = 0; i < cores.length; i++) {
                    if (right % cores[i] == 0) {
                        countLeft--;
                    }
                    if (countLeft == 0) {
                        return i + 1;
                    }
                }
                break;
            }
            if (count > n) {
                right = center;
            } else { // count < n
                left = center;
            }
        }

        return -1;
    }

    private int getCount(int number, int[] cores) {
        int count = 0;
        for (int i : cores) {
            count += (number / i) + 1;
        }
        return count;
    }
}