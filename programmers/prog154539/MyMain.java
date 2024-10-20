package prog154539;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {

        int[] inNum = { 7,4,6,8,1};
        // int [] inNum = {9, 1, 5, 3, 6, 2} ;

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(inNum)));
    }
}

class Solution {
    public int[] solution(int[] numbers) {

        PriorityQueue<Saved> savedQueue = new PriorityQueue<>();

        for (int index = 0; index < numbers.length; index++) {
            int value = numbers[index];

            while (!savedQueue.isEmpty() && savedQueue.peek().value < value) {
                numbers[savedQueue.poll().index] = value;
                System.out.println("update numbers:" + Arrays.toString(numbers));
                System.out.println("current q:" + savedQueue);
            }

            System.out.println("add to Q");
            savedQueue.add(new Saved(index, value));
            System.out.println("current q:" + savedQueue);

        }

        System.out.println(savedQueue);
        while (!savedQueue.isEmpty())
            numbers[savedQueue.poll().index] = -1;

        return numbers;
    }
}

class Saved implements Comparable<Saved>{
    int index;
    int value;
    public Saved(int index, int val) {
        this.index = index;
        this.value = val;
    }
    @Override
    public int compareTo(Saved o) {
        if(this.value > o.value) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "" + value + ", " + index;
    }
}