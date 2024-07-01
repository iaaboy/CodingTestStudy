package acmicpc16960;

import java.io.*;
import java.util.*;

/* 스위치와 램프
 * https://www.acmicpc.net/problem/16960
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] nums = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int T = Integer.parseInt(st.nextToken());
            nums[i] = new ArrayList<>(T);
            for (int j = 0; j < T; j++) {
                nums[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        boolean[] swc = new boolean[N];
        Arrays.fill(swc, true);

        for (int i = 0; i < swc.length; i++) {
            if (i - 1 >= 0)
                swc[i - 1] = true;
            swc[i] = false;
            if (checkSwitch(swc, nums, M)) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }

    private static boolean checkSwitch(boolean[] swc, ArrayList<Integer>[] nums, int M) {
        boolean[] result = new boolean[M];
        for (int i = 0; i < swc.length; i++) {
            if (swc[i]) {
                for (Integer sw : nums[i]) {
                    result[sw] = true;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (!result[i]) {
                return false;
            }
        }

        return true;
    }
}
