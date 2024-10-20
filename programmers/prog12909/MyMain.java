package prog12909;

public class MyMain {
    public static void main(String[] args) {
        String inStr = "((()))())(";

        Solution nSol = new Solution();
        System.out.println("result: " + nSol.solution(inStr));
    }
}

class Solution {
    boolean solution(String s) {
            int numOpenBr = 0;
            for(char c : s.toCharArray()) {
                if(c == '(') {
                    numOpenBr++;
                } else if(c == ')') {
                    numOpenBr--;
                }
                if(numOpenBr < 0) {
                    return false;
                }
            }
            if(numOpenBr == 0 ) {
                return true;
            } else
                return false;
    }
}
