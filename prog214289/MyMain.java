package prog214289;

/* 에어컨
 * https://school.programmers.co.kr/learn/courses/30/lessons/214289
 */

public class MyMain {
    public static void main(String[] args) {
        //temperature: 외부온도,   실내 온도 범위 t1 ~ t2 
        //온도가 다를때 1분당 전력 : a
        //온도가 같을때 1분당 전력 : b
        int temperature = 28; int t1 = 18; int t2 = 26; int a= 10; int b=8; int[] onboard = {0, 0, 1, 1, 1, 1, 1};//	40
        // int temperature = -10; int t1 = -5; int t2 = 5; int a= 5; int b=1; int[] onboard = {0, 0, 0, 0, 0, 1, 0};//	25
        // int temperature = 11; int t1 = 8; int t2 = 10; int a= 10; int b=1; int[] onboard = {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1]};//	20
        // int temperature = 11; int t1 = 8; int t2 = 10; int a= 10; int b=100; int[] onboard = {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1];//	60

        Solution mSol = new Solution();
        System.out.println(mSol.solution(temperature, t1, t2, a, b, onboard));
    }
}

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = 0;

        


        return answer;
    }
}