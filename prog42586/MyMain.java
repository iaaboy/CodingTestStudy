package prog42586;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int [][] prog = {{93, 30, 55, 60, 40, 55}, {95, 90, 99, 99, 80, 99}};
        int [][] speed = {{1, 30, 5, 10, 60, 5}, {1, 1, 1, 1, 1, 1}};
        // [93, 30, 55, 60, 40, 65], [1, 30, 5, 10, 60, 7], [2, 4]

        Solution mSol = new Solution();
        for(int i = 0; i < 2; i++){
            mSol.solution(prog[i], speed[i]);
        }
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] remained = new int[progresses.length];

        for(int i = 0; i < progresses.length ; i++) {
            remained[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) - remained[i]*speeds[i] > 0) {
                remained[i] ++;
            }
        }


        System.out.println(Arrays.toString(remained));

        Queue <Integer> q = new LinkedList<>();

        int releaseDate  = remained[0];
        int cnt = 1;
        for(int i = 1; i < progresses.length ; i++) {
            if(releaseDate < remained[i]) {
                System.out.println("release today: " + remained[i]);
                releaseDate = remained[i];
                q.add(cnt);
                cnt = 1;
            } else {
                System.out.println("keep this: " + remained[i]);
                cnt++;
            }
        }
        q.add(cnt);

        answer = new int [q.size()];

        int index = 0;
        while(q.size() > 0) {
            answer[index++] = q.peek();
            q.remove();
        }

        System.out.println("a:" + Arrays.toString(answer));
        return answer;
    }
}