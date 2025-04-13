package acmicpc6568;

import java.io.*;

/* 귀도 반 로썸은 크리스마스날 심심하다고 파이썬을 만들었다
 * https://www.acmicpc.net/problem/6568
구현.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] MEMORY = new int[32];
            int INST;
            int ADDER = 0;
            int PC = 0;

            for (int i = 0; i < 32; i++) {
                String line = bf.readLine();
                if (line == null || line.contentEquals("")) { // line이 null 이거나, contents가 "" 일 때까지 while true.
                    // break mainLoop;
                    System.out.print(sb);
                    return;
                }
                MEMORY[i] = (byte) Integer.parseInt(line, 2);
            }

            while (PC < 32) {
                // System.out.println(PC + " , " + ADDER);
                INST = MEMORY[PC++];
                PC = PC % 32;
                switch (INST & 0xE0) {
                    case 0x00: // STA x 메모리 주소 x에 가산기의 값을 저장한다.
                        MEMORY[INST & 0x1F] = ADDER;
                        break;
                    case 0x20: // LDA x 메모리 주소 x의 값을 가산기로 불러온다.
                        ADDER = MEMORY[INST & 0x1F] & 0xFF;
                        break;
                    case 0x40: // BEQ x 가산기의 값이 0이면 PC 값을 x로 바꾼다.
                        if (ADDER == 0) {
                            PC = INST & 0x1F;
                        }
                        break;
                    case 0x60: // NOP
                        break;
                    case 0x80: // DEC 가산기 값을 1 감소시킨다.
                        ADDER = (ADDER - 1) & 0xFF;
                        // ADDER = (ADDER + 255) % 256;

                        break;
                    case 0xA0: // INC 가산기 값을 1 증가시킨다.
                        ADDER = (ADDER + 1) & 0xFF;
                        // ADDER = (ADDER + 1) % 256;
                        break;
                    case 0xC0: // PC 값을 x로 바꾼다.
                        PC = INST & 0x1F;
                        break;
                    case 0xE0: // 프로그램을 종료한다.
                        PC = 32;
                        break;
                }
            }
            
            for (int j = 7; j >= 0; j--) {
                sb.append((ADDER >> j) & 1);
            }
            sb.append("\n");
        }
    }
}
