package prog12904;

public class MyMain {
    public static void main(String[] args) {
        String [] sen = {"abcdcba", "abacde", "abababacd"};
        Solution mSol = new Solution();
        
        for(String s : sen) {
            System.out.println(mSol.solution(s));
        }
    }
}

class Solution
{
    public int solution(String s)
    {
        int [] pair = new int[s.length()];

        char [] sArray = s.toCharArray();
        for(int i = 0; i < sArray.length ; i++) {
            for(int j = i; j < sArray.length ; j++) {
                if(sArray[i] == sArray[j]) {

                }
            }
        }
        int answer = 0;
        return answer;
    }
}