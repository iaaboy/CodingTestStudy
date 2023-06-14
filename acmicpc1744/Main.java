package acmicpc1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
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
        ArrayList<Integer> minusNumber = new ArrayList<>();
        ArrayList<Integer> plusNumber = new ArrayList<>();
        Integer countZero = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                plusNumber.add(numbers[i]);
            } else if (numbers[i] == 0) {
                countZero++;
            } else {
                minusNumber.add(numbers[i]);
            }
        }

        plusNumber.sort((a, b) -> {
            return b - a;
        });

        minusNumber.sort((a, b) -> {
            return Math.abs(b) - Math.abs(a);
        });

        // System.out.println(Arrays.toString(numbers));
        // System.out.println(countZero);
        // System.out.println(plusNumber);
        // System.out.println(minusNumber);

        int sum = 0;

        // plus가 짝수개 처리
        for (int i = 0; i < plusNumber.size() / 2; i++) {
            // System.out.println(plusNumber.get(i * 2) + "*" + plusNumber.get(i * 2 + 1));
            if (plusNumber.get(i * 2) == 1 || plusNumber.get(i * 2 + 1) == 1) {
                sum += plusNumber.get(i * 2) + plusNumber.get(i * 2 + 1);
            } else {
                sum += plusNumber.get(i * 2) * plusNumber.get(i * 2 + 1);
            }
        }

        // minus가 짝수개 처리
        for (int i = 0; i < minusNumber.size() / 2; i++) {
            // System.out.println(minusNumber.get(i * 2) + "*" + minusNumber.get(i * 2 +
            // 1));
            sum += minusNumber.get(i * 2) * minusNumber.get(i * 2 + 1);
        }

        //
        if (minusNumber.size() % 2 == 1 && countZero > 0) {
            // skip minusNumber
            // -x * 0 = 0
        } else {
            if (minusNumber.size() % 2 == 1 && minusNumber.size() > 0) {
                // System.out.println(minusNumber.get(minusNumber.size() - 1));
                sum += minusNumber.get(minusNumber.size() - 1);
            }
        }

        if (plusNumber.size() % 2 == 1) {
            // System.out.println(plusNumber.get(plusNumber.size() - 1));
            sum += plusNumber.get(plusNumber.size() - 1);
        }

        System.out.println(sum);
    }
}