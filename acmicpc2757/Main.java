package acmicpc2757;

import java.io.*;

/* 엑셀
 * https://www.acmicpc.net/problem/2757
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int r = 1, c = 1;
        StringBuilder sb = new StringBuilder();
        while (r != 0 && c != 0) {
            String inStr = bf.readLine();
            String[] nStr = inStr.split("R|C");
            r = Integer.parseInt(nStr[1]);
            c = Integer.parseInt(nStr[2]);
            if(r==0 && c==0)
                break;
            sb.append(rToStr(c) + Integer.toString(r) + "\n");
        }
        System.out.print(sb);
    }

    private static String rToStr(int r) {
        if (r / 27 == 0) {
            return Character.toString('A' -1 + (r % 27));
        }
        String num = Character.toString('A' + ((r - 1) % 26));
        return rToStr((r - 1 )/ 26) + num;
    }
}
