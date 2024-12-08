package acmicpc23029;

import java.io.*;

/* 시식 코너는 나의 것
 * https://www.acmicpc.net/problem/23029
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int first = Integer.parseInt(bf.readLine());
        int second = 0;
        int third = 0;
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());

            int tempFirst = third + num;
            int tempSecond = first + num / 2;
            int tempThird = Math.max(Math.max(first, second), third);
            first = tempFirst;
            second = tempSecond;
            third = tempThird;
        }
        System.out.println(Math.max(first, Math.max(second, third)));

    }
}
