package acmicpc1668;

import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }

        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;
        int lCount = 0, rCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lMax < nums[i]) {
                lMax = nums[i];
                lCount++;
            }
            if (rMax < nums[N - i - 1]) {
                rMax = nums[N - i - 1];
                rCount++;
            }
        }
        System.out.println(lCount + "\n" + rCount);
    }
}
