package acmicpc2553;

import java.io.*;
import java.math.BigInteger;

/* 마지막 팩토리얼 수
 * https://www.acmicpc.net/problem/2553
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bf.readLine());
        System.out.println(Solve(N));
        // Solve2((int)N);
        // for (int i = 1; i < 20001 ; i++) {
        //     if (i % 100 == 0) {
        //         // System.out.print("doing " + i);
        //     }
            
        //     if (Solve((long)i) != Solve2(i)) {
        //         System.out.println("Something Wrong" + i + "  " + Solve((long)i) + " .. " + Solve2(i));
        //         System.out.println(SolveReal(i));
        //     }
        // }
        // System.out.println(getLastDigit(realFact.toString()));
    }

    private static int SolveReal(long N) { //검증 코드
        BigInteger realFact = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            realFact = realFact.multiply(new BigInteger(Integer.toString(i)));
        }


        long oriCalc = getLastDigit(realFact.toString());
        return (int)oriCalc;
    } 

    private static int Solve(Long N) {
        long fact = 1;
        // BigInteger realFact = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            fact *= (long)i;
            fact = getLastDigit(fact);
            // realFact = realFact.multiply(new BigInteger(Integer.toString(i)));
        }
        long myCalc = getLastDigit(Long.toString(fact));
        // System.out.println(myCalc);
        return (int)myCalc;
        // long oriCalc = getLastDigit(realFact.toString());
        // if (N % 100 == 0) {
        //     System.out.println(N + ":" + myCalc + " , " + oriCalc);
        // }
        
        // if (myCalc != oriCalc) {
        //     System.out.println(N + ":" + myCalc + " , " + oriCalc);
        //     System.out.println("Something Wrong");
        // }
    }

    private static long getLastDigit(long fact) {
        //뒤에 0을 없앤다.
        while (fact % 10 == 0) {
            fact /= 10;
        }
        //앞에 숫자를 없앤다.
        return fact % 10000000000l;
    }
    private static int getLastDigit(String num) {
        char [] c = num.toCharArray();
         for (int i = c.length - 1; i >= 0; i--) {
             if (c[i] != '0') {
                 return c[i] - '0';
             }
         }
         return 1; 
     }
}

