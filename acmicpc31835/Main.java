package acmicpc31835;

import java.io.*;
import java.util.StringTokenizer;

/*
9
T & T | F | T & T
F
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int count = 0;
        boolean [] input = new boolean[N / 2 + 1];
        char [] operator = new char [N/2];

        int iIndex = 0;
        int oIndex = 0;
        for (int i = 0; i < operator.length; i++) {
            if(i%2 == 0) {
                input[iIndex++] = st.nextToken().charAt(0) == 'T';
            } else {
                operator[oIndex++] = st.nextToken().charAt(0);
            }
        }
        boolean wanted = bf.readLine().charAt(0) == 'T';

        for (int i = 0; i < operator.length; i++) {
            if (wanted) { // true
                if (operator[i] == '|') {
                    
                } else {
                    
                }
            } else {

            }
        }

        System.out.println(count);
    }
}
