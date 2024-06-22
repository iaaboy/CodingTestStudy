package acmicpc5710;

import java.io.*;
import java.util.*;

/* 전기 요금
 * https://www.acmicpc.net/problem/5710
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int totalFare = Integer.parseInt(st.nextToken());
            int needDiff = Integer.parseInt(st.nextToken());

            if (totalFare == 0 && needDiff == 0) {
                break;
            }

            int totalElec = getElec(totalFare);
            int left = 0;
            int right = totalElec / 2;
            int mid = (left + right) / 2;
            while (left <= right) {
                int sgFair = getFair(mid); // 중간값(전력)으로 요금 구한다.
                int neighborFair = getFair(totalElec - mid); // 이웃의 요금 구한다

                int diff = Math.abs(sgFair - neighborFair); // 두 요금의 diff 계산
                if (diff < needDiff) {
                    right = mid - 1;
                } else if (diff > needDiff) {
                    left = mid + 1;
                } else { // 입력받은 diff와 같으면 return
                    sb.append(getFair(mid) + "\n");
                    break;
                }
                mid = (left + right) / 2;
            }
        }
        System.out.println(sb);
    }

    private static int getElec(int cost) {
        if (cost <= 200) {
            return cost / 2;
        } else if (cost <= 29900) {
            return (cost - 200) / 3 + 100;
        } else if (cost <= 4979900) {
            return (cost - 29900) / 5 + 10000;
        } else {
            return (cost - 4979900) / 7 + 1000000;
        }
    }

    public static int getFair(int watt) {
        if (watt <= 100) {
            return watt * 2;
        } else if (watt <= 10000) {
            return 200 + (watt - 100) * 3;
        } else if (watt <= 1000000) {
            return 200 + 29700 + (watt - 10000) * 5;
        } else {
            return 200 + 29700 + 4950000 + (watt - 1000000) * 7;
        }
    }
}
