package play0318;

public class TestMain_0318 {

    /*
     maps	result
      ["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
      ["XXX","XXX","XXX"]	[-1]
     */
    
        public static void main(String[] args) {
    
            String maps[] = {"X591X","XXX5X","X231X", "1XXX1"};
            String maps2[] = {"XXX","XXX","XXX"};
            String maps3[] = {"X591X","X1X5X","X231X", "1XXX1"};
            
            Solution mSolution = new Solution();
            System.out.println("maps result" + mSolution.solution(maps));
            System.out.println("maps2 result" + mSolution.solution(maps2));
            System.out.println("maps3 result" + mSolution.solution(maps3));
        }
}
    