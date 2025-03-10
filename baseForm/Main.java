package baseForm;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        ArrayList <Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < K) {
                nums.add(num);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : nums) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
        
    }
}
