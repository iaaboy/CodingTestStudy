package maxPairSum;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int ai = scanner.nextInt();
            int bi = scanner.nextInt();

            map.putIfAbsent(ai, new ArrayList<>());
            map.get(ai).add(bi);
        }

        List<Integer> values = new ArrayList<>();

        for (List<Integer> list : map.values()) {
            values.addAll(list);
        }

        Collections.sort(values);

        int maxSum = -1;
        int left = 0, right = values.size() - 1;

        while (left < right) {
            int sum = values.get(left) + values.get(right);
            if (sum < k) {
                maxSum = Math.max(maxSum, sum);
                left++; // 더 큰 합을 만들기 위해 왼쪽 포인터 이동
            } else {
                right--; // 합이 너무 크므로 오른쪽 포인터 이동
            }
        }

        System.out.println(maxSum);
    }
}