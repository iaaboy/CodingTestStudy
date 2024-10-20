package prog131705;

/* 삼총사
 * https://school.programmers.co.kr/learn/courses/30/lessons/131705
 */

public class MyMain {
    public static void main(String[] args) {
        int[] number = { -2, 3, 0, 2, -5 };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(number));
    }
}

class Solution {
    int answer;
    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        answer = 0;
        comb1(number, visited, 0, 3);
        return answer;
    }

    void comb1(int[] number, boolean[] visited, int start, int r) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    System.out.print(i + " ");
                    sum += number[i];
                }
            }
            System.out.println(sum);
            if (sum == 0) {
                answer++;
            }
            return;
        } else {
            for (int i = start; i < visited.length; i++) {
                visited[i] = true;
                comb1(number, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}