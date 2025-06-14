package acmicpc32859;

import java.io.*;
import java.util.*;

/* 그런 사람은 없었습니다
 * https://www.acmicpc.net/problem/32859
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(bf.readLine());
        ArrayList<Form> f = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        // StringBuilder sb = new StringBuilder();
        boolean[] isRegistered = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            boolean isPay = Integer.parseInt(st.nextToken()) == 1;
            if (isPay) {
                if (!isRegistered[num]) {
                    f.add(new Form(num, S));
                }

            } else {
                ArrayList<Form> removalIdx = new ArrayList<>();
                isRegistered[num] = true;
                for (int j = 0; j < f.size(); j++) {
                    Form cf = f.get(j);
                    if (cf.num == num) {
                        removalIdx.add(cf);
                    } else {
                        cf.left--;
                        if (cf.left == 0) {
                            removalIdx.add(cf);
                            result.add(cf.num);
                        }
                    }
                }
                f.removeAll(removalIdx);
                // sb.append(num + ":" + removalIdx).append("\n");
            }
        }
        // System.out.println(result);
        result.sort(null);
        if (result.size() == 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (Integer result2 : result) {
                sb.append(result2).append("\n");
            }
            System.out.print(sb);
        }
        // System.out.println(f);
        // System.out.print(sb);
    }

    static class Form {
        int num;
        int left;

        public Form(int num, int left) {
            this.num = num;
            this.left = left;
        }

        @Override
        public String toString() {
            return num + "," + left;
        }
    }
}
