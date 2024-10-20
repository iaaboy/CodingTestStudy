package prog0325;


//https://school.programmers.co.kr/learn/courses/30/lessons/43165

public class MyMain {
    
    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4, 1, 2, 1};
        Solution mSolution = new Solution();
        System.out.println(mSolution.solution(numbers1, 3));
        System.out.println(mSolution.solution(numbers2, 4));
    }
}

class Solution {
    public int solution(int[] numbers, int target) {

        //System.out.println("solution Called");

        //1. 모든 조합을 다 해본다.
        int count = 1;
        int len = numbers.length;
        for(int j = 0; j< len; j++ ){
            count = count*2;
        }

        int sum = 0;
        int answer = 0;
        for(int i=0; i< count; i++){
            //i의 bit가 1이면 +
            //i의 bit가 0이면 -
            //result = ...

            int number = i;
            //System.out.println(Integer.toBinaryString(i));
            sum = 0;
            for(int j = 0; j < len; j++) {
                if((number & 1) > 0) {
                    //+
                    sum += numbers[j];
                } else {
                    //-
                    sum -= numbers[j];
                }
                number = number >> 1;
            }
            //System.out.println("");

            if(target == sum) {
                answer ++;
            }
        }
        System.out.println(count + " " + answer);

        return answer;
    }
}
