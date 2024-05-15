package acmicpc11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[m + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 2; j <= m; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[j] = val + arr[j-1];
            }
            //Arrays.sort(arr);

            int dp[][] = new int[m+1][m+1];

            for(int gap=1; gap<m; gap++) {
                for(int start = 1; start+gap <= m; start++) {
                    int end = start + gap;
                    dp[start][end] = Integer.MAX_VALUE;

                    for(int mid = start; mid<end ;mid++) {
                        dp[start][end] = Math.min(dp[start][end],dp[start][mid]+dp[mid+1][end]+arr[end]-arr[start-1]);
                    }
                }
            }


            System.out.println(dp[1][m]);
        }
    }
}
