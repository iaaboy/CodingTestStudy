package acmicpc19940;

import java.io.*;

/* 피자 오븐
 * https://www.acmicpc.net/problem/19940
 */

public class Main {
    static int addhour, addTen, minTen, addOne, minOne;
    static int total = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            addhour = addTen = minTen = addOne = minOne = 0;
            int min = Integer.parseInt(bf.readLine());
            total = Integer.MAX_VALUE;
            calculateButtonCount(min, 0, 0, 0, 0);
            sb.append(addhour + " " + addTen + " " + minTen + " " + addOne + " " + minOne).append("\n");
        }
        System.out.print(sb);
    }

    private static void calculateButtonCount(int min, int step, int h, int mt, int m) {
        // System.out.println(step + ":" + min + "," + h + "," + mt + "," + m);
        if (step == 0) {
            if (min % 10 == 0) {
                calculateButtonCount(min, 1, h, mt, m);
            } else {
                calculateButtonCount(min - min % 10, 1, h, mt, (min % 10));
                calculateButtonCount(min + (10 - min % 10), 1, h, mt, -(10 - min % 10));
            }
        } else if (step == 1) {
            // 60단위
            if (min % 60 == 0) {
                calculateButtonCount(min, 2, h, mt, m);
            } else {
                calculateButtonCount(min - min % 60, 2, h, (min % 60) / 10, m);
                calculateButtonCount(min + (60 - min % 60), 2, h, -(60 - min % 60) / 10, m);
            }
        } else if (step == 2) {
            // 시간 계산 및 최종
            int totalCount = Math.abs(min / 60) + Math.abs(mt) + Math.abs(m);
            // System.out.println("Result " + totalCount + ":" + (min / 60) + "," + mt + ","
            // + m);
            setMax(min / 60, mt, m);
            return;
        }
    }

    private static void setMax(int h, int mt, int m) {
        int subTotal = h + Math.abs(mt) + Math.abs(m);
        boolean needUpdate = false;
        if (subTotal < total) {
            needUpdate = true;
        } else if (subTotal == total) {
            if (addhour > h) {
                needUpdate = true;
            } else if (addhour == h) {
                if (addTen > Math.abs(mt)) { // 절대값
                    needUpdate = true;
                } else if (addTen == mt) {
                    if (addOne > Math.abs(m)) { // 절대값
                        needUpdate = true;
                    }
                }
            }
        }
        if (needUpdate) {
            updateValue(h, mt, m, subTotal);
        }
    }

    private static void updateValue(int h, int mt, int m, int subTotal) {
        total = subTotal;
        addhour = h;
        addTen = mt > 0 ? mt : 0;
        minTen = mt < 0 ? -mt : 0;
        addOne = m > 0 ? m : 0;
        minOne = m < 0 ? -m : 0;
    }
}

// 시간 , 10분 추가, 삭제, 1분 추가 삭제
// addH > addT > MINT > addO > mino