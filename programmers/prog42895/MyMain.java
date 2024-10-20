package prog42895;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int N = 2;
        int number = 11;

        Solution mSol = new Solution();
        System.out.println(mSol.solution(N, number));
    }
}

class Solution {
    MySet[] mySet;
    int number;
    int N;

    public int solution(int N, int number) {
        int answer = -1;
        this.number = number;
        this.N = N;
        mySet = new MySet[10];
        for (int i = 0; i < 10; i++) {
            mySet[i] = new MySet();
        }

        // n = 0;
        if (N == number) {
            return 1;
        }

        // n = 1;
        mySet[1].r.add(N);
        mySet[1].r.add(-N);

        // n= 2 ~ 8

        for (int count = 2; count < 9; count++) {
            for (int m = 1; m <= count / 2; m++) {
                int leftV = count - m;
                int rightV = m;

                for (int l : mySet[leftV].r) {
                    for (int r : mySet[rightV].r) {
                        if (calcPlus(count, l, r)) {
                            return count;
                        }
                        if (calcMinus(count, l, r)) {
                            return count;
                        }
                        if (calcBy(count, l, r)) {
                            return count;
                        }
                        if (calcDevide(count, l, r)) {
                            return count;
                        }
                        if (l != r) {
                            if (calcPlus(count, r, l)) {
                                return count;
                            }
                            if (calcMinus(count, r, l)) {
                                return count;
                            }
                            if (calcBy(count, r, l)) {
                                return count;
                            }
                            if (calcDevide(count, r, l)) {
                                return count;
                            }
                        }
                    }
                }
            }
            int seq = calcSeq(count);
            if (seq == number) {
                return count;
            } else {
                mySet[count].r.add(seq);
            }
            System.out.println(count + " numbers :" + mySet[count].r);
        }

        return answer;
    }

    int calcSeq(int count) {
        if (count < 2) {
            return N;
        }
        return calcSeq(count - 1) * 10 + N;
    }

    boolean calcPlus(int count, int l, int r) {
        int result = l + r;
        if (result == number) {
            return true;
        }
        mySet[count].r.add(result);
        return false;
    }

    boolean calcMinus(int count, int l, int r) {
        int result = l - r;
        if (result == number) {
            return true;
        }
        mySet[count].r.add(result);
        return false;
    }

    boolean calcBy(int count, int l, int r) {
        int result = l * r;
        if (result == number) {
            return true;
        }
        mySet[count].r.add(result);
        return false;
    }

    boolean calcDevide(int count, int l, int r) {
        if (r == 0) {
            return false;
        }
        int result = l / r;
        if (result == number) {
            return true;
        }
        mySet[count].r.add(result);
        return false;
    }
}

class MySet {
    Set<Integer> r;

    public MySet() {
        this.r = new HashSet<>();
    }
}
