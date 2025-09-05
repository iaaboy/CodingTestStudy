package acmicpc33718;

import java.io.*;
import java.util.*;

public class Main {
    static long T;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(bf.readLine());
        long[] num = new long[6];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 6; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }
        for (int i = 0; i < 6; i++) {
            if (num[i] == T) {
                System.out.println(0);
                return;
            }
        }
        Stack<Character> op = new Stack<>();
        Stack<Long> usedNum = new Stack<>();
        calulate(num, usedNum, op, 6);
        if (!resultReported) {
            System.out.println(-1);
        }
    }

    static boolean resultReported = false;

    private static void calulate(long[] num, Stack<Long> usedNum, Stack<Character> op, int numLeft) {
        if (numLeft <= 1 || resultReported) {
            return;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (num[i] != -1 && num[j] != -1) {
                    for (int t = 0; t < 2; t++) {
                        if (resultReported) {
                            return;
                        }
                        long a = t == 0 ? num[i] : num[j];
                        long b = t == 0 ? num[j] : num[i];

                        long c;
                        if (t == 0) {
                            /// +
                            c = a + b;
                            if (c == T) {
                                usedNum.push(c);
                                usedNum.push(b);
                                usedNum.push(a);
                                op.push('+');
                                reportResult(usedNum, op);
                                resultReported = true;
                                return;
                            }
                            num[i] = -1;
                            num[j] = c;
                                usedNum.push(c);
                                usedNum.push(b);
                                usedNum.push(a);
                            op.push('+');
                            calulate(num, usedNum, op, numLeft - 1);
                            if (resultReported) {
                                return;
                            }
                            op.pop();
                            usedNum.pop();
                            usedNum.pop();
                            usedNum.pop();
    
                            /// *
                            c = a * b;
                            if (c == T) {
                                usedNum.push(c);
                                usedNum.push(b);
                                usedNum.push(a);
                                op.push('*');
                                reportResult(usedNum, op);
                                resultReported = true;
                                return;
                            }
                            num[j] = c;
                                usedNum.push(c);
                                usedNum.push(b);
                                usedNum.push(a);
                            op.push('*');
                            calulate(num, usedNum, op, numLeft - 1);
                            if (resultReported) {
                                return;
                            }
                            op.pop();
                            usedNum.pop();
                            usedNum.pop();
                            usedNum.pop();
                        }

                        /// /
                        if (b != 0) {
                            c = a / b;
                            if (c == T) {
                            usedNum.push(c);
                            usedNum.push(b);
                            usedNum.push(a);
                                op.push('/');
                                reportResult(usedNum, op);
                                resultReported = true;
                                return;
                            }
                            num[j] = c;
                            usedNum.push(c);
                            usedNum.push(b);
                            usedNum.push(a);
                            op.push('/');
                            calulate(num, usedNum, op, numLeft - 1);
                            if (resultReported) {
                                return;
                            }
                            op.pop();
                            usedNum.pop();
                            usedNum.pop();
                            usedNum.pop();
                        }


                        /// -
                        c = a - b;
                        if (c >= 0) {
                            if (c == T) {
                            usedNum.push(c);
                            usedNum.push(b);
                            usedNum.push(a);
                                op.push('-');
                                reportResult(usedNum, op);
                                resultReported = true;
                                return;
                            }
                            num[j] = c;
                            usedNum.push(c);
                            usedNum.push(b);
                            usedNum.push(a);
                            op.push('-');
                            calulate(num, usedNum, op, numLeft - 1);
                            if (resultReported) {
                                return;
                            }
                            op.pop();
                            usedNum.pop();
                            usedNum.pop();
                            usedNum.pop();
                        }


                        num[i] = t == 0 ? a : b;
                        num[j] = t == 0 ? b : a;
                    }
                }
            }
        }
    }

    private static void reportResult(Stack<Long> usedNum, Stack<Character> op) {
        StringBuilder sb = new StringBuilder();
        
        // System.out.println(usedNum);
        // System.out.println(op);
        int opsize = op.size();
        while (!usedNum.empty()) {
            sb.insert(0, (usedNum.pop() + " " + op.pop() + " " + usedNum.pop() + " = " + usedNum.pop()+ "\n"));
        }
        sb.insert(0, opsize + "\n");
        System.out.print(sb);
    }
}
