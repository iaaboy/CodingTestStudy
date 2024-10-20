package prog135807;

import java.util.*;

/*
숫자카드 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/135807
 */

public class MyMain {
    public static void main(String[] args) {
        int[] arrayA = { 100, 200 };
        int[] arrayB = { 5, 7 };

        Solution mSol = new Solution();
        System.out.println(mSol.solution(arrayA, arrayB));
    }
}

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        TreeSet<Integer> setA = new TreeSet<>();
        TreeSet<Integer> setB = new TreeSet<>();

        for (int a : arrayA)
            setA.add(a);
        for (int b : arrayB)
            setB.add(b);

        // debug
        System.out.println(setA);
        System.out.println(setB);

        int minA = setA.first();
        int passVal1 = getPassNum(setA, setB, minA);

        int minB = setB.first();
        int passVal2 = getPassNum(setB, setA, minB);

        if (Math.max(passVal1, passVal2) > 0) {
            return Math.max(passVal1, passVal2);
        }

        return 0;
    }

    int getPassNum(TreeSet<Integer> first, TreeSet<Integer> second, int minNum) {

        double sqrt = Math.sqrt(minNum);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println(minNum);
        // 제곱근 기준으로 for문을 돌린다.
        // 16이 기준수 라면, 한번에 두개를 list에 추가!!!
        // 1 x 16
        // 2 x 8
        // 4 x 4 : 16의 제곱근
        // 8 x 2
        // 16 x 1
        for (int i = 1; i <= sqrt; i++) {
            if (minNum % i == 0) {
                // System.out.println("added 1: " + i);
                if (Math.pow(i, 2) == minNum) {
                    list.add(i);
                } else {
                    list.add(i);
                    // System.out.println("added 2: " + minNum / i);
                    list.add(minNum / i);
                }
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        for (int num : list) {
            if (checkPass(first, second, num))
                return num;
        }
        return -1;
    }

    boolean checkPass(TreeSet<Integer> first, TreeSet<Integer> second, int minNum) {

        // a에 모두 나눠지는지
        for (int a : first) {
            if (a % minNum != 0) {
                return false;
            }
        }

        // b에 모두 안 나눠지는지
        for (int b : second) {
            if (b % minNum == 0) {
                return false;
            }
        }

        return true;
    }
}