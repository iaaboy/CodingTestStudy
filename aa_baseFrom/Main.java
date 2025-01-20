package aa_baseFrom;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(bf.readLine());
        char [] ej = bf.readLine().toCharArray();
        char [][] mbti = {
            {'E','S','T','J'},
            {'I','N','F','P'}
        };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char result = ej[i] != mbti[0][i] ? mbti[0][i] : mbti[1][i];
            sb.append(result);
        }


        System.out.println(sb);
    }
}
