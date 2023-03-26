package acmicpc0322;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준문제.
//https://www.acmicpc.net/problem/10974

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inN = Integer.parseInt(br.readLine());

        new Main().solution(inN);
    }

    public void solution(int n) { // N 출력
        int[] nums = new int[n];
        boolean[] visited = new boolean[n + 1];
        perm(n, n, visited, nums);
    }

    private void perm(int n, int r, boolean[] visited, int[] nums) { // LeftNum 는 정렬되어있음.
        if (r == 0) {
            // System.out.println(Arrays.toString(nums));

            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();

            return;
            // printArray
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums[n - r] = i;
                perm(n, r - 1, visited, nums);
                visited[i] = false;
            }
        }
    }
}
