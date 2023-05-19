package prog42748;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        int[] inArray = { 1, 5, 2, 6, 3, 7, 4 };
        // 시작, 종료, 결과의 N번째
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
        Solution nSol = new Solution();
        System.out.println(Arrays.toString(nSol.solution(inArray, commands)));
    }
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] cmd : commands) {
            // 1 array자른다
            int[] arr1 = Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]);
            // 2 array 정렬
            Arrays.sort(arr1);
            // n번째 원소 copy
            answer[idx++] = arr1[cmd[2] - 1];
        }
        return answer;
    }
}