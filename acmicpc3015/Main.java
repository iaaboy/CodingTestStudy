package acmicpc3015;

import java.io.*;
import java.util.*;

/* 오아시스 재결합
 * https://www.acmicpc.net/problem/3015
모노톤 스택 이해 필요!!
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        // int count = 0;
        // Stack<Integer> stack = new Stack<>();

        // int N = 5;
        // Integer[] arr = { 2, 4, 1, 2, 2, 5, 1 };
        // List<Integer> list = Arrays.asList(arr);
        // Collections.shuffle(list);
        // list.toArray(arr);
        Stack<Person> stack = new Stack<>();
        // System.out.println(Arrays.toString(arr));
        long totalCount = 0;
        for (int i = 0; i < arr.length; i++) {
            long count = 1;
            while (!stack.isEmpty() && stack.peek().height <= arr[i]) {
                Person prev = stack.pop();
                totalCount += prev.count;
                if (prev.height == arr[i]) {
                    count += prev.count;
                }
            }
            if (!stack.isEmpty()) {
                totalCount++;
            }
            stack.push(new Person(arr[i], count));
            // System.out.println(arr[i] + ":" + totalCount + "," + stack);
        }
        System.out.println(totalCount);
    }

    static class Person {
        int height;
        long count;

        public Person(int height, long count) {
            this.height = height;
            this.count = count;
        }

        @Override
        public String toString() {
            return height + "(" + count + ")";
        }
    }
}
