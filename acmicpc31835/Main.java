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
        String inStr = bf.readLine();
        boolean tf = bf.readLine().charAt(0) == 'T';
        int count = 0;
        inStr = inStr.replace(" ","");
        inStr = inStr.substring(0, N);
        if (tf) { // T and 기준
            String[] s = inStr.split("&");
            for (String wd : s) {
                if (!wd.contains("T")) {
                    count++;
                }
            }
        } else { // F or 기준
            String[] s = inStr.split("\\|");
            for (String wd : s) {
                if (!wd.contains("F")) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

/*
9
T | T | T | T | T
T
 */
