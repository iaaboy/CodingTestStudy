package acmicpc12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 가장 긴 증가하는 부분 수열 2
 * https://www.acmicpc.net/problem/12015
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] seq = new int[n];
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        seq[0] = num;
        int lis = 0;
        for (int i = 1; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            int low = 0;
            int high = lis;
            if (num > seq[lis]) {
                seq[++lis] = num;
            } else {
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (seq[mid] < num) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                seq[low] = num;
            }
        }
        System.out.println(lis + 1);
        br.close();
    }
}