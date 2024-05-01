package prog12899_2;

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        for (int i = 1; i < 21; i++) {
            System.out.println(i + ":" + mSol.solution(i));
        }

    }
}

class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            sb.append(n % 3 == 0 ? 4 : n % 3);
            n = (n - 1) / 3;
        }
        return sb.reverse().toString();
    }
}