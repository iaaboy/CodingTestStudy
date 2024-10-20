package prog181187;

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        System.out.println(mSol.solution(2, 3));
    }
}

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        double count = 0;

        //r1 제곱
        double r1square = Math.pow(r1, 2);
        //r2 제곱
        double r2square = Math.pow(r2, 2);

        for (long x = 0; x <= r2; x++) {
            // System.out.println("current x: " + x);
            double xSqure = Math.pow(x, 2);
            double r2x = Math.sqrt(r2square - xSqure);
            double r1x;
            if(r1square >= xSqure) {
                r1x = Math.sqrt(r1square - xSqure);
            } else {
                r1x = 0;
            }

            count = count + Math.floor(r2x) - Math.ceil(r1x) +1;
            // System.out.println("r1과 만나는 y: " + r1x + ",올림: " + Math.ceil(r1x));
            // System.out.println("r2와 만나는 y: " + r2x + ", 내림: " + Math.floor(r2x));
            // System.out.println(count);
        }

        count -=  (r2-r1 +1);
        answer += count * 4;

        return answer;
    }
}