package prog0402;

import java.util.*;

class MyMain {
    public static void main(String[] args) {
        int [] inputArr = {2, 3, 6, 1, 1, 3 , 2, -4, -1, 5, 7};

        Solution sol = new Solution();
        long result = sol.solution(inputArr);
        System.out.println(result);
    }
}

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int [] seq1 = new int[sequence.length];
        int [] seq2 = new int[sequence.length];

        int pulse = -1;
        for(int i = 0; i < sequence.length; i++) {
            seq1[i] = sequence[i]*pulse;
            seq2[i] = sequence[i]*pulse*-1;
            pulse = pulse*-1;
        }

        //System.out.println(Arrays.toString(seq1));
        answer = calcIt(seq1);
        //System.out.println(Arrays.toString(seq2));
        calcIt(seq2);

        return answer;
    }
    private int calcIt(int[] numbers){
        LinkedList <Integer> result2 = new LinkedList<>();
        int prevSig = 0;
        for(int i=0; i< numbers.length ; i++) {
            if(prevSig * numbers[i] > 0) {
                result2.set(result2.size()-1, result2.peekLast() + numbers[i]);
            } else if(numbers[i] == 0) {

            } else {
                result2.add(numbers[i]);
            }

            if(numbers[i] < 0) {
                prevSig = -1;
            } else if(numbers[i] > 0) {
                prevSig = 1;
            }
        }

        //System.out.println("sequence: " + result2);

        int indexMid = 1;
        int subResult = 0;
        while((indexMid <= result2.size() - 2 && result2.size() > 2)) {
            int pre =result2.get(indexMid-1);
            int mid =result2.get(indexMid);
            int post =result2.get(indexMid+1);

            if(Math.abs(mid) <= Math.abs(pre) && Math.abs(mid) <= Math.abs(post)) {
                //합쳐
                subResult = pre + mid + post;
                result2.set(indexMid - 1, subResult);
                result2.remove(indexMid + 1);
                result2.remove(indexMid);
                indexMid --;
                //System.out.println("mid result:" + result2);
            } else {
                indexMid++;
            }
        }

        int max = 0;
        for(int a : result2) {
            if(Math.abs(a)>max) {
                max = Math.abs(a);
            }
        }

        return max;
    }
}

