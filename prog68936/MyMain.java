package prog68936;

import java.util.Arrays;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] arr = { { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } },
                { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 },
                        { 0, 1, 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 } }
        };

        Solution mSol = new Solution();
        for (int[][] ar : arr) {
            System.out.println(Arrays.toString(mSol.solution(ar)));
        }
    }
}

class Solution {

    static int[] quadX = { 0, 1, 0, 1 };
    static int[] quadY = { 0, 0, 1, 1 };

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = (int) (Math.log(arr.length) / Math.log(2));
        int arrayLength = arr.length;

        // printCurrent(arr);

        int gap = 1;
        for (int z = 1; z < n + 1; z++) {
            for (int b = 0; b < arrayLength; b += 2 * gap) {
                for (int a = 0; a < arrayLength; a += 2 * gap) {
                    int countAll0 = 0;
                    int countAll1 = 0;
                    for (int i = 0; i < 4; i++) {
                        int optX = gap * quadX[i];
                        int optY = gap * quadY[i];
                        if (arr[b + optY][a + optX] == 0) {
                            countAll0++;
                        } else if (arr[b + optY][a + optX] == 1) {
                            countAll1++;
                        }
                    }
                    if (countAll0 == 4) {
                        arr[b][a] = 0;
                    } else if (countAll1 == 4) {
                        arr[b][a] = 1;
                    } else {
                        arr[b][a] = -1;
                        answer[0] += countAll0;
                        answer[1] += countAll1;
                    }
                }
            }
            // printCurrent(arr);
            gap *= 2;
        }

        if (arr[0][0] == 0) {
            answer[0] = 1;
        } else if (arr[0][0] == 1) {
            answer[1] = 1;
        }
        return answer;
    }

    void printCurrent(int [][] arr) {
        // Temp for Print
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[0].length; i++)
                System.out.print(arr[j][i] + " ");
            System.out.println();
        }
    }
}