package play0318;

import java.util.Arrays;

public class TestMain_0318 {

        public static void main(String[] args) {
    
            String maps[] = {"15X1X","11X5X","1XXXX", "1XXX1"};
            String maps2[] = {"XXX","XXX","XXX"};
            String maps3[] = {"X591X","X1X5X","X231X", "1XXX1"};
            
            Solution mSolution = new Solution();
            System.out.println("maps result" + Arrays.toString(mSolution.solution(maps)));
            System.out.println("maps2 result" + Arrays.toString(mSolution.solution(maps2)));
            System.out.println("maps3 result" + Arrays.toString(mSolution.solution(maps3)));
        }
}
    