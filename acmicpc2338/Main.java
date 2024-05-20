package acmicpc2338;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        BigInteger A = new BigInteger(bf.readLine());
        BigInteger B = new BigInteger(bf.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append((A.add(B)) + "\n");
        sb.append((A.subtract(B)) + "\n");
        sb.append((A.multiply(B)) + "\n");
        System.out.println(sb);
    }
}
