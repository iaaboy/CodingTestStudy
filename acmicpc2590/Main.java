package acmicpc2590;

import java.io.*;

/* 색종이
 * https://www.acmicpc.net/problem/2590
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] data = new int[7];
        int[] remained = new int[7];
        for (int i = 1; i < 7; i++) {
            data[i] = Integer.parseInt(bf.readLine());
        }
        int panCount = 0;

        StringBuilder sb = new StringBuilder();

        // handle 6
        panCount += data[6];
        sb.append("handle6 : " + panCount + "\n");

        // handle 5
        panCount += data[5];
        remained[1] += 11 * data[5];
        sb.append("handle5 : " + panCount + " " + data[5] + " - " + remained[2] + " " + remained[1] + "\n");

        // handle 4
        panCount += data[4];
        remained[2] += 5 * data[4];
        sb.append("handle4 : " + panCount + " " + data[4] + " - " + remained[2] + " " + remained[1] + "\n");

        // handle 3
        panCount += (data[3] / 4);
        if (data[3] % 4 > 0) {
            panCount++;
            if (data[3] % 4 == 1) {
                remained[2] += 5;
                remained[1] += 7;
            } else if (data[3] % 4 == 2) {
                remained[2] += 3;
                remained[1] += 6;
            } else if (data[3] % 4 == 3) {
                remained[2] += 1;
                remained[1] += 5;
            }
        }

        sb.append("handle3 : " + panCount + " " + data[3] + " - " + remained[2] + " " + remained[1] + "\n");

        // handle 2
        if (remained[2] >= data[2]) {
            remained[2] -= data[2];
            remained[1] += (remained[2] * 4);
            remained[2] = 0;
        } else {
            data[2] -= remained[2];
            remained[2] = 0;
            panCount += (data[2] / 9);

            if (data[2] % 9 > 0) {
                panCount++;
                remained[1] += (36 - (data[2] % 9) * 4);
            }
        }

        sb.append("handle2 : " + panCount + " " + data[2] + " - " + remained[2] + " " + remained[1] + "\n");

        // handle 1
        if (remained[1] >= data[1]) {
            remained[1] -= data[1];
        } else {
            data[1] -= remained[1];
            panCount += data[1] / 36;
            if (data[1] % 36 > 0) {
                panCount++;
            }
        }

        sb.append("handle1 : " + panCount + " " + data[1] + " - " + remained[2] + " " + remained[1] + "\n");

        // System.out.println(sb);
        System.out.println(panCount);
    }
}
