package acmicpc21737;

import java.io.*;
import java.util.*;

/* SMUPC 계산기
 * https://www.acmicpc.net/problem/21737
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String inExp = bf.readLine();
        int[] op = new int[N];
        int opIdx = 0;
        boolean cAppeared = false;
        for (int i = 0; i < inExp.length(); i++) {
            char ch = inExp.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                op[opIdx++] = i;
                if (!cAppeared) {
                    if (ch == 'C') {
                        cAppeared = true;
                    }
                }
            }
        }
        if (!cAppeared) {
            System.out.println("NO OUTPUT");
        } else {
            String[] nums = inExp.split("C|S|M|U|P");
            ArrayList<Integer> numbers = new ArrayList<>();
            for (String st : nums) {
                if (!st.isEmpty()) {
                    numbers.add(Integer.parseInt(st));
                }
            }
            // System.out.println(numbers);

            // StringBuilder testLogSb = new StringBuilder();

            int result = numbers.get(0);
            int numIdx = 1;
            StringBuilder resultSb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                if (inExp.charAt(op[i]) == 'C') {
                    resultSb.append(result + " ");
                } else {
                    if (numIdx >= numbers.size()) {
                        continue;
                    }
                    if (inExp.charAt(op[i]) == 'S') {
                        result -= numbers.get(numIdx++);
                    } else if (inExp.charAt(op[i]) == 'M') {
                        result *= numbers.get(numIdx++);
                    } else if (inExp.charAt(op[i]) == 'U') {
                        result /= numbers.get(numIdx++);
                    } else if (inExp.charAt(op[i]) == 'P') {
                        result += numbers.get(numIdx++);
                    }
                }
                // testLogSb.append(inExp.charAt(op[i]) + " ");
            }
            // System.out.println(testLogSb);
            System.out.println(resultSb);
        }

    }
}
