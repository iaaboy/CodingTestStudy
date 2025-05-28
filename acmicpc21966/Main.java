package acmicpc21966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* (중략)
 * https://www.acmicpc.net/problem/21966
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();
        String sentence = bf.readLine();
        // size 25이하
        if (sentence.length() <= 25) {
            System.out.println(sentence);
        } else {

            // 11 ~ 11 사이가 한문장 ... 점이 없다.
            // 0 ~ 10 ... 11 ~ N - 1 - 10 -1 ... N - 1 - 10 ~ N-1

            int N = sentence.length();
            char[] senMid = sentence.substring(11, N - 1 - 10).toCharArray();
            boolean hasDot = false;
            for (int i = 1; i < senMid.length - 1; i++) {
                if (senMid[i] == '.') {
                    hasDot = true;
                    break;
                }
            }

            if (!hasDot) {
                String pre = sentence.substring(0, 11);
                String post = sentence.substring(N - 11, N);
                String mid = "...";
                System.out.println(pre + mid + post);
            } else {
                String pre = sentence.substring(0, 9);
                String post = sentence.substring(N - 10, N);
                String mid = "......";
                System.out.println(pre + mid + post);
            }

        }

    }
}
