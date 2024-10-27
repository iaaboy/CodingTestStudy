package acmicpc15663;

import java.io.*;
import java.util.*;

/* N과 M (9)
 * https://www.acmicpc.net/problem/15663
 */

public class Main {
    static HashSet<ArrayList<Integer>> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        
        st = new StringTokenizer(bf.readLine());
        // Set<Integer> aSet = new HashSet<>();
        // for (int i = 0; i < N; i++) {
        //     aSet.add(Integer.parseInt(st.nextToken()));
        // }
        // N = aSet.size();
        // int[] arr = new int[aSet.size()];
        // int idx = 0;
        // for (Integer n : aSet) {
        //     arr[idx++] = n;
        // }
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        permutation(arr, 0, N, M);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(answer);
        ans.sort((a, b) -> {
            int count = a.size();
            for (int i = 0; i < count; i++) {
                if (a.get(i) > b.get(i)) {
                    return 1;
                } else if (a.get(i) < b.get(i)) {
                    return -1;
                }
            }
            return -1;
        });
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> aa : ans) {
            for (Integer i : aa) {
                sb.append(i + " ");
            }
            sb.append("\n");        
        }
        System.out.print(sb);
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            ArrayList<Integer> mList = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                mList.add(arr[i]);
            }
            answer.add(mList);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}

