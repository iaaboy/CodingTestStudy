package acmicpc2143;

import java.io.*;
import java.util.*;

/* 두 배열의 합 
 * https://www.acmicpc.net/problem/2143
 */

/*
A array의 누적합 Array를 미리 구한다. 
각 부배열의 합을 구해서 hashmap에 키(합) vs 카운트를 저장한다.
이분탐색을 위해 A array를 소트 

B array에 대해 같은 방식으로 hashmap에 키 vs 카운트를 저장한다.
b array의 각 값에 대해 A array에서 합이 T가 되는 값을 이분 탐색하여, 
있을 경우 count에 각 개수 곱을 더해준다.
count를 출력!
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long T = Long.parseLong(bf.readLine());
        int A = Integer.parseInt(bf.readLine());

        long sumA[] = new long[A];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        sumA[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < A; i++) {
            sumA[i] = sumA[i - 1] + Long.parseLong(st.nextToken());
        }
        int B = Integer.parseInt(bf.readLine());
        long sumB[] = new long[B];
        st = new StringTokenizer(bf.readLine());
        sumB[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < B; i++) {
            sumB[i] = sumB[i - 1] + Long.parseLong(st.nextToken());
        }
        // System.out.println(Arrays.toString(sumA));
        ArrayList<Long> aKeyList = new ArrayList<>();
        HashMap<Long, Long> aCount = new HashMap<>();
        for (int i = 0; i < A; i++) {
            for (int j = i; j < A; j++) {
                long sum;
                sum = i == 0 ? sumA[j] : sumA[j] - sumA[i - 1];
                if (!aCount.containsKey(sum)) {
                    aCount.put(sum, 1L);
                    aKeyList.add(sum);
                } else {
                    aCount.put(sum, aCount.get(sum) + 1);
                }
            }
        }
        aKeyList.sort(null);
        // ArrayList<Long> bKeyList = new ArrayList<>();
        HashMap<Long, Long> bCount = new HashMap<>();
        for (int i = 0; i < B; i++) {
            for (int j = i; j < B; j++) {
                long sum;
                sum = i == 0 ? sumB[j] : sumB[j] - sumB[i - 1];
                if (!bCount.containsKey(sum)) {
                    bCount.put(sum, 1L);
                    // bKeyList.add(sum);
                } else {
                    bCount.put(sum, bCount.get(sum) + 1);
                }
            }
        }
        // System.out.println(aKeyList);
        // System.out.println(bKeyList);
        Long count = 0L;
        for (Long bKey : bCount.keySet()) {
            long targetNum = T - bKey;
            int aKey = lowerBound(aKeyList, targetNum);
            if (aKey >= aKeyList.size() || aKeyList.get(aKey) != targetNum) {
                continue;
            }
            count += aCount.get(aKeyList.get(aKey)) * bCount.get(bKey);
        }
        System.out.println(count);
    }

    private static int lowerBound(ArrayList<Long> arr, long key) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int center = (left + right) / 2;
            if (arr.get(center) < key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return right;
    }
}