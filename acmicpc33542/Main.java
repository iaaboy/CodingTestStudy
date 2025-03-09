package acmicpc33542;

import java.io.*;
import java.util.*;

/* 극적인 승리
 * https://www.acmicpc.net/problem/33542
입력중 오른쪽은 정렬하고, 
왼쪽을 전체 탐색하여 둘의 합 + B 값이 A보다 크거나 같은 (LowerBound) 값을 찾아 업데이트함.
!! 한쪽이 -1인 경우 주의
 */

public class Main {
    static int N;
    static long[][] arr;

    public static void main(String[] args) throws IOException, Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long initialDiff = A - B;
        N = Integer.parseInt(bf.readLine());
        arr = new long[N][2];
        ArrayList<Integer> rIdx = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Long.parseLong(st.nextToken()); // 0 left
            arr[i][1] = Long.parseLong(st.nextToken()); // r right
            rIdx.add(i);
        }

        Collections.sort(rIdx, (a, b) -> Long.compare(arr[a][1], arr[b][1]));
        // System.out.println(rIdx);

        if (B > A) {
            System.out.println("-1 -1");
            return;
        }

        long minLeft = -2;
        long minRight = -2;
        long minDiff = Long.MAX_VALUE;
        int rIdxSize = rIdx.size();
        for (int left = 0; left < N; left++) {
            int right = upperBound(rIdx, initialDiff - arr[left][0]);
            if (right < rIdxSize && rIdx.get(right) == left) {
                right++;
            }
            if (right >= rIdxSize) {
                right = -1;
            } else {
                right = rIdx.get(right);
            }

            if (right >= 0) {
                long curDiff = arr[left][0] + arr[right][1] - initialDiff;
                //System.out.println((left + 1) + "," + (right + 1) + ":" + curDiff);
                if (curDiff > 0 && curDiff < minDiff) {
                    minLeft = left;
                    minRight = right;
                    minDiff = curDiff;
                    // if (minDiff == 1) {
                    //     break;
                    // }
                }
            }

        }
        
        for (int i = 0; i < N; i++) {
            if (arr[i][0] - initialDiff > 0 && arr[i][0] - initialDiff < minDiff) {
                //set left
                minLeft = i;
                minRight = -2;
                minDiff = arr[i][0] - initialDiff;
            }
            if (arr[i][1] - initialDiff > 0 && arr[i][1] - initialDiff < minDiff) {
                //set rigt
                minLeft = -2;
                minRight = i;
                minDiff = arr[i][1] - initialDiff;
            }
        }

        // if (minLeft < 0 && minRight > 0) {
        //     throw new Exception("예외 발생");
        // } else if (minLeft > 0 && minRight < 0) {
        //     throw new Exception("예외 발생");
        // }

        if (minDiff == Long.MAX_VALUE) {
            System.out.println("No");
        } else {
            minLeft++;
            minRight++;
            System.out.println(minLeft + " " + minRight);
        }

    }

    private static int upperBound(ArrayList<Integer> index, long key) {
        int left = 0;
        int right = index.size();
        while (left < right) {
            int center = (left + right) / 2;
            if (arr[index.get(center)][1] <= key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return left;
    }
}
