package prog147354;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        int[][] data = { { 2, 2, 6 }, { 1, 5, 10 }, { 4, 2, 9 }, { 3, 8, 3 } };
        int col = 2;
        int row_begin = 2;
        int row_end = 3;

        Solution mSol = new Solution();
        System.out.println(mSol.solution(data, col, row_begin, row_end));
    }
}

class Solution {
    public int solution(int[][] data, int col, int rb, int re) {
        int answer = -1;
        Data[] myArr = new Data[data.length];
        for (int i = 0; i < data.length; i++) {
            myArr[i] = new Data(data[i], col - 1);
        }

        Arrays.sort(myArr);
        // System.out.println(" " + Arrays.toString(myArr));

        for (int i = rb - 1; i <= re - 1; i++) {
            int sum = 0;
            for (int k = 0; k < myArr[i].arr.length; k++) {
                sum += myArr[i].arr[k] % (i + 1);
            }
            // System.out.println(i+1 + ": "+sum);
            if (answer == -1) {
                answer = sum;
            } else {
                answer ^= sum;
            }
        }

        return answer;
    }
}

class Data implements Comparable<Data> {
    int[] arr;
    int col;

    public Data(int[] arr, int col) {
        this.arr = arr;
        this.col = col;
    }

    @Override
    public int compareTo(Data o) {
        if (arr[col] == o.arr[col]) {
            return o.arr[0] - arr[0];
        } else {
            return arr[col] - o.arr[col];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr) + "," + col;
    }
}