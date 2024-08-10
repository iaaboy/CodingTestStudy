package acmicpc4836;

import java.io.*;
import java.util.*;

/* 춤
 * https://www.acmicpc.net/problem/4836
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = bf.readLine()) != null) {
            String[] inStr = line.split(" ");
            ArrayList<Integer> failRecord = new ArrayList<>();

            // 1
            // dip은 jiggle을 춘 다음이나 다다음, 또는 twirl을 추기 전에 출 수 있다. 예를 들면 다음과 같다.
            // ...jiggle dip...
            // ...jiggle stomp dip...
            // ...dip twirl...
            ArrayList<Integer> dipIdx = new ArrayList<>();
            for (int i = 0; i < inStr.length; i++) {
                if (inStr[i].contentEquals("dip")) {
                    dipIdx.add(i);
                }
            }
            boolean dipPassed = false;
            ArrayList<Integer> dipFailRecord = new ArrayList<>();
            for (Integer idx : dipIdx) {
                dipPassed = false;
                if (idx - 1 >= 0 && inStr[idx - 1].contentEquals("jiggle")) {
                    dipPassed = true;
                } else if (idx - 2 >= 0 && inStr[idx - 2].contentEquals("jiggle")) {
                    dipPassed = true;
                } else if (idx + 1 < inStr.length && inStr[idx + 1].contentEquals("twirl")) {
                    dipPassed = true;
                }
                if (!dipPassed) {
                    dipFailRecord.add(idx);
                }
            }
            if (dipFailRecord.size() > 0) {
                failRecord.add(1);
            }

            // 2
            // 모든 춤은 clap stomp clap으로 끝나야 한다.
            if (inStr.length < 3 || !inStr[inStr.length - 3].contentEquals("clap") ||
                    !inStr[inStr.length - 2].contentEquals("stomp") ||
                    !inStr[inStr.length - 1].contentEquals("clap")) {
                failRecord.add(2);
            }

            // 3
            // 만약 twirl을 췄다면, hop도 춰야한다.
            boolean hasTwirl = false;
            for (int i = 0; i < inStr.length; i++) {
                if (inStr[i].contentEquals("twirl")) {
                    hasTwirl = true;
                    break;
                }
            }
            boolean hasHop = false;
            if (hasTwirl) {
                for (int i = 0; i < inStr.length; i++) {
                    if (inStr[i].contentEquals("hop")) {
                        hasHop = true;
                        break;
                    }
                }
            }
            if (hasTwirl && !hasHop) {
                failRecord.add(3);
            }

            // 4
            // jiggle로 춤을 시작할 수 없다.
            if (inStr[0].contentEquals("jiggle")) {
                failRecord.add(4);
            }
            // dip twirl hop jiggle hop hop clap clap stomp
            // 5
            // 반드시 dip을 춰야 한다.
            boolean hasDip = false;
            for (int i = 0; i < inStr.length; i++) {
                if (inStr[i].contentEquals("dip")) {
                    hasDip = true;
                    break;
                }
            }
            if (!hasDip) {
                failRecord.add(5);
            }

            int failCount = failRecord.size();

            StringBuilder sb = new StringBuilder();
            if (failCount == 0) {
                sb.append("form ok");
            } else if (failCount == 1) {
                sb.append("form error");
                sb.append(" " + failRecord.get(0));
            } else {
                sb.append("form errors");
                for (Integer f : failRecord) {
                    failCount--;
                    if (failCount > 1) {
                        sb.append(" " + f + ",");
                    } else if (failCount == 1) {
                        sb.append(" " + f + " and");
                    } else {
                        sb.append(" " + f);
                    }
                }
            }
            sb.append(":");
            for (Integer i : dipFailRecord) {
                inStr[i] = "DIP";
            }
            for (String s : inStr) {
                sb.append(" " + s);
            }

            System.out.println(sb);
        }
    }
}
