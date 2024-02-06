package prog12980;

/* 점프와 순간 이동
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */

public class MyMain {
    public static void main(String[] args) {
        int[] N = { 6, 5, 5000 };
        Solution mSol = new Solution();
        for (int n : N) {
            System.out.println(mSol.solution(n));
        }
    }
}

class Solution {
    public int solution(int n) {
        minEnergy = Integer.MAX_VALUE;
        move(1, 1, n);
        // System.out.println("minEnergy:" + minEnergy);

        return minEnergy;
    }

    int minEnergy = Integer.MAX_VALUE;

    public void move(int curDist, int curEnergy, int n) {
        if (n < curDist) {
            // System.out.println("false out: " + curDist);
            return;
        } else if (n == curDist) {
            // System.out.print/zln("good out: " + curEnergy);
            if (minEnergy > curEnergy) {
                minEnergy = curEnergy;
            }
        }

        if (curEnergy < minEnergy) {
            move(curDist + curDist, curEnergy, n);
        }
        if (curEnergy < minEnergy) {
            move(curDist + 1, curEnergy + 1, n);
        }
    }

    public int warf(int curDist) {
        return curDist * 2;
    }
}
