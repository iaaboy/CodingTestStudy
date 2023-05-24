package prog42839;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String numbers = "011";

        Solution mSol = new Solution();
        System.out.println(mSol.solution(numbers));
    }
}

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int[] nums = new int[numbers.length()];
        int idx = 0;
        for (char c : numbers.toCharArray()) {
            nums[idx++] = c - '0';
        }
        // 만들 수 있는 카드 조합을 구한다
        permutation(nums, 0, nums.length, nums.length);

        // 소수인지 체크

        return answer;
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            System.out.println("result: " + Arrays.toString(arr) + ", r:"+ r);
            return;
        }
     
        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
     
    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    boolean chkPrime(int num) {
        return false;
    }
}