package prog150367;


public class MyMain {
    public static void main(String[] args) {
        long [] numbers = {7, 42, 5};

        Solution mSolution = new Solution();
        System.out.println(mSolution.solution(numbers));
    }
}

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int [numbers.length] ;

        for(int i = 0; i < numbers.length; i++) {
            answer[i] = checkNumber(numbers[i]);
        }

        return answer;
    }

    int checkNumber (long num) {

        

        return 0;    
    }
}