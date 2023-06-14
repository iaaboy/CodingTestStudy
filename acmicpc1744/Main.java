package acmicpc1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    // 양수 : 큰수부터 두개씩 짝지어 곱
    // - 예외 1*1 < 1+1 : 작은수가 1이면
    // 음수 : 작은수부터 두개씩 짝지어 곱
    // 양수/음수/0 각 하나 이하로 남았을 때 처리
    // 1 / 1 / 1 : 음수량 0 이랑 곱
    // 0 / 1 / 1 : "
    // 1 / 0 / 1 : 그냥 더해
    // 1 / 1 / 0 : "
    // 1 / 0 / 0 : "
    // 0 / 1 / 0 : "
    // 0 / 0 / 1 : "
    // 0의 개수는 홀수개인지만 의미 있음.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inN = Integer.parseInt(reader.readLine());
        int[] numbers = new int[inN];

        for (int i = 0; i < inN; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        new Main().solution(numbers);
    }

    public void solution(int[] numbers) {
        Arrays.sort(numbers);

        int minusCount = 0;
        int plusCount = 0;
        int zeroCount = 0;
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                minusCount++;
            } else if (numbers[i] == 0) {
                zeroCount++;
            } else {
                plusCount++;
            }
        }

        // System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < plusCount / 2; i++) {
            // System.out.println(numbers[numbers.length - i * 2 - 1]);
            // System.out.println(numbers[numbers.length - i * 2 - 2]);
            if (numbers[numbers.length - i * 2 - 2] == 1 || numbers[numbers.length - i * 2 - 1] == 1) {
                sum += numbers[numbers.length - i * 2 - 1] + numbers[numbers.length - i * 2 - 2];
            } else {
                sum += numbers[numbers.length - i * 2 - 1] * numbers[numbers.length - i * 2 - 2];
            }
        }

        for (int i = 0; i < minusCount / 2; i++) {
            // System.out.println(numbers[i * 2]);
            // System.out.println(numbers[i * 2 + 1]);
            sum += numbers[i * 2] * numbers[i * 2 + 1];
        }

        if (minusCount % 2 > 0 && zeroCount >= 1) {
            if (plusCount % 2 > 0) {
                sum += numbers[numbers.length - plusCount];
            }
        } else {
            if (plusCount % 2 > 0) {
                sum += numbers[numbers.length - plusCount];
            }
            if (minusCount % 2 > 0) {
                sum += numbers[minusCount - 1];
            }
        }

        System.out.println(sum);
    }
}