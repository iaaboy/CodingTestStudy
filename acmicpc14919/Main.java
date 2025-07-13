package acmicpc14919;

import java.io.*;
import java.util.*;

/* 분포표 만들기
 * https://www.acmicpc.net/problem/14919
 * 수학, double(소수점)
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        ArrayList<Double> nums = new ArrayList<>();
        while (st.hasMoreTokens()) {
            double num = Double.parseDouble(st.nextToken());
            nums.add(num);
        }
        Double[] comparison = new Double[N + 1];
        for (int i = 0; i <= N; i++) {
            comparison[i] = (double)i / (double)N ;
        }
        // System.out.println(nums);
        // System.out.println(Arrays.toString(comparison));
        int[] count = new int[N + 1];
        for (Double num : nums) {
            for (int i = 0; i < N; i++) {    
                if (comparison[i] <= num && comparison[i + 1] > num) {
                    count[i]++;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int count3 = 0; count3 < count.length - 1; count3++) {
            sb.append(count[count3]).append(" ");
        }
        System.out.println(sb);
    }
}
