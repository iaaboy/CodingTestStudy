package prog43105;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class MyMain {
    public static void main(String[] args) {
        int [][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        Solution mSol = new Solution();
        System.out.println("answer: " + mSol.solution(triangle));
    }
}

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int j = 1;
        for(; j < triangle.length ; j++) {
            for(int i = 0 ; i < triangle[j].length; i++) {
                if(i == 0) { //맨처음
                    triangle[j][i] = triangle[j-1][i] + triangle[j][i];
                } else if(i == triangle[j].length - 1) { // 맨 마지막
                    triangle[j][i] = triangle[j-1][i-1] + triangle[j][i];
                } else { //normal
                    triangle[j][i] = Math.max(triangle[j-1][i-1], triangle[j-1][i]) + triangle[j][i];                    
                }
            }
        }

        for(int num : triangle[j-1]) {
            if(answer < num) {
                answer = num;
            }
        }

        return answer;
    }
}