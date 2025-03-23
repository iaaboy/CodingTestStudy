package acmicpc17299;

import java.io.*;
import java.util.*;

/* 오등큰수
 * https://www.acmicpc.net/problem/17299

cMap (HashMap) : 숫자 , 등장수
countStack(HashMap) : 숫자, 스택(index, 먼순서부터 스택에 쌓임)

0 ~ N-1까지 현재 숫자를 순회
현재 숫자를 countStack의 스택에서 뺀다.
key(등장숫자) 를 순회하면서, 등장 숫자가 나보다 크고, Stack top(등장 숫자중 가장 왼쪽)에 있는 것중 가장 왼쪽에 있는것 출력
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> cMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cMap.put(arr[i], cMap.getOrDefault(arr[i], 0) + 1);
        }
        HashMap<Integer, Stack<Integer>> countStack = new HashMap<>();
        for (int i = N - 1; i >= 0; i--) {
            int cnt = cMap.get(arr[i]);
            if (!countStack.containsKey(cnt)) {
                countStack.put(cnt, new Stack<>());
            }
            countStack.get(cnt).push(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int curCnt = cMap.get(arr[i]);
            countStack.get(curCnt).pop();
            int oken = Integer.MAX_VALUE;
            for (int k : countStack.keySet()) {
                // System.out.println(k + ":" + countStack.get(k));
                if (k > curCnt && !countStack.get(k).empty() && oken > countStack.get(k).peek()) {
                    oken = countStack.get(k).peek();
                }
            }
            if (oken == Integer.MAX_VALUE) {
                oken = -1;
            } else {
                oken = arr[oken];
            }
           sb.append(oken + " ");
        }
        System.out.println(sb);
    }
}
