package acmicpc1541;

import java.io.*;

/* 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inStr = bf.readLine();
        String[] numbers = inStr.split("\\+|\\-");
        int[] num = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i] = Integer.parseInt(numbers[i]);
        }
        int minusLocation = Integer.MAX_VALUE;
        int plusCount = 0;
        for (int i = 0; i < inStr.length(); i++) {
            if (inStr.charAt(i) == '+') {
                plusCount++;
            } else if (inStr.charAt(i) == '-') {
                minusLocation = plusCount;
                break;
            }
        }
        int sum = num[0];
        for (int i = 1; i < num.length; i++) {
            if (minusLocation < i) {
                sum -= num[i];
            } else {
                sum += num[i];
            }
        }
        System.out.println(minusLocation);
        System.out.println(sum);
    }
}
