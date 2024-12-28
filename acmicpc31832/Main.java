package acmicpc31832;

import java.io.*;

/* 팀명 정하기 2
 * https://www.acmicpc.net/problem/31832
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] name = bf.readLine().toCharArray();
            int cntLarge = 0;
            int cntSmall = 0;
            int cntHipen = 0;
            for (int j = 0; j < name.length; j++) {
                if (name[j] == '-') {
                    cntHipen++;
                }
                if (name[j] >= 'a' && name[j] <= 'z') {
                    cntSmall++;
                }
                if (name[j] >= 'A' && name[j] <= 'Z') {
                    cntLarge++;
                }
            }
            if (name.length > 10) {
                continue;
            }
            if (cntLarge == 0 && cntSmall == 0 && cntHipen == 0) {
                continue;
            }
            if (cntSmall < cntLarge) {
                continue;
            }

            for (int j = 0; j < name.length; j++) {
                sb.append(name[j]);
            }
            sb.append("\n");
            break;
        }
        if (sb.length() > 0) {
            System.out.print(sb);
        }
    }
}
