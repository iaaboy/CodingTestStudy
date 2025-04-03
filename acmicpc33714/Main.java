package acmicpc33714;

import java.io.*;
import java.util.*;

/*
 * 시간초과 실패
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> numMap = new HashMap<>();
        st = new StringTokenizer(bf.readLine());
        int base = Integer.MAX_VALUE;
        int top = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
            base = Math.min(base, num);
            top = Math.max(top, num);
        }
        Integer[] keys = numMap.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        // System.out.println(Arrays.toString(keys));

        int min = Integer.MAX_VALUE;
        // min
        // 1. 제거
        int prevKey = 0;
        for (Integer k : keys) {
            if (k - prevKey > 1) {
                min = prevKey + 1;
                break;
            }
            int count = numMap.get(k);
            if (count <= K) {
                // 가능
                min = k;
                break;
            }
            prevKey = k;
        }

        // 2. 추가
        if (base >= 1) {
            min = Math.min(min, 0);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append("\n");

        // max
        // 바닥부터 채워나감.
        // 2. 추가
        int k = K;
        prevKey = 0;
        int max = 0;
        boolean isHandled = false;
        for (int i = 0; i < keys.length; i++) {
            int diff = i == 0 ? keys[i] : keys[i] - keys[i - 1];
            if (diff > 1) {
                if(k - (diff - 1) >= 0) {
                    k -= (diff - 1);
                } else {
                    max = keys[i - 1] + k + 1;
                    isHandled = true;
                    break;
                }
            }
        }
        if (!isHandled) {
            max = keys[keys.length - 1] + k + 1;
        }

        // 1. 제거

        sb.append(max).append("\n");

        System.out.print(sb);
    }
}
