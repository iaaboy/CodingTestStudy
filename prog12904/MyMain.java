package prog12904;

/* 가장 긴 팰린드롬
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12904
 */
public class MyMain {
    public static void main(String[] args) {
        String [] sen = {"abcdcba", "abacde", "abababacd"};
        Solution mSol = new Solution();
        
        for(String s : sen) {
            System.out.println(mSol.solution(s));
        }
    }
}

class Solution {
    public int solution(String s) {
        char[] cArr = s.toCharArray();
        int answer = 0;
        if(s.length() == 1)
            return 1;
        if(s.length() == 2) {
            if(cArr[0] != cArr[1])
                return 1;
        }

        for (int i = 0; i < cArr.length - 1; i++) {
            if (cArr[i] == cArr[i + 1]) {
                answer = Math.max(answer, checkPelin(cArr, i, false));
            }
            if (i < cArr.length - 2 && cArr[i] == cArr[i + 2]) {
                answer = Math.max(answer, checkPelin(cArr, i, true));
            }
        }
        return answer;
    }

    private int checkPelin(char[] cArr, int center, boolean isOdd) {
        int offset = isOdd ? 2 : 1;
        int pelinCount = offset + 1;
        for (int left = center - 1; left >= 0; left--) {
            int right = left + (center - left) * 2 + offset;
            if (right >= cArr.length) {
                // System.out.println("right Over: " + left + ", " + right);
                break;
            }
            if (cArr[left] != cArr[right]) {
                // System.out.println("mismatched: " + left + ", " + right);
                break;
            } 
            pelinCount += 2;
            // System.out.println("matched: " + left + ", " + right);
        }
        return pelinCount;
    }
}