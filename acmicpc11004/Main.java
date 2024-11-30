package acmicpc11004;

import java.io.*;
import java.util.*;

/* K번째 수
 * https://www.acmicpc.net/problem/11004
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List <Integer> arr = new ArrayList<>(N);
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        System.out.println(arr.get(K-1));
    }
}
